package com.capotter.dmlprogressplanner.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/***
 * Necessary Paramters:
 * id
 * state
 * title
 * body
 * created_at
 * updated_at
 */
@Entity(tableName = "issues")
class Issue(
    @PrimaryKey(autoGenerate = true)
    var pid: Long,
    @ColumnInfo(name = "id")
    var id: Long,
    @ColumnInfo(name = "title")
    var title: String,
    @ColumnInfo(name = "body")
    var body: String,
    @ColumnInfo(name = "state")
    var state: String,
    @ColumnInfo(name = "created_at")
    var created_at: String,
    @ColumnInfo(name = "updated_at")
    var updated_at: String?
    )