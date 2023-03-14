package ksr.android.repositorysample.view

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import ksr.android.repositorysample.api.FetchState
import ksr.android.repositorysample.common.ViewModelFactory
import ksr.android.repositorysample.databinding.ActivitySampleBinding
import ksr.android.repositorysample.model.Sample

class SampleActivity: AppCompatActivity() {

    private val binding: ActivitySampleBinding by lazy { ActivitySampleBinding.inflate(layoutInflater) }
    private val viewModel: SampleViewModel by viewModels { ViewModelFactory(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUI()
        setObserver()
        setListener()
        initData()
    }

    private fun setUI() {}
    private fun setObserver() {
        viewModel.fetchState.observe(this) {
            val errorMessage = when(it) {
                FetchState.FAIL -> "Error!"
                else -> "Network Error!"
            }

            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
        viewModel.sample.observe(this) {
            if (it.title.isEmpty() || it.content.isEmpty()) {
                Toast.makeText(this, "title / content is null", Toast.LENGTH_SHORT).show()
            } else {
                binding.title.setText(it.title)
                binding.content.setText(it.content)
            }
        }
    }
    private fun setListener() {
        binding.btnGetRemote.setOnClickListener {
            viewModel.getRemoteSample()
        }

        binding.btnGetLocal.setOnClickListener {
            if (binding.title.text.isNullOrEmpty()) {
                Toast.makeText(this, "please input title", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.getLocalSample(binding.title.text.toString())
            }
        }

        binding.btnSetLocal.setOnClickListener {
            if (binding.title.text.isNullOrEmpty()) {
                Toast.makeText(this, "please input title", Toast.LENGTH_SHORT).show()
            } else if (binding.content.text.isNullOrEmpty()) {
                Toast.makeText(this, "please input content", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.setLocalSample(
                    Sample(
                        title = binding.title.text.toString(),
                        content = binding.content.text.toString()
                    )
                )
            }
        }

        binding.btnGetPref.setOnClickListener {
            viewModel.getPrefSample()
        }

        binding.btnSetPref.setOnClickListener {

            if (binding.title.text.isNullOrEmpty()) {
                Toast.makeText(this, "please input title", Toast.LENGTH_SHORT).show()
            } else if (binding.content.text.isNullOrEmpty()) {
                Toast.makeText(this, "please input content", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.setPrefSample(
                    Sample(
                        title = binding.title.text.toString(),
                        content = binding.content.text.toString()
                    )
                )
            }
        }
    }
    private fun initData() {}
}