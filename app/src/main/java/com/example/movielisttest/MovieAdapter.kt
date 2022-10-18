package com.example.movielisttest

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MovieAdapter(private val dataset: List<String>):
    RecyclerView.Adapter<MovieViewHolder>() {

    /**
     * Used to create the ViewHolder.
     * This will be called only ONCE
     * If the structure of the ViewHolder changes, this one
     * will be called again
     * Get LayoutInflater.from(context)
     * Context needs to be FROM
     * Base context(ContextThemeWrapper)
     * base context provides Themes,Resources and
     * the Inflater
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.movie_item_layout,parent, false))
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        if(position % 2 == 0) {
            holder.itemView.setBackgroundColor(Color.BLUE)
        }
        holder.tvMovieTitle.text = dataset[position]
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}