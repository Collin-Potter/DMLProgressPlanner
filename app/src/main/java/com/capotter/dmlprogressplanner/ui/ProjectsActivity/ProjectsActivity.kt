package com.capotter.dmlprogressplanner.ui.ProjectsActivity

import android.content.Intent
import android.net.Uri
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

    private val clientId = "48dc44aed3ed10f2bd8d"
    private val clientSecret = "c55beb9f9a7da5a1b19e949f64b5d87ed2b3abbe"
    private val redirectUri = "devmeetslab://callback"

    private lateinit var viewModel: ProjectsActivityViewModel

    private lateinit var binding : ActivityProjectsBinding
    private var args: String = "" //TODO: Figure out how this will hold login details throughout application

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(ProjectsActivityViewModel::class.java)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_projects)
        binding.viewmodel = viewModel
        binding.lifecycleOwner = this

        val authIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/login/oauth/authorize" + "?client_id" + clientId + "&redirect_uri=" + redirectUri))

        startActivity(authIntent)
    }

    override fun onStart() {
        super.onStart()

        viewModel.loadDataWhenActivityStarts(args)
    }
}
