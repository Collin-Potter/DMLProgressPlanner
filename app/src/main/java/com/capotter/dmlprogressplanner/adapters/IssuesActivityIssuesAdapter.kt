package com.capotter.dmlprogressplanner.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.capotter.dmlprogressplanner.R
import com.capotter.dmlprogressplanner.data.model.Issue
import com.capotter.dmlprogressplanner.databinding.IssuesItemListItemBinding

class IssuesActivityIssuesAdapter(private val mContext: Context, private val mIssues: ArrayList<Issue>) :
    RecyclerView.Adapter<IssuesActivityIssuesAdapter.BindingHolder>() {

    private val TAG: String = "IssuesActivityIssuesAdapter"

    fun refreshList(repositories: List<Issue>){
        mIssues.clear()
        mIssues.addAll(repositories)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val binding: IssuesItemListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext), R.layout.issues_item_list_item, parent, false)
        return BindingHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mIssues.size
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val issue = mIssues[position]

        holder.binding.issue = issue
    }


    class BindingHolder(view: View) : RecyclerView.ViewHolder(view) {

        var binding: IssuesItemListItemBinding = DataBindingUtil.bind(view)!!

    }
}