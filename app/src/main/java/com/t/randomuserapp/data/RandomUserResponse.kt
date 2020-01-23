package com.t.randomuserapp.data


import com.google.gson.annotations.SerializedName

data class RandomUserResponse(
    @SerializedName("results")
    val results: MutableList<Result>
)