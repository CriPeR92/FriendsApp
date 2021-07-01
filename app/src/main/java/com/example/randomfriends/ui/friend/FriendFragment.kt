package com.example.randomfriends.ui.friend

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.randomfriends.R
import com.example.randomfriends.databinding.FragmentFriendBinding


class FriendFragment : Fragment() {

    private lateinit var binding: FragmentFriendBinding
    private lateinit var viewModel: FriendViewModel
    private val args: FriendFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FriendViewModel::class.java)
        viewModel.image.value = args.image
        viewModel.name.value = args.firstname + " " + args.lastname
        viewModel.address.value = args.address
        viewModel.cellphone.value = args.cell
        viewModel.city.value = args.city
        viewModel.country.value = args.country
        viewModel.state.value = args.state
        viewModel.email.value = args.email

        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    val action = FriendFragmentDirections.goBack()
                    findNavController().navigate(action)
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_friend, container, false)
        binding.viewModel = this.viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        /**
         * Send Email to friend, try catch to capture event if not email app its installed
         */
        viewModel.sendEmail.observe(binding.lifecycleOwner!!, Observer {
            val mailto = "mailto:${viewModel.email.value}"
            val emailIntent = Intent(Intent.ACTION_SENDTO)
            emailIntent.data = Uri.parse(mailto)
            try {
                startActivity(emailIntent)
            } catch (e: ActivityNotFoundException) {
            }
        })
    }
}
