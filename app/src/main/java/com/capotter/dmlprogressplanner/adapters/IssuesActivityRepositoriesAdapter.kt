package com.capotter.dmlprogressplanner.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.capotter.dmlprogressplanner.R
import com.capotter.dmlprogressplanner.data.model.GitHubRepository
import com.capotter.dmlprogressplanner.databinding.IssuesProjectItemBinding

class IssuesActivityRepositoriesAdapter(private val mContext: Context, private val mRepositories: ArrayList<GitHubRepository>) :
    RecyclerView.Adapter<IssuesActivityRepositoriesAdapter.BindingHolder>() {

    private val TAG: String = "IssuesActivityRepositoriesAdapter"

    fun refreshList(repositories: List<GitHubRepository>){
        mRepositories.clear()
        mRepositories.addAll(repositories)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val binding: IssuesProjectItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext), R.layout.issues_project_item, parent, false)
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

        var binding: IssuesProjectItemBinding = DataBindingUtil.bind(view)!!

    }
}