package ksr.android.repositorysample.datasource

import ksr.android.repositorysample.model.Sample

interface RemoteDataSource {
    suspend fun getSample(): Sample
}