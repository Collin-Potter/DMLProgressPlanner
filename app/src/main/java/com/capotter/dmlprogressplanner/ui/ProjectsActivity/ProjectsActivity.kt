package com.capotter.dmlprogressplanner.ui.ProjectsActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.capotter.dmlprogressplanner.R
import com.capotter.dmlprogressplanner.databinding.ActivityProjectsBinding

class ProjectsActivity : AppCompatActivity(), LifecycleOwner {

    private val viewModel: ProjectsActivityViewModel = ViewModelProviders.of(this).get(ProjectsActivityViewModel::class.java)

    private lateinit var binding : ActivityProjectsBinding
    private var args: String = "" //TODO: Figure out how this will hold login details throughout application

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_projects)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this
    }

    override fun onStart() {
        super.onStart()

        viewModel.loadDataWhenActivityStarts(args)
    }
}
