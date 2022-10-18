package com.example.movielisttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class MainActivity : AppCompatActivity() {
    private lateinit var rvMoviewList: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    private fun initViews() {
        rvMoviewList = findViewById(R.id.movie_List)
        rvMoviewList.adapter = MovieAdapter(generateData())
        // tells the recycle view how it is going to be rendered
        rvMoviewList.layoutManager = createLayoutManager()
    }

    private fun createLayoutManager(): RecyclerView.LayoutManager? {
        val linearLayoutManager =
            LinearLayoutManager(this,
            LinearLayoutManager.HORIZONTAL, // sets the orientation
            false)// does the opposite order of the data if its true
        val gridLayoutManager =
            GridLayoutManager(this,
                5, // splits your screen into "3" columns
                GridLayoutManager.HORIZONTAL, // sets the orientation
            true)// does the opposite order of the data if its true
        val staggeredGridLayoutManager =
            StaggeredGridLayoutManager(5, //both same as GridlayoutManager
                StaggeredGridLayoutManager.HORIZONTAL
            )
        return staggeredGridLayoutManager
    }

    private fun generateData(): List<String> {
        return(0..9).map{
            "Movie with the name: $it"
        }
    }
}
/*
1.- Create a Item_Layout (layout xml file)
2.- Subclass of RecylerView.ViewHolder
3.- Subclass of RecyclerView.Adapter
4.- Configure the movielist view
    4.a.- setAdapter
    4.b.- setLayoutManager
 */