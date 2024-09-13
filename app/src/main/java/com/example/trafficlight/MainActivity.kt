package com.example.trafficlight

import android.app.Activity
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.trafficlight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var isStop = true
    private var isGo = false
    private var isWait = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        // Sets button color
        binding.trafficLightButton.apply {
            setBackgroundColor(getColor(R.color.red))
            text = "STOP"
        }

        // Set up button listener to cycle the button color and text
        binding.trafficLightButton.setOnClickListener {
            if(isStop) {
                // set Green
                binding.trafficLightButton.apply {
                    setBackgroundColor(getColor(R.color.green))
                    text = "GO"
                }
                // Reset cycle
                isStop = false
                isGo = true
                isWait = false
            } else if (isGo) {
                // set Yellow
                binding.trafficLightButton.apply {
                    setBackgroundColor(getColor(R.color.yellow))
                    text = "WAIT"
                }
                // Next cycle
                isStop = false
                isGo = false
                isWait = true
            } else if (isWait) {
                // set red
                binding.trafficLightButton.apply {
                    setBackgroundColor(getColor(R.color.red))
                    text = "STOP"
                }
                // New cycle
                isStop = true
                isGo = false
                isWait = false
            }
        }
        // Cycle the traffic light images
        binding.trafficLightButton.setOnClickListener {
            if (isStop){
                binding.redLight.visibility = View.INVISIBLE
                binding.yellowLight.visibility = View.INVISIBLE
                binding.greenLight.visibility = View.VISIBLE

                binding.trafficLightButton.apply {
                    setBackgroundColor(getColor(R.color.green))
                    text = "GO"
                }
                isStop = false
                isGo = true
                isWait = false
            } else if (isGo){
                binding.redLight.visibility = View.INVISIBLE
                binding.yellowLight.visibility = View.VISIBLE
                binding.greenLight.visibility = View.INVISIBLE

                binding.trafficLightButton.apply {
                    setBackgroundColor(getColor(R.color.yellow))
                    text = "WAIT"
                }
                isStop = false
                isGo = false
                isWait = true
            } else if (isWait) {
                binding.redLight.visibility = View.VISIBLE
                binding.yellowLight.visibility = View.INVISIBLE
                binding.greenLight.visibility = View.INVISIBLE

                binding.trafficLightButton.apply {
                    setBackgroundColor(getColor(R.color.red))
                    text = "STOP"
                }
                isStop = true
                isGo = false
                isWait = false
            }
        }


        }
    }





