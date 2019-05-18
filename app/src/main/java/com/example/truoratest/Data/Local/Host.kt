package com.example.truoratest.Data.Local

import com.google.gson.annotations.SerializedName

data class Host(
    @SerializedName("host")
    var host: String,
    @SerializedName("port")
    var port: Int,
    @SerializedName("protocol")
    var protocol: String,
    @SerializedName("isPublic")
    var isPublic: Boolean,
    @SerializedName("status")
    var status: String,
    @SerializedName("startTime")
    var startTime: Int,
    @SerializedName("testTime")
    var testTime: Int,
    @SerializedName("engineVersion")
    var engineVersion: String,
    @SerializedName("criteriaVersion")
    var criteriaVersion: String,
    @SerializedName("endpoints")
    var endpoints: List<Endpoints> ?= null
)

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
    var progress: Int,
    @SerializedName("duration")
    var duration: Int,
    @SerializedName("delegation")
    var delegation: Int
)