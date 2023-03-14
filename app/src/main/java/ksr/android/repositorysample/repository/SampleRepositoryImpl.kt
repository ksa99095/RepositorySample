package ksr.android.repositorysample.repository

import ksr.android.repositorysample.datasource.LocalDataSource
import ksr.android.repositorysample.datasource.PreferenceDataSource
import ksr.android.repositorysample.datasource.RemoteDataSource
import ksr.android.repositorysample.model.Sample
import ksr.android.repositorysample.mapper.SampleMapper

class SampleRepositoryImpl(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val preferenceDataSource: PreferenceDataSource
): SampleRepository {

    override suspend fun getLocalSample(title: String): Sample {
        return SampleMapper.mapperToSample(
            localDataSource.getSample(title)
        )
    }

    override suspend fun setLocalSample(sample: Sample) {
        return localDataSource.setSample(
            SampleMapper.mapperToSampleEntity(sample)
        )
    }

    override suspend fun getRemoteSample(): Sample {
        return remoteDataSource.getSample()
    }

    override suspend fun getPreferenceSample(): Sample {
        return preferenceDataSource.getSample()
    }

    override suspend fun setPreferenceSample(sample: Sample) {
        preferenceDataSource.setSample(sample)
    }
}