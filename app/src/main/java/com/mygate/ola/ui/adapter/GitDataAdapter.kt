package com.mygate.ola.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.TransitionManager
import com.bumptech.glide.Glide
import com.mygate.ola.R
import com.mygate.ola.model.GitApiData
import kotlinx.android.synthetic.main.item_recycle_view.view.*

class GitDataAdapter(val context: Context, val data: List<GitApiData>, val rView: RecyclerView) :
    RecyclerView.Adapter<GitDataAdapter.MyViewHolder>() {


    var mExpandedPosition = -1


    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitle = itemView.tvTitle
        val tvDesc = itemView.tvDesc
        val tvLink = itemView.tvLink
        val img = itemView.img
        val llStats = itemView.llStats
        val tvStars = itemView.tvStars
        val tvLanguage = itemView.tvLanguage
        val tvForks = itemView.tvForks
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_recycle_view, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = data.get(position)
        holder.tvTitle.text = item.author
        holder.tvDesc.text = item.description
        holder.tvLink.text = item.url
        holder.tvStars.text = item.stars.toString()
        holder.tvForks.text = item.forks.toString()
        holder.tvLanguage.text = item.language

        Glide.with(context).load(item.avatar).into(holder.img)
        val isExpanded = position == mExpandedPosition;
        holder.llStats.visibility = if (isExpanded) View.VISIBLE else View.GONE
        holder.tvLink.visibility=if (isExpanded) View.VISIBLE else View.GONE
        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener {
            mExpandedPosition = if (isExpanded) -1 else position
            TransitionManager.beginDelayedTransition(rView);
            notifyDataSetChanged();
        }

    }
}