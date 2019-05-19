package com.example.truoratest.UI.Details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.truoratest.Data.Local.Entities.Host
import com.example.truoratest.Data.Local.ViewModel.RecordViewModel
import com.example.truoratest.R
import com.example.truoratest.UI.App
import com.example.truoratest.Utils.emptyExtra
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class DetailsActivity : AppCompatActivity() {

    private val disposable = CompositeDisposable()
    lateinit var host: Host

    @Inject
    lateinit var recordVM: RecordViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        App.component.inject(this)

        if (intent.extras != null) {
            host = intent.extras.getParcelable("host")
        } else {
            emptyExtra(this)
        }
    }

    override fun onStop() {
        if (!disposable.isDisposed) disposable.clear()
        super.onStop()
    }
}
