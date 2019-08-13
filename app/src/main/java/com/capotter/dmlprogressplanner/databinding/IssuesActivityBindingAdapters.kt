package com.capotter.dmlprogressplanner.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.capotter.dmlprogressplanner.adapters.IssuesActivityIssuesAdapter
import com.capotter.dmlprogressplanner.adapters.IssuesActivityRepositoriesAdapter
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import com.capotter.dmlprogressplanner.data.model.Issue

class IssuesActivityBindingAdapters {

    private val NUM_COLUMNS = 1

    @BindingAdapter("repositoriesList")
    fun setRepositoriesList(view: RecyclerView, repositories: ArrayList<GitHubRepository>){
        if(repositories.isNullOrEmpty()){
            return
        }
        val layoutManager = view.layoutManager
        if(layoutManager == null){
            view.layoutManager = GridLayoutManager(view.context, NUM_COLUMNS)
        }
        var adapter: IssuesActivityRepositoriesAdapter = view.adapter as (IssuesActivityRepositoriesAdapter)
        if(adapter == null){
            adapter = IssuesActivityRepositoriesAdapter(view.context, repositories)
            view.adapter = adapter
        }
    }

    @BindingAdapter("issuesList")
    fun setIssuesList(view: RecyclerView, issues: ArrayList<Issue>){
        if(issues.isNullOrEmpty()){
            return
        }
        val layoutManager = view.layoutManager
        if(layoutManager == null){
            view.layoutManager = GridLayoutManager(view.context, NUM_COLUMNS)
        }
        var adapter: IssuesActivityIssuesAdapter = view.adapter as (IssuesActivityIssuesAdapter)
        if(adapter == null){
            adapter = IssuesActivityIssuesAdapter(view.context, issues)
            view.adapter = adapter
        }
    }
}