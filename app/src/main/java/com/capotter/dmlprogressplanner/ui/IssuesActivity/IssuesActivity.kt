package com.capotter.dmlprogressplanner.ui.IssuesActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.*
import com.capotter.dmlprogressplanner.R
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import com.capotter.dmlprogressplanner.data.model.User
import com.capotter.dmlprogressplanner.data.repository.GitHubRepositoryRepository
import com.capotter.dmlprogressplanner.data.repository.IssueRepository
import com.capotter.dmlprogressplanner.data.repository.UserRepository
import com.capotter.dmlprogressplanner.databinding.ActivityIssuesBinding

class IssuesActivity : AppCompatActivity(), LifecycleOwner {

    private val viewModel = ViewModelProviders.of(this).get(IssuesActivityViewModel::class.java)

    private lateinit var binding : ActivityIssuesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_issues)



        //TODO: Determine username once logged in and pass through activities

        viewModel.issueList.observe(this, Observer {it ->
            //TODO: UI lists should be filled with issues for each repository assigned to user (See AdobeXD for structure)
        })

        viewModel.repoList.observe(this, Observer {it ->
            //TODO: repositories should accumulate into list to list as card titles for issues
        })

    }

}
