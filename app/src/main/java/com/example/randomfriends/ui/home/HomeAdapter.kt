package com.example.randomfriends.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.randomfriends.databinding.ItemFriendGridBinding
import com.example.randomfriends.model.User

/**
 * Adapter of the list of friends
 */

class HomeAdapter(var fragment: HomeFragment, var list: ArrayList<User>?) : RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {

    private lateinit var vm: HomeViewModel

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemFriendGridBinding.inflate(layoutInflater)
        vm = ViewModelProvider(fragment).get(HomeViewModel::class.java)

        return HomeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.binding.viewModel = vm
        holder.binding.user = list!![position]
    }

    class HomeViewHolder(val binding: ItemFriendGridBinding) : RecyclerView.ViewHolder(binding.root)

    override fun getItemCount(): Int {
        return list!!.size
    }
}