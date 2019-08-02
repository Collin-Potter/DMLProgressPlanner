package com.capotter.dmlprogressplanner.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "github_repositories")
class GitHubRepository(
    @PrimaryKey(autoGenerate = true)
    var pid: Long,
    @ColumnInfo(name = "id")
    var id: Long,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "full_name")
    var full_name: String,
    @ColumnInfo(name = "forks_count")
    var forks_count: Int,
    @ColumnInfo(name = "stargazers_count")
    var stargazers_count: Int,
    @ColumnInfo(name = "watchers_count")
    var watchers_count: Int,
    @ColumnInfo(name = "open_issues_count")
    var open_issues_count: Int,
    @ColumnInfo(name = "has_issues")
    var has_issues: Boolean,
    @ColumnInfo(name = "has_projects")
    var has_projects: Boolean,
    @ColumnInfo(name = "pushed_at")
    var pushed_at: String?,
    @ColumnInfo(name = "created_at")
    var created_at: String,
    @ColumnInfo(name = "updated_at")
    var updated_at: String?,
    @ColumnInfo(name = "subscribers_count")
    var subscribers_count: Int
    )