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
    var criteriaVersion: String,
    @SerializedName("endpoints")
    var endpoints: @RawValue List<Endpoints> ?= null
): Parcelable

@Parcelize
data class Endpoints(
    @SerializedName("ipAddress")
    var ipAddress: String,
    @SerializedName("serverName")
    var serverName: String,
    @SerializedName("statusMessage")
    var statusMessage: String,
    @SerializedName("grade")
    var grade: String,
    @SerializedName("gradeTrustIgnored")
    var gradeTrustIgnored: String,
    @SerializedName("hasWarnings")
    var hasWarnings: Boolean,
    @SerializedName("isExceptional")
    var isExceptional: Boolean,
    @SerializedName("progress")
    var progress: Long,
    @SerializedName("duration")
    var duration: Long,
    @SerializedName("delegation")
    var delegation: Long
): Parcelable