package ksr.android.repositorysample.datasource

import ksr.android.repositorysample.model.Sample

interface PreferenceDataSource {

    suspend fun getSample(): Sample
    suspend fun setSample(sampleEntity: Sample)

}