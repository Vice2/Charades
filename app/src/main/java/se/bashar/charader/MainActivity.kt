package se.bashar.charader

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.Animation
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity



class MainActivity : AppCompatActivity() {

    var blinkt: TextView? = null
    var blinkb: Button? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val blinkb : Button = findViewById(R.id.blinkb);
        blinkt = findViewById(R.id.blinktext);


        val startButton: Button = findViewById(R.id.playButton)

        startButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }
        blinkb.setOnClickListener {
            val intent = Intent(this, TestActivity::class.java)
            startActivity(intent)
        }

        object : CountDownTimer(30000, 1000) {

            val timerTextField = findViewById<TextView>(R.id.textView)

            override fun onTick(millisUntilFinished: Long) {
                timerTextField.setText("seconds remaining: " + millisUntilFinished / 1000)
            }

            override fun onFinish() {
                timerTextField.setText("done!")
            }
        }.start()

    }


}