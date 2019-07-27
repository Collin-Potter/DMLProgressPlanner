package com.capotter.dmlprogressplanner.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "milestone")
class Milestone(
    @PrimaryKey(autoGenerate = true)
    var pid: Long?,
    @ColumnInfo(name = "id")
    var id: Long?,
    @ColumnInfo(name = "title")
    var title: String?,
    @ColumnInfo(name = "description")
    var description: String?,
    @ColumnInfo(name = "open_issues")
    var open_issues: Int?,
    @ColumnInfo(name = "closed_issues")
    var closed_issues: Int?,
    @ColumnInfo(name = "created_at")
    var created_at: String?,
    @ColumnInfo(name = "updated_at")
    var updated_at: String?,
    @ColumnInfo(name = "closed_at")
    var closed_at: String,
    @ColumnInfo(name = "due_on")
    var due_on: String
)