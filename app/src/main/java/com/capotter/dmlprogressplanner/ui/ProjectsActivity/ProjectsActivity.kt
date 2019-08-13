package com.capotter.dmlprogressplanner.ui.ProjectsActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.capotter.dmlprogressplanner.R
import com.capotter.dmlprogressplanner.databinding.ActivityProjectsBinding

class ProjectsActivity : AppCompatActivity(), LifecycleOwner {

    private val viewModel = ViewModelProviders.of(this).get(ProjectsActivityViewModel::class.java)

    private var binding = ActivityProjectsBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_projects)

        

        binding.lifecycleOwner = this
        //TODO: Determine username once logged in and pass through activities

        viewModel.projectList.observe(this, Observer {it ->
            //TODO: UI lists should be filled with projects assigned to user (See AdobeXD for structure)

        })

        viewModel.repoList.observe(this, Observer {it ->
            //TODO: repositories should accumulate into list to list as card titles for issues
        })

        viewModel.userList.observe(this, Observer {it ->
            //TODO: monitor current user information for list of repositories
        })

    }
}
