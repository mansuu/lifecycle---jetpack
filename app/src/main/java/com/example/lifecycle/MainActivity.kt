package com.example.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {

    private lateinit var lifeCycleObserver : MyLifecycleObserver
    private lateinit var lifeCycleOwner: MyLifeCycleOwner

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifeCycleObserver = MyLifecycleObserver()
        //lifecycle.addObserver(lifeCycleObserver) // If Life Cycle owner is default(provided by Android framework)


        //IF Life cycle owner is custom class but have to mark state and use LifeCycle Registery
        lifeCycleOwner = MyLifeCycleOwner()
        lifeCycleOwner.markState(Lifecycle.State.CREATED)
        lifeCycleOwner.lifecycle.addObserver(lifeCycleObserver)

    }

    override fun onRestart() {
        super.onRestart()
        lifeCycleOwner.markState(Lifecycle.State.STARTED)
    }


    override fun onResume() {
        super.onResume()
        lifeCycleOwner.markState(Lifecycle.State.RESUMED)
    }

}

