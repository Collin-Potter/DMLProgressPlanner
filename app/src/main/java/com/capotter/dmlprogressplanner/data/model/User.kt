package com.capotter.dmlprogressplanner.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/***
 * Necessary Parameters:
 * login
 * id
 * name
 * public_repos
 * created_at
 * avatar_url
 */
@Entity(tableName = "users")
class User(
    @PrimaryKey(autoGenerate = true)
    var pid: Long,
    @ColumnInfo(name = "id")
    var id: Long,
    @ColumnInfo(name = "login")
    var login: String,
    @ColumnInfo(name = "avatar_url")
    var avatar_url: String,
    @ColumnInfo(name = "name")
    var name: String,
    @ColumnInfo(name = "public_repos")
    var public_repos: Int,
    @ColumnInfo(name = "created_at")
    var created_at: String
)