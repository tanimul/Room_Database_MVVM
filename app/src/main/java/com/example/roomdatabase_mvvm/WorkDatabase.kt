package com.example.roomdatabase_mvvm

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Work::class), version = 1, exportSchema = false)
abstract class WorkDatabase : RoomDatabase() {

    abstract fun workDao(): WorkDao

    companion object {

        private var instance: WorkDatabase? = null

        @Synchronized
        fun getDatabase(context: Context): WorkDatabase {
            if (instance == null)

                instance = Room.databaseBuilder(
                    context, WorkDatabase::class.java,
                    "work_table"
                )
                    .fallbackToDestructiveMigration()
                    .build()

            return instance!!
        }
    }
}
