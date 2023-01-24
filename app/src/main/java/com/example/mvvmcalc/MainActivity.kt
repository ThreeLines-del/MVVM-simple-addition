package com.example.mvvmcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmcalc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[(MainActivityViewModel::class.java)]

        setNumbers()

        viewModel.results.observe(this) { result ->
            binding.tvResult.text = result.toString()

        }

        binding.btnAdd.setOnClickListener {
            getNumbers()
            viewModel.addition()

        }
    }
    private fun getNumbers(){
        viewModel.firstNumber = binding.etFirstNumber.text.toString().toInt()
        viewModel.secondNumber = binding.etSecondNumber.text.toString().toInt()
    }
    private fun setNumbers(){
        binding.etFirstNumber.setText(viewModel.firstNumber.toString())
        binding.etSecondNumber.setText(viewModel.secondNumber.toString())
    }

}