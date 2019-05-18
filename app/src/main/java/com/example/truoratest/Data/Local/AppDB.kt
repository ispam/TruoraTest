package com.example.truoratest.Data.Local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.truoratest.Data.Local.DAOs.RecordDAO
import com.example.truoratest.Data.Local.Entities.Record

@Database(entities = arrayOf(Record::class), version = 1, exportSchema = false)
abstract class AppDB: RoomDatabase() {

    abstract fun recordDAO(): RecordDAO
}