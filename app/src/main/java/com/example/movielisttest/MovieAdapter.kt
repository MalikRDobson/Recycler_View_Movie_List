package com.example.movielisttest

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.movielisttest.model.MovieResponse
import com.squareup.picasso3.Picasso

class MovieAdapter(private val dataset: List<MovieResponse>):
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
            holder.itemView.setBackgroundColor(Color.GRAY)
        }
        holder.tvMovieTitle.text = dataset[position].title
        holder.tvMovieYear.text = dataset[position].releaseYear.toString()
        holder.tvMovieGenre.text = dataset[position].genre.toString()
        holder.rbMovieRating.rating = dataset[position].rating
        holder.ibExpand.setOnClickListener {
            if(!holder.wgMovieGroup.isVisible)
                holder.wgMovieGroup.visibility = View.VISIBLE
            else
                holder.wgMovieGroup.visibility = View.GONE
        }
        Picasso
            .Builder(holder.itemView.context)
            .build()
            .load(dataset[position].image)
            .into(holder.ivMovieImage)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}