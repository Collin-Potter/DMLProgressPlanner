package com.capotter.dmlprogressplanner.ui.ProjectsActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.capotter.dmlprogressplanner.R

class ProjectsActivity : AppCompatActivity(), LifecycleOwner {

    private val viewModel = ViewModelProviders.of(this).get(ProjectsActivityViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)

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
