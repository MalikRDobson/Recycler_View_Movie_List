package com.example.movielisttest.model

import androidx.loader.content.AsyncTaskLoader

/**
 *in-memory data representation
 * provides by defualt:
 * toString()
 * hashcode()
 * equals()
 * copy()
 * componentN()
 * it cannot be inherited
 * it needs at least 1 field/property
 */
data class MovieResponse(
    val title: String,
    val image: String,
    val rating: Float,
    val releaseYear: Int,
    val genre: List<String>
)
class Response: ArrayList<MovieResponse>()
