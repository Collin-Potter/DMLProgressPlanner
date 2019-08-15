package com.capotter.dmlprogressplanner.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capotter.dmlprogressplanner.adapters.ProjectsActivityRepositoriesAdapter
import com.capotter.dmlprogressplanner.data.model.GitHubRepository

class ProjectsActivityBindingAdapters {

    private val NUM_COLUMNS = 2

    @BindingAdapter("projectsRepositoriesList")
    fun setRepositoriesList(view: RecyclerView, repositories: ArrayList<GitHubRepository>) {
        if(repositories.isNullOrEmpty()){
            return
        }
        val layoutManager = view.layoutManager
        if(layoutManager == null){
            view.layoutManager = GridLayoutManager(view.context, NUM_COLUMNS)
        }
        var adapter: ProjectsActivityRepositoriesAdapter = view.adapter as (ProjectsActivityRepositoriesAdapter)
        if(adapter == null) {
            adapter = ProjectsActivityRepositoriesAdapter(view.context, repositories)
            view.adapter = adapter
        }
    }
}