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
        private var INSTANCE: MilestoneDatabase? = null

        fun getDatabase(context: Context): MilestoneDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MilestoneDatabase::class.java,
                    "Milestone_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}