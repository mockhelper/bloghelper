package com.mockhelper.organizer.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.time.LocalDate

@Entity(tableName = "blog_activities")
data class BlogActivity(val date: LocalDate, val destination: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var isBlogWritten: Boolean = false
    var isBlogTypedIn: Boolean = false
    var isBlogChecked: Boolean = false
    var isPhotosSortedOut: Boolean = false
    var isPhotosDuplicatesDeleted: Boolean = false
    var isPhotosStraightened: Boolean = false
    var isPhotosEdited: Boolean = false
    var isBlogReady: Boolean = false
}