package com.example.truoratest.DI

import android.content.Context
import androidx.room.Room
import com.example.truoratest.Data.Local.AppDB
import com.example.truoratest.Data.Local.ViewModel.RecordViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = arrayOf(AppModule::class))
class ViewModelModule {

    companion object {
        private const val DB_NAME = "truora_test.db"
    }

    @Singleton
    @Provides
    fun provideDB(context: Context): AppDB =
            Room.databaseBuilder(
                context.applicationContext,
                AppDB::class.java,
                DB_NAME
            ).build()

    @Singleton
    @Provides
    fun provideRecordVM(db: AppDB) = RecordViewModel(db)
}