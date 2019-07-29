package com.capotter.dmlprogressplanner.ui.ProjectsActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.capotter.dmlprogressplanner.R

class ProjectsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_projects)
        val vm: ProjectsActivityViewModel by lazy {
            //TODO: Get user information from successful GitHub login
            ViewModelProviders.of(this, ProjectsViewModelFactory(123)).get(ProjectsActivityViewModel::class.java)
        }
    }
}
