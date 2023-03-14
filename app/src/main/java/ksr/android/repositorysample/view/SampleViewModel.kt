package ksr.android.repositorysample.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ksr.android.repositorysample.api.FetchState
import ksr.android.repositorysample.model.Sample
import ksr.android.repositorysample.repository.SampleRepositoryImpl
import retrofit2.HttpException
import java.net.SocketException
import java.net.UnknownHostException

class SampleViewModel(
    private val sampleRepositoryImpl: SampleRepositoryImpl
): ViewModel() {

    private val _fetchState = MutableLiveData<FetchState>()
    val fetchState : LiveData<FetchState>
        get() = _fetchState

    private val _sample = MutableLiveData<Sample>()
    val sample: LiveData<Sample> get() = _sample


    fun getRemoteSample() {
        launchViewModelScope {
            _sample.postValue(sampleRepositoryImpl.getRemoteSample())
        }
    }

    fun getLocalSample(title: String) {
        launchViewModelScope {
            _sample.postValue(sampleRepositoryImpl.getLocalSample(title))
        }
    }

    fun setLocalSample(sample: Sample) {
        launchViewModelScope {
            sampleRepositoryImpl.setLocalSample(sample)
        }
    }

    fun getPrefSample() {
        launchViewModelScope {
            _sample.postValue(sampleRepositoryImpl.getPreferenceSample())
        }
    }

    fun setPrefSample(sample: Sample) {
        launchViewModelScope {
            sampleRepositoryImpl.setPreferenceSample(sample)
        }
    }






    private fun launchViewModelScope(doWork: suspend () -> Unit) =
        viewModelScope.launch(viewModelScope.coroutineContext + Dispatchers.IO + exceptionHandler) {
            doWork()
        }

    private val exceptionHandler = CoroutineExceptionHandler{ _, throwable ->
        throwable.printStackTrace()

        when(throwable){
            is SocketException -> _fetchState.postValue(FetchState.INTERNET_ERROR)
            is HttpException -> _fetchState.postValue(FetchState.PARSE_ERROR)
            is UnknownHostException -> _fetchState.postValue(FetchState.WRONG_CONNECTION)
            else -> _fetchState.postValue(FetchState.FAIL)
        }
    }
}