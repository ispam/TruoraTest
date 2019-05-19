package com.example.truoratest

import com.example.truoratest.Data.Local.Entities.Host
import com.example.truoratest.Data.Local.Entities.Record
import com.example.truoratest.Data.Local.ViewModel.RecordViewModel
import com.example.truoratest.Data.Remote.APIService
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Completable
import io.reactivex.Single
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class DomainLogicTests {

    val apiService = mockk<APIService>(relaxed = true)
    val recordVM = mockk<RecordViewModel>()

    @BeforeEach
    fun clear() {
        clearMocks(apiService, recordVM)
    }

    @Nested
    inner class HomeActivityTests {

        @Test
        fun `getHostInfo() method is not empty`() {

            val map = HashMap<String, String>()
            map["host"] = "truora.com"

            val host = Host(
                "truora.com",
                443,
                "http",
                false,
                "DNS",
                1558229937833,
                1558229937833,
                "1.34.2",
                "2009p"
            )

            every { apiService.getHostInfo(map) } returns Single.just(host)

            apiService.getHostInfo(map)
                .test()
                .assertSubscribed()
                .assertNoErrors()
                .assertResult(host)
                .assertComplete()
                .dispose()

        }
    }

    @Nested
    inner class DetailsActivityTests {

        @Test
        fun `createRecord() method is not empty`() {

            val record = Record("truora.com")

            every { recordVM.createRecord(record) } answers { Completable.complete() }

            recordVM.createRecord(record)
                .test()
                .assertSubscribed()
                .assertNoErrors()
                .assertComplete()
                .dispose()
        }

    }
}