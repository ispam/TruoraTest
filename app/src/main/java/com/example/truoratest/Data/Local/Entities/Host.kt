package com.example.truoratest.Data.Local.Entities

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class Host(
    @SerializedName("host")
    var host: String,
    @SerializedName("port")
    var port: Long,
    @SerializedName("protocol")
    var protocol: String,
    @SerializedName("isPublic")
    var isPublic: Boolean,
    @SerializedName("status")
    var status: String,
    @SerializedName("startTime")
    var startTime: Long,
    @SerializedName("testTime")
    var testTime: Long,
    @SerializedName("engineVersion")
    var engineVersion: String,
    @SerializedName("criteriaVersion")
    var criteriaVersion: String
): Parcelable

