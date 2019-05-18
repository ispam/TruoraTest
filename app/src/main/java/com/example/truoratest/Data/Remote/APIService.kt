package com.example.truoratest.Data.Remote

import com.example.truoratest.Data.Local.Host
import io.reactivex.Single
import retrofit2.http.GET

interface APIService {

    @GET("api/v3/analyze?host=")
    fun getHostInfo(): Single<Host>
}