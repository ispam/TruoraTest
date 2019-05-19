package com.example.truoratest.Data.Local.Entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Record(
    var name: String
) {
    @PrimaryKey(autoGenerate = true)
    var record_id: Int = 0
}