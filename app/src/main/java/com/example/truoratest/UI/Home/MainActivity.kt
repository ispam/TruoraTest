package com.example.truoratest.UI.Home

import android.app.SearchManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import com.example.truoratest.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        search_field.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        val searchCloseBtn = findViewById<ImageView>(R.id.search_close_btn)
        searchCloseBtn.setOnClickListener { search_field.setQuery("", false) }

        search_field.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {

                return true
            }
        })
    }
}
