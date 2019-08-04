package com.capotter.dmlprogressplanner.ui.MilestonesActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.capotter.dmlprogressplanner.R

class MilestonesActivity : AppCompatActivity(), LifecycleOwner {

    private val viewModel = ViewModelProviders.of(this).get(MilestonesActivityViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_milestones)

        //TODO: Determine username once logged in and pass through activities

        viewModel.milestoneList.observe(this, Observer {it ->
            //TODO: UI lists should be filled with milestones for each repository assigned to user (See AdobeXD for structure)
        })

        viewModel.repoList.observe(this, Observer {it ->
            //TODO: repositories should accumulate into list to list as card titles for issues
        })

        viewModel.userList.observe(this, Observer {it ->
            //TODO: monitor current user information for list of repositories
        })
    }
}
