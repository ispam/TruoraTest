package com.example.truoratest.UI.Home

import android.app.SearchManager
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.widget.SearchView
import com.example.truoratest.Data.Local.Entities.Record
import com.example.truoratest.Data.Local.ViewModel.RecordViewModel
import com.example.truoratest.Data.Remote.APIService
import com.example.truoratest.R
import com.example.truoratest.UI.App
import com.example.truoratest.UI.Details.DetailsActivity
import com.example.truoratest.Utils.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private val disposable = CompositeDisposable()

    @Inject
    lateinit var apiService: APIService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.component.inject(this)

        val searchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
        search_field.setSearchableInfo(searchManager.getSearchableInfo(componentName))

        val searchCloseBtn = findViewById<ImageView>(R.id.search_close_btn)
        searchCloseBtn.setOnClickListener { search_field.setQuery("", false) }

        search_field.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {

                if (isOnline(this@MainActivity)) {
                    if (!query.isNullOrEmpty()) {
                        val map = HashMap<String, String>()
                        map["host"] = query
                        disposable.add(apiService.getHostInfo(map)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSubscribe { showProgressDialog(this@MainActivity) }
                            .doOnError { e -> Log.e("getHostInfo", e.message) }
                            .doOnSuccess { Log.i("getHostInfo", "Host info received") }
                            .map {
                                val intent = Intent(this@MainActivity, DetailsActivity::class.java)
                                intent.putExtra("host", it)
                                startActivity(intent)
                            }
                            .doOnDispose { hideProgressDialog() }
                            .subscribe())
                    } else {
                        emptyQuery(this@MainActivity)
                    }
                } else {
                    noInternetConnection(this@MainActivity)
                }

                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun onStop() {
        if (!disposable.isDisposed) disposable.clear()
        super.onStop()
    }
}
