package com.capotter.dmlprogressplanner.ui.ProfileActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.capotter.dmlprogressplanner.R

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val vm: ProfileActivityViewModel by lazy {
            //TODO: Get user information from successful GitHub login
            ViewModelProviders.of(this, ProfileViewModelFactory(123)).get(ProfileActivityViewModel::class.java)
        }
    }
}
