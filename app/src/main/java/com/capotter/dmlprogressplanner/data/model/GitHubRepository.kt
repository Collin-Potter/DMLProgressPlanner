package com.capotter.dmlprogressplanner.data.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

/***
 * Necessary Paramters:
 * id
 * name
 * description
 * open_issues_count
 * has_issues
 * has_projects
 * created_at
 * updated_at
 */
@Entity(tableName = "github_repositories")
class GitHubRepository(
    @PrimaryKey(autoGenerate = true)
    var pid: Long,
    @ColumnInfo(name = "id")
    var id: Long,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "description")
    var description: String,
    @ColumnInfo(name = "open_issues_count")
    var open_issues_count: Int,
    @ColumnInfo(name = "has_issues")
    var has_issues: Boolean,
    @ColumnInfo(name = "has_projects")
    var has_projects: Boolean,
    @ColumnInfo(name = "created_at")
    var created_at: String,
    @ColumnInfo(name = "updated_at")
    var updated_at: String?
    )