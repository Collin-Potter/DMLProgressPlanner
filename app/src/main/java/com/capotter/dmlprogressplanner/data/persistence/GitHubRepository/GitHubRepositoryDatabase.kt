package com.capotter.dmlprogressplanner.data.persistence.GitHubRepository

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.capotter.dmlprogressplanner.data.model.GitHubRepository

@Database(entities = arrayOf(GitHubRepository::class), version = 1)
abstract class GitHubRepositoryDatabase: RoomDatabase() {

    abstract fun repoDao(): GitHubRepositoryDao

    companion object {
        @Volatile
        private var INSTANCE: GitHubRepositoryDatabase? = null

        fun getDatabase(context: Context): GitHubRepositoryDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GitHubRepositoryDatabase::class.java,
                    "GitHubRepository_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}