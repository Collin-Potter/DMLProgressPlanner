package com.capotter.dmlprogressplanner.databinding

import android.widget.AbsListView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capotter.dmlprogressplanner.adapters.MilestonesActivityMilestonesAdapter
import com.capotter.dmlprogressplanner.adapters.MilestonesActivityRepositoriesAdapter
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import com.capotter.dmlprogressplanner.data.model.Milestone

class MilestonesActivityBindingAdapters {

    private val NUM_COLUMNS = 2

    @BindingAdapter("milestonesRepositoriesList")
    fun setRepositoriesList(view: RecyclerView, repositories: ArrayList<GitHubRepository>) {
        if(repositories.isNullOrEmpty()){
            return
        }
        val layoutManager = view.layoutManager
        if(layoutManager == null){
            view.layoutManager = GridLayoutManager(view.context, NUM_COLUMNS)
        }
        var adapter: MilestonesActivityRepositoriesAdapter = view.adapter as (MilestonesActivityRepositoriesAdapter)
        if(adapter == null) {
            adapter = MilestonesActivityRepositoriesAdapter(view.context, repositories)
            view.adapter = adapter
        }
    }

    @BindingAdapter("milestonesList")
    fun setMilestonesList(view: RecyclerView, milestones: ArrayList<Milestone>) {
        if(milestones.isNullOrEmpty()){
            return
        }
        val layoutManager = view.layoutManager
        if(layoutManager == null){
            view.layoutManager = GridLayoutManager(view.context, NUM_COLUMNS)
        }
        var adapter: MilestonesActivityMilestonesAdapter = view.adapter as (MilestonesActivityMilestonesAdapter)
        if(adapter == null){
            adapter = MilestonesActivityMilestonesAdapter(view.context, milestones)
            view.adapter = adapter
        }
    }
}