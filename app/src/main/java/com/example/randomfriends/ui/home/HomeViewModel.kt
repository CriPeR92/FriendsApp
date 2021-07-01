package com.example.randomfriends.ui.home

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.randomfriends.base.BaseViewModel
import com.example.randomfriends.data.repository.Callback
import com.example.randomfriends.data.repository.FriendsRepository
import com.example.randomfriends.model.FriendsResponse
import com.example.randomfriends.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(application: Application) : BaseViewModel(application), Callback {

    private val friendsRepository = FriendsRepository()
    var friendsResponse = MutableLiveData<FriendsResponse>()
    var friendSelected = MutableLiveData<User>()
    val hideProgress = MutableLiveData(0)

    /**
     * use of coroutine to call service getFriends()
     */
    fun getFriends() {
        hideProgress.postValue(1)
        viewModelScope.launch(Dispatchers.IO) {
            friendsRepository.getFriends(this@HomeViewModel)
        }
    }

    /**
     * Function when click on item of recyclerView
     */
    fun onClickActionGridAdapter(user: User) {
        friendSelected.postValue(user)
    }

    /**
     * onSuccess
     */
    override fun onSuccess(response: FriendsResponse) {
        hideProgress.postValue(0)
        friendsResponse.postValue(response)
    }

    override fun onFailed(errorResponse: String) {
        hideProgress.postValue(0)
    }
}