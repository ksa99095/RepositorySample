package ksr.android.repositorysample.datasource

import ksr.android.repositorysample.model.SampleEntity

interface LocalDataSource {

    suspend fun getSample(title: String): SampleEntity
    suspend fun setSample(sample: SampleEntity)
}