package ksr.android.repositorysample.api

import ksr.android.repositorysample.model.Sample
import retrofit2.http.GET

interface SampleApi {

    @GET("/getSample")
    suspend fun getSample(): Sample
}