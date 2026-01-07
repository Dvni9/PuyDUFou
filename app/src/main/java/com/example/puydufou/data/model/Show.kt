package com.example.puydufou.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shows")
data class Show(
    @PrimaryKey val id: Int,
    val name: String,
    val description: String,
    val imageResId: Int,
    val schedule: String,
    val duration: String,
    val zone: String,
    val latitude: Double,
    val longitude: Double,
    val accessibility: Boolean,
    val familyFriendly: Boolean,
    val language: String,
    var isFavorite: Boolean = false
)