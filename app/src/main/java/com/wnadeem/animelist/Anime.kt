package com.wnadeem.animelist

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.*

@Entity(tableName = "animeTable")
class Anime (@ColumnInfo(name= "animePic") var animePicTitle: String ="",
             @ColumnInfo(name= "animeName") var animeNameTitle: String ="",
             @ColumnInfo(name= "friendName") var friendNameTitle: String ="",
             @ColumnInfo(name= "category") var categoryTitle: String ="",
             @ColumnInfo(name= "Score") var scoreTitle: String ="",
             @ColumnInfo(name= "notes") var notes: String ="",) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}