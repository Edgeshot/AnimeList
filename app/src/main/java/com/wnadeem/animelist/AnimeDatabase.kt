package com.wnadeem.animelist

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import java.util.*

@Database(entities = [Anime::class], version = 2, exportSchema = true)

abstract class AnimeDatabase : RoomDatabase() {
    abstract fun AnimeDao(): AnimeDao

    companion object{

        @Volatile
        private var INSTANCE: AnimeDatabase? = null

        var migration_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

                val defaultUUID: String = UUID.randomUUID().toString()
                database.execSQL(
                    "ALTER TABLE animeTable ADD COLUMN notes TEXT NOT NULL DEFAULT ''"
                )
            }
        }

        fun getDatabase(context: Context): AnimeDatabase {
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AnimeDatabase::class.java,
                    "anime_database"
                )
                    .addMigrations(migration_1_2)
                    .build()
                INSTANCE = instance
                instance
            }

        }
    }





}




