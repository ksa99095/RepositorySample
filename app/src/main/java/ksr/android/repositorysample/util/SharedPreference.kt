package ksr.android.repositorysample.util

import android.content.Context
import android.content.SharedPreferences
import ksr.android.repositorysample.mapper.SampleMapper
import ksr.android.repositorysample.model.Sample

class SharedPreference(context: Context) {
    private val preference: SharedPreferences = context.getSharedPreferences(SAMPLE, Context.MODE_PRIVATE)

    fun getSample(): Sample {
        val sampleString = preference.getString(SAMPLE, "")

        return if (sampleString.isNullOrEmpty())
            Sample("", "")
        else
            SampleMapper.mapperStringToSample(sampleString)
    }

    fun setSample(sample: Sample) {
        val editor = preference.edit()
        editor.putString(SAMPLE, SampleMapper.mapperSampleToString(sample))
        editor.apply()
    }

    companion object {
        const val SAMPLE = "SAMPLE"
    }
}