package com.mockhelper.organizer.persistense

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.mockhelper.organizer.model.BlogActivity
import java.time.LocalDate

@Dao
interface BlogActivityDao {

    @Query("SELECT * from blog_activities")
    suspend fun getAll(): List<BlogActivity>

    @Insert(onConflict = REPLACE)
    suspend fun insert(activity: BlogActivity)

    @Delete
    suspend fun delete(activity: BlogActivity)

    @Query("SELECT * from blog_activities WHERE date IS :chosenDate")
    suspend fun getByDate(chosenDate: LocalDate): List<BlogActivity>

    @Query("UPDATE blog_activities SET destination =:activityDest WHERE id IS :activityId")
    suspend fun updateDestination(activityId: Long, activityDest:String)
}