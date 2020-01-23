package com.t.randomuserapp.entity


import com.google.gson.annotations.SerializedName

data class RandomUserResponse(
    @SerializedName("results")
    val users: MutableList<User>
)