package ksr.android.repositorysample.datasource

import ksr.android.repositorysample.database.SampleDatabase
import ksr.android.repositorysample.model.SampleEntity

class LocalDataSourceImpl(private val db: SampleDatabase): LocalDataSource {
    override suspend fun getSample(): SampleEntity {
        return db.sampleDao().getSample()
    }

    override suspend fun setSample(sample: SampleEntity) {
        return db.sampleDao().setSample(sample)
    }
}