package ksr.android.repositorysample.mapper

import com.google.gson.Gson
import ksr.android.repositorysample.model.Sample
import ksr.android.repositorysample.model.SampleEntity

/**
 * Data Entity to Data Model
 */
object SampleMapper {

    fun mapperToSample(sampleEntity: SampleEntity): Sample {
        return Sample(
            title = sampleEntity.title,
            content = sampleEntity.content
        )
    }

    fun mapperToSampleEntity(sample: Sample): SampleEntity {
        return SampleEntity(
            title = sample.title,
            content = sample.content
        )
    }

    fun mapperStringToSample(string: String): Sample {
        return Gson().fromJson(string, Sample::class.java)
    }

    fun mapperSampleToString(sample: Sample): String {
        return Gson().toJson(sample)
    }

}