package com.capotter.dmlprogressplanner.data.persistence.Issue

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.capotter.dmlprogressplanner.data.model.Issue

@Database(entities = arrayOf(Issue::class), version = 1)
abstract class IssueDatabase: RoomDatabase() {
    abstract fun issueDao(): IssueDao

    companion object {
        @Volatile
        private var INSTANCE: IssueDatabase? = null

        fun getDatabase(context: Context): IssueDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    IssueDatabase::class.java,
                    "Issue_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}