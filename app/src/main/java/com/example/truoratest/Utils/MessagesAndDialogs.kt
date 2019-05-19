package com.example.truoratest.Utils

import android.app.ProgressDialog
import android.content.Context
import android.widget.Toast
import com.example.truoratest.R

private lateinit var progressDialog: ProgressDialog

fun showProgressDialog(context: Context): ProgressDialog {
    progressDialog = ProgressDialog(context)
    progressDialog.setCancelable(false)
    progressDialog.setMessage(context.getString(R.string.dialog_loading))
    progressDialog.show()
    return progressDialog
}

fun hideProgressDialog() {
    if (::progressDialog.isInitialized && progressDialog.isShowing) progressDialog.dismiss()
}

fun emptyQuery(context: Context) {
    Toast.makeText(context, context.getString(R.string.query_empty), Toast.LENGTH_SHORT).show()
}

fun emptyExtra(context: Context) {
    Toast.makeText(context, context.getString(R.string.empty_extra), Toast.LENGTH_SHORT).show()
}