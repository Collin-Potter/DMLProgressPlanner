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
        private var instance: IssueDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            IssueDatabase::class.java, "issue-list.db"
        )
            .build()

    }
}