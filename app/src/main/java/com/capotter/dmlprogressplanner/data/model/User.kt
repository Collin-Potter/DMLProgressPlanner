package com.capotter.dmlprogressplanner.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "users")
class User(
    @PrimaryKey(autoGenerate = true)
    var pid: Long?,
    @ColumnInfo(name = "id")
    var id: Long?,
    @ColumnInfo(name = "login")
    var login: String?,
    @ColumnInfo(name = "avatar_url")
    var avatar_url: String?,
    @ColumnInfo(name = "name")
    var name: String?,
    @ColumnInfo(name = "company")
    var company: String?,
    @ColumnInfo(name = "location")
    var location: String?,
    @ColumnInfo(name = "email")
    var email: String?,
    @ColumnInfo(name = "bio")
    var bio: String?,
    @ColumnInfo(name = "public_repos")
    var public_repos: Int?,
    @ColumnInfo(name = "public_gists")
    var public_gists: Int?,
    @ColumnInfo(name = "followers")
    var followers: Int?,
    @ColumnInfo(name = "following")
    var following: Int?,
    @ColumnInfo(name = "created_at")
    var created_at: String?,
    @ColumnInfo(name = "updated_at")
    var updated_at: String?
)