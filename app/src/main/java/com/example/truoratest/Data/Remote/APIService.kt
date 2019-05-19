package com.example.truoratest.Data.Remote

import com.example.truoratest.Data.Local.Entities.Host
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface APIService {

    @GET("api/v3/analyze")
    fun getHostInfo(@QueryMap host: Map<String, String>): Single<Host>
}