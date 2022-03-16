package com.example.marvelheroes3.model

import com.google.gson.annotations.SerializedName

data class Hero(
    @SerializedName("name")
    val name: String,

    @SerializedName("realname")
    val realName: String,

    @SerializedName("team")
    val team: String,

    @SerializedName("firstappearance")
    val firstAppearance: String,

    @SerializedName("createdby")
    val createdBy: String,

    @SerializedName("publisher")
    val publisher: String,

    @SerializedName("imageurl")
    val imageUrl: String,

    @SerializedName("bio")
    val bio: String
)