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
    @PrimaryKey @ColumnInfo(name = "id")
    val id: Int? = null,
    @ColumnInfo(name = "node_id")
    val nodeId: String? = null,
    @ColumnInfo(name = "url")
    val url: String? = null,
    @ColumnInfo(name = "repository_url")
    val repositoryUrl: String? = null,
    @ColumnInfo(name = "labels_url")
    val labelsUrl: String? = null,
    @ColumnInfo(name = "comments_url")
    val commentsUrl: String? = null,
    @ColumnInfo(name = "events_url")
    val eventsUrl: String? = null,
    @ColumnInfo(name = "html_url")
    val htmlUrl: String? = null,
    @ColumnInfo(name = "number")
    val number: Int? = null,
    @ColumnInfo(name = "state")
    val state: String? = null,
    @ColumnInfo(name = "title")
    val title: String? = null,
    @ColumnInfo(name = "body")
    val body: String? = null,
    @ColumnInfo(name = "locked")
    val locked: Boolean? = null,
    @ColumnInfo(name = "active_lock_reason")
    val activeLockReason: String? = null,
    @ColumnInfo(name = "comments")
    val comments: Int? = null,
    @ColumnInfo(name = "created_at")
    val createdAt: String? = null,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String? = null)

