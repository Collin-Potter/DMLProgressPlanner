package com.capotter.dmlprogressplanner.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "issue")
class Issue(
    @PrimaryKey(autoGenerate = true)
    var pid: Long?,
    @ColumnInfo(name = "id")
    var id: Long?,
    @ColumnInfo(name = "title")
    var title: String?,
    @ColumnInfo(name = "body")
    var body: String?,
    @ColumnInfo(name = "state")
    var state: String?,
    @ColumnInfo(name = "created_at")
    var created_at: String?,
    @ColumnInfo(name = "updated_at")
    var updated_at: String?
    )