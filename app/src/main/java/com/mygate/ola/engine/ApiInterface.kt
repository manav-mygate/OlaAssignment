package com.mygate.ola.engine

import com.mygate.ola.model.GitApiData
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/repositories")
    fun getRepoList(): Call<List<GitApiData?>?>?

}