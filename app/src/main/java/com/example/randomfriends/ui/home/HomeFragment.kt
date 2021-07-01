package com.example.randomfriends.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.randomfriends.R
import com.example.randomfriends.databinding.FragmentHomeBinding
import com.example.randomfriends.model.User

class HomeFragment : Fragment() {

    lateinit var adapter: HomeAdapter
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Observer to know when the friends are loaded, recyclerView is updated
         */
        viewModel.friendsResponse.observe(binding.lifecycleOwner!!, Observer {
            adapter = HomeAdapter(
                this,
                viewModel.friendsResponse.value?.results
            )
            binding.adapter = adapter
            adapter.notifyDataSetChanged()
        })

        /**
         * Observer to change fragment in navigation and pass arguments
         */
        viewModel.friendSelected.observe(binding.lifecycleOwner!!, Observer {
            val action =
                HomeFragmentDirections.actionHomefragmentToFriendfragment(
                    viewModel.friendSelected.value?.picture?.large.toString(),
                    viewModel.friendSelected.value?.name?.first.toString(),
                    viewModel.friendSelected.value?.name?.last.toString(),
                    viewModel.friendSelected.value?.location?.street?.name.toString(),
                    viewModel.friendSelected.value?.location?.city.toString(),
                    viewModel.friendSelected.value?.location?.state.toString(),
                    viewModel.friendSelected.value?.location?.country.toString(),
                    viewModel.friendSelected.value?.email.toString(),
                    viewModel.friendSelected.value?.cell.toString(),
                )
            findNavController().navigate(action)
        })

        viewModel.getFriends()
        adapter = HomeAdapter(this, ArrayList<User>())
        binding.adapter = adapter
    }
}