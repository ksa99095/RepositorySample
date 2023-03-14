package ksr.android.repositorysample.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ksr.android.repositorysample.model.SampleEntity

@Dao
interface SampleDao {

    @Query("SELECT * FROM sample WHERE title = :title")
    fun getSample(title: String): SampleEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun setSample(sample: SampleEntity)
}