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
        private var instance: GitHubRepositoryDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            GitHubRepositoryDatabase::class.java, "repo-list.db"
        )
            .build()
    }

}