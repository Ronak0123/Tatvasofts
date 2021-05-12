package com.ronak.gopani.view.ui.homeList

import androidx.lifecycle.MutableLiveData
import com.ronak.gopani.model.Repository
import com.ronak.gopani.model.Users
import com.ronak.gopani.view.base.BaseViewModel

class RListViewModel : BaseViewModel() {
    val repoListLive = MutableLiveData<List<Users>>()

    fun fetchRepoList() {
        dataLoading.value = true
        Repository.getInstance().getRepoList { isSuccess, response ->
            dataLoading.value = false
            if (isSuccess) {

                repoListLive.value = response?.data?.users
                empty.value = false
            } else {
                empty.value = true
            }
        }
    }
}