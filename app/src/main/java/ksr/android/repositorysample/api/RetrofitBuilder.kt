package ksr.android.repositorysample.api

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitBuilder {

    /** ******** input your Api url ******** */
    private const val baseUrl = "http://127.0.0.1:8080/"

    private fun getRetrofit(): Retrofit {

        val gson = GsonBuilder().setLenient().create()

        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        val client = OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor {
                val request: Request = it.request().newBuilder()
                    .addHeader("Content-Type", "application/json")
                    .addHeader("accept", "application/json")
                    .build()
                return@addInterceptor it.proceed(request)
            }
            .build()

        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(client)
            .build()
    }

    val sampleApi: SampleApi = getRetrofit().create(SampleApi::class.java)

}