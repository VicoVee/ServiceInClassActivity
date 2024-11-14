package edu.temple.myapplication

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var timeBinder : TimerService.TimerBinder
    var isConnected = false

    val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            timeBinder = p1 as TimerService.TimerBinder
            isConnected = true
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            isConnected = false
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bindService(
            Intent(this, TimerService::class.java),
            serviceConnection,
            BIND_AUTO_CREATE
        )

        //Create service connection object
        findViewById<Button>(R.id.startButton).setOnClickListener {
            Log.d("VIVI", isConnected.toString())
            if(isConnected) {
                timeBinder.start(100)
            }
        }
        
        findViewById<Button>(R.id.stopButton).setOnClickListener {
            timeBinder.stop()
        }
    }

    //TODO: Interface the buttons
    //call the function: Start(100)
    //call function: Stop the timer
    //When you click the start second time, it pauses the timer
    //and the text of the button is changed to "Pause" and vice versa
    //Implement a handler to change the text of the button
}