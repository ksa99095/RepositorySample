package ksr.android.repositorysample.database

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ksr.android.repositorysample.MainApplication
import ksr.android.repositorysample.model.SampleEntity

@Database(entities = [SampleEntity::class], version = 1, exportSchema = false)
abstract class SampleDatabase: RoomDatabase() {
    abstract fun sampleDao(): SampleDao

    companion object {
        private var instance: SampleDatabase? = null

        @Synchronized
        fun getInstance(): SampleDatabase {

            if (instance == null) {
                synchronized(SampleDatabase::class) {
                    instance = Room.databaseBuilder(
                        MainApplication.applicationCtx,
                        SampleDatabase::class.java,
                        "sample.db"
                    ).build()
                }
            }
            return instance!!
        }
    }
}