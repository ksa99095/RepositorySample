package ksr.android.repositorysample.common

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ksr.android.repositorysample.api.RetrofitBuilder
import ksr.android.repositorysample.database.SampleDatabase
import ksr.android.repositorysample.datasource.LocalDataSourceImpl
import ksr.android.repositorysample.datasource.PreferenceDataSourceImpl
import ksr.android.repositorysample.datasource.RemoteDataSourceImpl
import ksr.android.repositorysample.repository.SampleRepositoryImpl
import ksr.android.repositorysample.util.SharedPreference
import ksr.android.repositorysample.view.SampleViewModel

class ViewModelFactory(context: Context): ViewModelProvider.Factory {

    private val mContext = context

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SampleViewModel::class.java)) {
            val repository = SampleRepositoryImpl(
                LocalDataSourceImpl(SampleDatabase.getInstance()),      // DB
                RemoteDataSourceImpl(RetrofitBuilder.sampleApi),        // API
                PreferenceDataSourceImpl(SharedPreference(mContext))    // Preference
            )
            return SampleViewModel(repository) as T
        } else {
            throw java.lang.IllegalArgumentException("Failed to create ViewModel : ${modelClass.name}")
        }
    }
}