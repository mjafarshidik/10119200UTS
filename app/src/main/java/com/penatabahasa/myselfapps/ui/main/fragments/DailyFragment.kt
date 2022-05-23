package com.penatabahasa.myselfapps.ui.main.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.penatabahasa.myselfapps.adapter.DailyAdapter
import com.penatabahasa.myselfapps.adapter.FriendListAdapter
import com.penatabahasa.myselfapps.databinding.FragmentDailyBinding
import com.penatabahasa.myselfapps.helper.ViewModelFactory
import com.penatabahasa.myselfapps.viewmodel.DailyActivityViewModel
import com.penatabahasa.myselfapps.viewmodel.FriendListViewModel

/*
22 Mei 2022
10119200
Muhammad Jafar Shidik
IF-5
*/

class DailyFragment : Fragment() {
    private var _binding: FragmentDailyBinding? = null
    private val binding get() = _binding!!
    private lateinit var friendListAdapter: FriendListAdapter
    private lateinit var dailyAdapter: DailyAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDailyBinding.inflate(inflater, container, false)
        showDailyActivityList()
        showFriendList()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showDailyActivityList()
        showFriendList()
    }

    override fun onResume() {
        super.onResume()
        showDailyActivityList()
        showFriendList()
    }

    private fun showDailyActivityList() {
        binding.apply {
            val dailyActivityViewModel =
                obtainDailyViewModel(activity as AppCompatActivity)
            dailyActivityViewModel.getAllDailyActivities()
                .observe(viewLifecycleOwner) { dailyActivity ->
                    if (dailyActivity != null) {
                        dailyAdapter.setListDailyActivity(dailyActivity)
                        Log.d("Data", dailyActivity.toString())
                    } else {
                        Toast.makeText(activity, "listDailyActivity is null", Toast.LENGTH_LONG)
                            .show()
                    }
                }

            dailyAdapter = DailyAdapter()
            rvDailyActivity.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)
            rvDailyActivity.adapter = dailyAdapter
        }
    }

    private fun showFriendList() {
        binding.apply {
            val friendListViewModel = obtainFriendViewModel(activity as AppCompatActivity)
            friendListViewModel.getAllFriendLists().observe(viewLifecycleOwner) { friendList ->
                if (friendList != null) {
                    friendListAdapter.setListFriend(friendList)
                    Log.d("Data", friendList.toString())
                }
            }

            friendListAdapter = FriendListAdapter()
            rvFriendList.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            rvFriendList.adapter = friendListAdapter
        }
    }

    private fun obtainDailyViewModel(activity: AppCompatActivity): DailyActivityViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[DailyActivityViewModel::class.java]
    }

    private fun obtainFriendViewModel(activity: AppCompatActivity): FriendListViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory)[FriendListViewModel::class.java]
    }

}