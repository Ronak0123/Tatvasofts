package com.ronak.gopani.model

import com.ronak.gopani.model.api.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository {

    // GET repo list
    fun getRepoList(onResult: (isSuccess: Boolean, response: RResponse?) -> Unit) {

        ApiClient.instance.getRepo().enqueue(object : Callback<RResponse> {
            override fun onResponse(call: Call<RResponse>?, response: Response<RResponse>?) {

                if (response != null && response.isSuccessful)
                    onResult(true, response.body()!!)
                else
                    onResult(false, null)
            }

            override fun onFailure(call: Call<RResponse>?, t: Throwable?) {
                onResult(false, null)
            }

        })
    }

    companion object {
        private var INSTANCE: Repository? = null
        fun getInstance() = INSTANCE ?: Repository().also {
                    INSTANCE = it
        }
    }
}