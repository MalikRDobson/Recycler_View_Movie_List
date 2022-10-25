package com.example.movielisttest.model.remote

import android.net.Uri
import com.example.movielisttest.model.MovieResponse
import com.example.movielisttest.model.Response
import org.json.JSONArray
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL


class MovieNetwork{
    // https://gist.githubusercontent.com/
    // AntoninoAN/f3fa4b2260c51a5f80904c747009289e/raw/6576691177f6b093afd3bf2bbc5e936b62d50721/MovieGist
    companion object{
        const val  BASE_URL = "https://gist.githubusercontent.com/"
        const val ENDPOINT = "AntoninoAN/f3fa4b2260c51a5f80904c747009289e/raw/a1403b33a4c0d9a40d1901f6aeba065abc748a38/MovieGist"
        val uriPath = Uri.parse("$BASE_URL$ENDPOINT")
        val url = URL(uriPath.toString())
    }

    fun getMovieList(): List<MovieResponse>{
        val httpURLConnection = url.openConnection() as HttpURLConnection

        httpURLConnection.readTimeout = 10000
        httpURLConnection.connectTimeout = 15000
        httpURLConnection.requestMethod = "GET"
        httpURLConnection.doInput = true

        httpURLConnection.connect()

        return httpURLConnection.inputStream.run {
            deserializeIs(this)
        }.let{
            parseToMovieResponse(it)
        }
    }
     fun deserializeIs(iS: InputStream): String{
         val builder = StringBuilder()
         val reader = BufferedReader(InputStreamReader(iS))
         var line: String?  = reader.readLine()
        while (line != null){
            builder.append(line)
            builder.append("\n")
            line = reader.readLine()
         }
         if (builder.isEmpty()) {

             return "N/A"
         }
         //var resultString = builder.toString()
         return builder.toString()
     }
    fun parseToMovieResponse(deserialize: String): List<MovieResponse>{
        val response = JSONArray(deserialize)

        /* until:
            index  = [0,1,2,... response.length - 1]
            until would not include the last value but if i do:
            0.. response.length=
            it would include the last value
        */
        val movieResponseList = Response()
        val listOfMovies = mutableListOf<MovieResponse>()
        for(index in 0 until response.length()){
            val movieElement = response.getJSONObject(index)
            val movieResponse = MovieResponse(
                rating = movieElement.getDouble("rating").toFloat(),
                image = movieElement.getString("image"),
                title = movieElement.getString("title"),
                releaseYear =  movieElement.getInt("releaseYear"),
                /* getJSONArray looks for the array in that specific object
                 so in genre there is a JSONArray in there
                */
                genre = movieElement.getJSONArray("genre").parseJSONArrayToList()
            )
            movieResponseList.add(movieResponse)
            listOfMovies.add(movieResponse)
        }
        return movieResponseList
    }
    /* basically adds functionality to a class
     */
    private fun JSONArray.parseJSONArrayToList(): List<String>{
        val result = mutableListOf<String>()
        for(i in 0 until this.length()){
            result.add(this.getString(i))
        }
        return result
    }
}