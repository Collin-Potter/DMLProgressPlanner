package com.capotter.dmlprogressplanner.data.persistence.Project

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.capotter.dmlprogressplanner.data.model.Project

@Database(entities = arrayOf(Project::class), version = 1)
abstract class ProjectDatabase: RoomDatabase() {
    abstract fun projectDao(): ProjectDao

    companion object {
        @Volatile
        private var instance: ProjectDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            ProjectDatabase::class.java, "project-list.db"
        )
            .build()

    }
}