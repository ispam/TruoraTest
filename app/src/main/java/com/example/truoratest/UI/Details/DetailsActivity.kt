package com.example.truoratest.UI.Details

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.truoratest.Data.Local.Entities.Host
import com.example.truoratest.Data.Local.Entities.Record
import com.example.truoratest.Data.Local.ViewModel.RecordViewModel
import com.example.truoratest.R
import com.example.truoratest.UI.App
import com.example.truoratest.UI.Home.MainActivity
import com.example.truoratest.Utils.emptyExtra
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_details.*
import java.util.*
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

        title = getString(R.string.details_title)

        if (intent.extras != null) {
            host = intent.extras.getParcelable("host")

            details_host.text = host.host
            details_port.text = host.port.toString()
            details_protocol.text = host.protocol
            details_public.text = host.isPublic.toString()
            details_status.text = host.status
            details_start.text = Date(host.startTime).toString()
            details_engine.text = host.engineVersion
            details_criteria.text = host.criteriaVersion

            disposable.add(recordVM.createRecord(Record(host.host))
                .subscribeOn(Schedulers.io())
                .doOnComplete { Log.i("createRecord", "Record created") }
                .subscribe())

        } else {
            emptyExtra(this)
        }
    }

    override fun onStop() {
        if (!disposable.isDisposed) disposable.clear()
        super.onStop()
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)

        super.onBackPressed()
    }
}
