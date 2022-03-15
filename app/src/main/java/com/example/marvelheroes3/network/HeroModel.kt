package com.example.marvelheroes3.network

import com.google.gson.annotations.SerializedName

data class HeroesListItem(
    val name: String,

    @SerializedName("realname")
    val realName: String,

    val team: String,

    @SerializedName("firstappearance")
    val firstAppearance: String,

    @SerializedName("createdby")
    val createdBy: String,

    val publisher: String,

    @SerializedName("imageurl")
    val imageUrl: String,

    val bio: String
)