package com.example.roomdatabase_with_mvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.CoroutineScope


@Database(entities = arrayOf(Work::class), version = 1, exportSchema = false)
abstract class WorkDatabase : RoomDatabase() {

    abstract fun workDao(): WorkDao

    companion object {
        @Volatile
        private var instance: WorkDatabase? = null

        fun getDatabase(context: Context): WorkDatabase {
            if (instance == null) {

                synchronized(this) {
                    instance = Room.databaseBuilder(
                        context, WorkDatabase::class.java,
                        "work_table"
                    )
                        .fallbackToDestructiveMigration()
                        .build()

                }
            }
            return instance!!

        }
    }

}
