package com.capotter.dmlprogressplanner.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.capotter.dmlprogressplanner.R
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import com.capotter.dmlprogressplanner.databinding.MilestonesProjectItemBinding

class MilestonesActivityRepositoriesAdapter(private val mContext: Context, private val mRepositories: ArrayList<GitHubRepository>) :
    RecyclerView.Adapter<MilestonesActivityRepositoriesAdapter.BindingHolder>() {

    private val TAG: String = "MilestonesActivityRepositoriesAdapter"

    fun refreshList(repositories: List<GitHubRepository>){
        mRepositories.clear()
        mRepositories.addAll(repositories)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val binding: MilestonesProjectItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext), R.layout.milestones_project_item, parent, false)
        return BindingHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mRepositories.size
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val repository = mRepositories[position]

        holder.binding.repository = repository
    }


    class BindingHolder(view: View) : RecyclerView.ViewHolder(view) {

        var binding: MilestonesProjectItemBinding = DataBindingUtil.bind(view)!!

    }
}