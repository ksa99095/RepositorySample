package ksr.android.repositorysample.repository

import ksr.android.repositorysample.model.Sample

interface SampleRepository {

    suspend fun getLocalSample(): Sample
    suspend fun setLocalSample(sample: Sample)
    suspend fun getRemoteSample(): Sample
    suspend fun getPreferenceSample(): Sample
    suspend fun setPreferenceSample(sample: Sample)

}