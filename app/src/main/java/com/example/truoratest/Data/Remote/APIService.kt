package com.example.truoratest.Data.Remote

import com.example.truoratest.Data.Local.Entities.Host
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {

    @GET("api/v3/analyze?host={host}")
    fun getHostInfo(@Path("host")host: String): Single<Host>
}