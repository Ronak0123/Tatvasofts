package com.ronak.gopani.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

data class RResponse(
        val status : Boolean,
        val message : String,
        val data : Data
)

data class Users (

        val name : String,
        val image : String,
        val items : List<String>
)


data class Data (

        val users : List<Users>,
        val has_more : Boolean
)