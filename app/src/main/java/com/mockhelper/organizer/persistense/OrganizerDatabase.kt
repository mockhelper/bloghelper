package com.mockhelper.organizer.persistense

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mockhelper.organizer.model.BlogActivity

@Database(entities = [(BlogActivity::class)], version = 1)
@TypeConverters(Converters::class)
abstract class OrganizerDatabase : RoomDatabase() {
    abstract fun blogActivityDao(): BlogActivityDao

    companion object {
        private var INSTANCE: OrganizerDatabase? = null

        fun getInstance(context: Context): OrganizerDatabase? {
            if (INSTANCE == null) {
                synchronized(OrganizerDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        OrganizerDatabase::class.java, "organizer.db"
                    )
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}