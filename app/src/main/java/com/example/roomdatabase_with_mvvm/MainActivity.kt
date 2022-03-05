package com.example.roomdatabase_with_mvvm

import android.app.TaskInfo
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabase_with_mvvm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var workviewModel: WorkViewModel
    private lateinit var workList: ArrayList<Work>
    lateinit var workAdapter: WorkAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        workviewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        ).get(WorkViewModel::class.java)
        workList = ArrayList<Work>()
        workAdapter = WorkAdapter(workList);
        binding.rvWorkList.layoutManager = LinearLayoutManager(this)
        binding.rvWorkList.adapter = workAdapter

        workviewModel.allWorkes.observe(this, Observer { list ->
            list?.let {
                Log.d("MainActivity", "onCreate: " + it.size)
                workList.addAll(it)
                workAdapter.notifyDataSetChanged()
            }
        })

        binding.btSubmit.setOnClickListener(View.OnClickListener {
            val work = Work(
                workName = binding.etName.text.toString(),
                details = binding.etDetails.text.toString()
            )
            workviewModel.insertWork(work)
        })

    }
}