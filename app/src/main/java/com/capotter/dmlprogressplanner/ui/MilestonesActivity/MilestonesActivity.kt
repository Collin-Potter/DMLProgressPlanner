package com.capotter.dmlprogressplanner.ui.MilestonesActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.capotter.dmlprogressplanner.R

class MilestonesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_milestones)
        val vm: MilestonesActivityViewModel by lazy {
            //TODO: Get user information from successful GitHub login
            ViewModelProviders.of(this, MilestonesViewModelFactory(123)).get(MilestonesActivityViewModel::class.java)
        }
    }
}
