package com.capotter.dmlprogressplanner.ui.IssuesActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.capotter.dmlprogressplanner.R

class IssuesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_issues)

        val vm: IssuesActivityViewModel by lazy {
            //TODO: Get user information from successful GitHub login
            ViewModelProviders.of(this, IssuesViewModelFactory(123)).get(IssuesActivityViewModel::class.java)
        }
    }
}
