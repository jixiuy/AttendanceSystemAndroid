package com.example.attendancesystemandroid.ui.fragment.sort

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.attendancesystemandroid.R
import com.example.attendancesystemandroid.data.model.User
import com.example.attendancesystemandroid.databinding.SortItemLayoutBinding

class SortAdapter(private val users: List<User>) : RecyclerView.Adapter<SortAdapter.ViewHolder>() {

    // 3. 创建ViewHolder类
    class ViewHolder(val binding: SortItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    // 4. 实现必要的方法
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding:SortItemLayoutBinding = DataBindingUtil.inflate(inflater,R.layout.sort_item_layout,parent,false)

        return ViewHolder(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.binding.userName.text = user.userName
        holder.binding.userId.text = user.userId.toString()
        holder.binding.userDept.text = user.userDept
        holder.binding.totalTime.text = user.totalTime
        holder.binding.userLocation.text = user.userLocation
        holder.binding.rank.text = (position+1).toString()
    }

    override fun getItemCount(): Int {
        return users.size
    }
}