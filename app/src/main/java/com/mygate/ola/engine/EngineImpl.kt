package com.mygate.ola.engine

import com.mygate.ola.model.GitApiData
import org.greenrobot.eventbus.EventBus
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class EngineImpl : IEngine {
    override fun getGitData() {
        val apiInterface = APIClient.client?.create(ApiInterface::class.java)
        apiInterface?.let {
            it.getRepoList()?.enqueue(object : Callback<List<GitApiData?>?> {
                override fun onFailure(call: Call<List<GitApiData?>?>, t: Throwable) {
                    call.cancel()
                }

                override fun onResponse(
                    call: Call<List<GitApiData?>?>,
                    response: Response<List<GitApiData?>?>
                ) {
                    if (response.body() != null && response.body()!!.size > 0) {
                        EventBus.getDefault().post(object : IGitHubList {
                            override fun getData(): List<GitApiData?>? {
                                return response.body()
                            }
                        })
                    }
                }

            })
        }

    }

}