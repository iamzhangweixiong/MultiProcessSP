package com.wilson.multiprocesssp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.wilson.multiprocesssp.synconfig.PreferenceManager

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity() {

    private var testValue = "test_value"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            PreferenceManager.getMultiProcessSp().setStringValue(testValue, "test")
        }

        getValue.setOnClickListener {
            val value = PreferenceManager.getMultiProcessSp().getStringValue(testValue, "default")
            Toast.makeText(this, value, Toast.LENGTH_LONG).show()
        }
    }
}
