package com.example.attendancesystemandroid.ui.fragment.sort

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.attendancesystemandroid.data.model.User
import com.example.attendancesystemandroid.databinding.FragmentSortBinding
import com.example.attendancesystemandroid.utils.Resource
import com.example.attendancesystemandroid.utils.showToast
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartModel
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType
import com.github.aachartmodel.aainfographics.aachartcreator.AAChartType.*
import com.github.aachartmodel.aainfographics.aachartcreator.AASeriesElement
import com.google.gson.Gson
import com.scwang.smart.refresh.footer.ClassicsFooter
import com.scwang.smart.refresh.header.ClassicsHeader


class SortFragment : Fragment() {
    private lateinit var sortViewModel: SortViewModel
    private var binding: FragmentSortBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSortBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeUsers()

        setupRefreshLayout()

    }

    private fun setupRefreshLayout() {

        binding?.refreshLayout?.setRefreshHeader(ClassicsHeader(context))
        binding?.refreshLayout?.setRefreshFooter(ClassicsFooter(context))
        binding?.refreshLayout?.setOnRefreshListener { refreshlayout ->
            observeUsers()
            refreshlayout.finishRefresh(0)

        }
        binding?.refreshLayout?.setOnLoadMoreListener { refreshlayout ->
            refreshlayout.finishLoadMore(0)

        }
    }

    private fun drawChart() {
        val aaChartModel = AAChartModel()
            .chartType(AAChartType.Area)
            .title("title")
            .subtitle("subtitle")
            .backgroundColor("#4b2b7f")
            .series(arrayOf(
                AASeriesElement()
                    .name("Tokyo")
                    .data(arrayOf(7.0, 6.9, 9.5, 14.5, 18.2, 21.5, 25.2, 26.5, 23.3, 18.3, 13.9, 9.6)),
                AASeriesElement()
                    .name("NewYork")
                    .data(arrayOf(0.2, 0.8, 5.7, 11.3, 17.0, 22.0, 24.8, 24.1, 20.1, 14.1, 8.6, 2.5)),
                AASeriesElement()
                    .name("London")
                    .data(arrayOf(0.9, 0.6, 3.5, 8.4, 13.5, 17.0, 18.6, 17.9, 14.3, 9.0, 3.9, 1.0)),
                AASeriesElement()
                    .name("Berlin")
                    .data(arrayOf(3.9, 4.2, 5.7, 8.5, 11.9, 15.2, 17.0, 16.6, 14.2, 10.3, 6.6, 4.8))
            )
            )
        /*图表视图对象调用图表模型对象,绘制最终图形*/
        binding?.aaChartView?.aa_drawChartWithChartModel(aaChartModel)

    }

    private fun observeUsers() {
        // 创建 sortViewModel 对象
        sortViewModel = ViewModelProvider(this)[SortViewModel::class.java]
        // 观察 getUsers 方法返回的 LiveData 对象
        sortViewModel.getUsers().observe(viewLifecycleOwner) { resource ->
            when (resource.status) {
                Resource.Status.LOADING -> {}

                Resource.Status.SUCCESS -> {

                    val data = resource.data?.body().toString()
                    // 从字符串中提取JSON数据
                    val regex = "\\[(.*?)]".toRegex()
                    val matchResult = regex.find(data)
                    val jsonData = matchResult?.value
                    val gson = Gson()
                    val userData = gson.fromJson(jsonData, User::class.java)

                    Log.d("firstTAG", "onViewCreated: $userData")

                    drawChart()

                }

                Resource.Status.ERROR -> {
                    "请连接校园网".showToast()
                    // 处理错误状态
                }
            }
        }
    }
}