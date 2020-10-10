package com.globo.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "favorites_table")
data class Movie (
//    @PrimaryKey(autoGenerate = true)
//    val id : Int = 0,
    @PrimaryKey(autoGenerate = false)
    val title : String,
    val subtitle : String,
    val duration : String,
    val synopsis : String,
    val thumbnail : String,
    val favorite : Boolean = false
)