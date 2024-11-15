package edu.temple.myapplication

import android.content.ComponentName
import android.content.Intent
import android.content.ServiceConnection
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.IBinder
import android.os.Looper
import android.util.Log
import android.os.Handler
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var timeBinder : TimerService.TimerBinder
    private lateinit var textView : TextView

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
            timeBinder = p1 as TimerService.TimerBinder
            timeBinder.setHandler(timeHandler)
        }

        override fun onServiceDisconnected(p0: ComponentName?) {
            //Do nothing for now
        }
    }

    private val timeHandler = Handler(Looper.getMainLooper(), { me ->
        textView = findViewById(R.id.textView)
        Log.d("VIVI", me.toString())
//        textView.text =
        true
    })

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
            if(!timeBinder.isRunning) {
                timeBinder.start(100)
            } else {
                timeBinder.pause()
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