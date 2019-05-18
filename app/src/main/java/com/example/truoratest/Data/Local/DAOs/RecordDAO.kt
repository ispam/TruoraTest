package com.example.truoratest.Data.Local.DAOs

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.truoratest.Data.Local.Entities.Record
import io.reactivex.Single

@Dao
interface RecordDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecord(record: Record)

    @Query("select * from record")
    fun getAllRecords(): Single<List<Record>>
}