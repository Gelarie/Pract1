package com.example.myapplication

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by прпр on 14.02.2018.
 */
class UsersAdapter(private var items: ArrayList<GitInfo>): RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val repo = items[position]
        holder?.RepoName?.text = repo.name
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent?.context)
                .inflate(R.layout.repo_list_row, parent, false)

        return ViewHolder(itemView)
    }

    class ViewHolder(row: View) : RecyclerView.ViewHolder(row) {
        var RepoName: TextView? = null

        init {
            this.RepoName = row?.findViewById<TextView>(R.id.repoName)
        }
    }
}




