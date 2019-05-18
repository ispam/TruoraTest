package com.example.truoratest.Data.Local.ViewModel

import com.example.truoratest.Data.Local.AppDB
import com.example.truoratest.Data.Local.Entities.Record
import io.reactivex.Completable
import javax.inject.Inject

class RecordViewModel @Inject constructor(val db: AppDB){

    fun createRecord(record: Record): Completable = Completable.fromAction { db.recordDAO().insertRecord(record) }

    fun getAllRecords() = db.recordDAO().getAllRecords()
}