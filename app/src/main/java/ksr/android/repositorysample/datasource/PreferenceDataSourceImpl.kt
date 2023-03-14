package ksr.android.repositorysample.datasource

import ksr.android.repositorysample.util.SharedPreference
import ksr.android.repositorysample.model.Sample


class PreferenceDataSourceImpl(
    private val sharedPreference: SharedPreference
): PreferenceDataSource {

    override suspend fun getSample(): Sample {
        return sharedPreference.getSample()
    }

    override suspend fun setSample(sampleEntity: Sample) {
        sharedPreference.setSample(sampleEntity)
    }
}