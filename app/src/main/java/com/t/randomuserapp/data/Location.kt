package com.t.randomuserapp.data


import com.google.gson.annotations.SerializedName

data class Location(
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String
)