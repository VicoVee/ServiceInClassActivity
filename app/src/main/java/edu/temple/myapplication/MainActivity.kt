package edu.temple.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.startButton).setOnClickListener {

        }
        
        findViewById<Button>(R.id.stopButton).setOnClickListener {

        }
    }

    //TODO: Interface the buttons
    //call the function: Start(100)
    //call function: Stop the timer
    //When you click the start second time, it pauses the timer
//  and the text of the button is changed to "Pause" and vice versa
    //Implement a handler to change the text of the button
}