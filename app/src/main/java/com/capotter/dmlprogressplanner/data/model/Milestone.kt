package com.capotter.dmlprogressplanner.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import android.os.Parcelable.Creator



/***
 * Necessary Paramters:
 * id
 * state
 * title
 * description
 * open_issues
 * created_at
 * updated_at
 * due_on
 */
@Entity(tableName = "milestones")
class Milestone(
    @ColumnInfo(name = "url")
    val url: String? = null,
    @ColumnInfo(name = "html_url")
    val htmlUrl: String? = null,
    @ColumnInfo(name = "labels_url")
    val labelsUrl: String? = null,
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int? = null,
    @ColumnInfo(name = "node_id")
    val nodeId: String? = null,
    @ColumnInfo(name = "number")
    val number: Int? = null,
    @ColumnInfo(name = "state")
    val state: String? = null,
    @ColumnInfo(name = "title")
    val title: String? = null,
    @ColumnInfo(name = "description")
    val description: String? = null,
    @ColumnInfo(name = "open_issues")
    val openIssues: Int? = null,
    @ColumnInfo(name = "closed_issues")
    val closedIssues: Int? = null,
    @ColumnInfo(name = "created_at")
    val createdAt: String? = null,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String? = null,
    @ColumnInfo(name = "closed_at")
    val closedAt: String? = null,
    @ColumnInfo(name = "due_on")
    val dueOn: String? = null)

