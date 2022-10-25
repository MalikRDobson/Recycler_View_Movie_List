package com.example.movielisttest

import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.recyclerview.widget.RecyclerView
import com.example.movielisttest.R

class MovieViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
    val tvMovieTitle: TextView = view.findViewById(R.id.tv_movie_title)
    val ivMovieImage: ImageView = view.findViewById(R.id.iv_movie_image)
    val rbMovieRating: RatingBar = view.findViewById(R.id.rb_movie_rating)
    val tvMovieGenre: TextView = view.findViewById(R.id.tv_movie_genre)
    val tvMovieYear: TextView = view.findViewById(R.id.tv_movie_year)
    val wgMovieGroup: Group = view.findViewById(R.id.wg_movie_group)
    val ibExpand: ImageButton = view.findViewById(R.id.ib_expand)
}
