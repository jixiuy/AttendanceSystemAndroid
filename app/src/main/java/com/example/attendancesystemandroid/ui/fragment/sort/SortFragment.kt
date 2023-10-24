package com.example.attendancesystemandroid.ui.fragment.sort

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.attendancesystemandroid.R
import com.example.attendancesystemandroid.data.model.User
import com.example.attendancesystemandroid.databinding.FragmentSortBinding
import com.example.attendancesystemandroid.utils.Resource
import com.example.attendancesystemandroid.utils.showToast
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.scwang.smart.refresh.header.ClassicsHeader


class SortFragment(index: Int) : Fragment() {
    private lateinit var sortViewModel: SortViewModel
    private var binding: FragmentSortBinding? = null
    private lateinit var fadeInAnimation: Animation
    private val index = index
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSortBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    private fun initDrawChart(userList: List<User>) {
        val times = userList.map { it.totalTime.toDouble() }.sorted()
        val names = userList.map { it.userName }.reversed()

        val aaChartModel = AAChartModel()
            .chartType(AAChartType.Bar)
            .title("签到排名")
            .dataLabelsEnabled(true)
            .backgroundColor("#FFFFFF")
//            .tooltipEnabled(false)
            .legendEnabled(false)
            .touchEventEnabled(true)
            .yAxisTitle("")
            .colorsTheme(arrayOf("deepskyblue"))
            .categories(names.toTypedArray())
            .series(
                arrayOf(
                    AASeriesElement()
                        .name("时长")
                        .data(times.toTypedArray())

                )
            )

        binding?.aaChartView?.startAnimation(fadeInAnimation)
        binding?.aaChartView?.aa_drawChartWithChartModel(aaChartModel)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fadeInAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_in)

        observeUsers()

        setupRefreshLayout()

    }

    private fun setupRefreshLayout() {

        binding?.refreshLayout?.setRefreshHeader(ClassicsHeader(context))
        binding?.refreshLayout?.setOnRefreshListener { refreshlayout ->
            observeUsers()
            refreshlayout.finishRefresh(0)

        }

    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initRecyclerView(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<*>) {
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = adapter
        recyclerView.startAnimation(fadeInAnimation)
        adapter.notifyDataSetChanged()
    }
    private fun observeUsers() {
        // 创建 sortViewModel 对象
        sortViewModel = ViewModelProvider(this)[SortViewModel::class.java]
        // 观察 getUsers 方法返回的 LiveData 对象
        sortViewModel.getRank(index).observe(viewLifecycleOwner) { resource ->
            when (resource.status) {
                Resource.Status.LOADING -> {
                }

                Resource.Status.SUCCESS -> {

                    val data = resource.data?.body()

                    data?.data?.let { initDrawChart(it) }

                    binding?.let {
                        if (data != null) {
                            initRecyclerView(it.recyclerView,SortRVAdapter(data.data))
                        }
                    }
                }

                Resource.Status.ERROR -> {
                    "请连接校园网".showToast()
                    // 处理错误状态
                }
            }
        }


    }
}