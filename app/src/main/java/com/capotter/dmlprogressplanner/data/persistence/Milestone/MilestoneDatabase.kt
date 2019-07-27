package com.capotter.dmlprogressplanner.data.persistence.Milestone

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.capotter.dmlprogressplanner.data.model.Milestone

@Database(entities = arrayOf(Milestone::class), version = 1)
abstract class MilestoneDatabase: RoomDatabase() {
    abstract fun milestoneDao(): MilestoneDao

    companion object {
        @Volatile
        private var instance: MilestoneDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            MilestoneDatabase::class.java, "milestone-list.db"
        )
            .build()

    }
}