package com.example.lifecycle

import android.nfc.Tag
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class MyLifeCycleOwner : LifecycleOwner{

    private val TAG = "MyLifeCycleOwner"

    private lateinit var lifeCycleRegistry : LifecycleRegistry

    constructor() {
        this.lifeCycleRegistry = LifecycleRegistry(this)
    }

    override fun getLifecycle(): Lifecycle {
            return lifeCycleRegistry
    }

    fun markState(state : Lifecycle.State){
        lifeCycleRegistry.markState(state)
    }

}