package com.capotter.dmlprogressplanner.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.capotter.dmlprogressplanner.R
import com.capotter.dmlprogressplanner.data.model.Milestone
import com.capotter.dmlprogressplanner.databinding.MilestonesItemListItemBinding

class MilestonesActivityMilestonesAdapter(private val mContext: Context, private val mMilestones: ArrayList<Milestone>) :
    RecyclerView.Adapter<MilestonesActivityMilestonesAdapter.BindingHolder>() {

    private val TAG: String = "MilestonesActivityMilestonesAdapter"

    fun refreshList(repositories: List<Milestone>){
        mMilestones.clear()
        mMilestones.addAll(repositories)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val binding: MilestonesItemListItemBinding = DataBindingUtil.inflate(
            LayoutInflater.from(mContext), R.layout.milestones_item_list_item, parent, false)
        return BindingHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return mMilestones.size
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        val milestone = mMilestones[position]

        holder.binding.milestone = milestone
    }


    class BindingHolder(view: View) : RecyclerView.ViewHolder(view) {

        var binding: MilestonesItemListItemBinding = DataBindingUtil.bind(view)!!

    }
}