package ksr.android.repositorysample.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "sample")
data class SampleEntity(
    @PrimaryKey var id: Int = 0,
    @ColumnInfo var title: String,
    @ColumnInfo var content: String
)