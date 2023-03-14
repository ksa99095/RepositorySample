package ksr.android.repositorysample.datasource

import ksr.android.repositorysample.api.SampleApi
import ksr.android.repositorysample.model.Sample

class RemoteDataSourceImpl(private val sampleApi: SampleApi): RemoteDataSource {
    override suspend fun getSample(): Sample {
        return sampleApi.getSample()
    }
}