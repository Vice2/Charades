package se.bashar.charader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView


class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        val btn_alpha = findViewById<Button>(R.id.btn_alpha)
        val btn_rotation = findViewById<Button>(R.id.btn_rotation)
        val btn_ScaleX = findViewById<Button>(R.id.btn_ScaleX)
        val btn_ScaleY = findViewById<Button>(R.id.btn_ScaleY)
        val img = findViewById<ImageView>(R.id.img)

        fun imgAnime()
        {
            img.alpha = 0f
            img.animate().alpha(1f).duration = 100
        }

        btn_alpha.setOnClickListener {

            img.alpha = 0f
            img.animate().alpha(1f).duration = 100

        }

        btn_rotation.setOnClickListener {

            img.rotation = 0f
            img.animate().rotation(360f).duration = 8000

        }

        btn_ScaleX.setOnClickListener {

            img.scaleX = 1f
            img.animate().scaleX(0.5f).duration = 8000

        }

        btn_ScaleY.setOnClickListener {

            img.scaleY = 1f
            img.animate().scaleY(0.5f).duration = 8000

        }

        object : CountDownTimer(30000, 1000) {

            val timerTextField = findViewById<TextView>(R.id.textView)

            override fun onTick(millisUntilFinished: Long) {

                timerTextField.setText("seconds remaining: " + millisUntilFinished / 1000)
                //imgAnime()
            }

            override fun onFinish() {
                timerTextField.setText("done!")
            }
        }.start()


    }

}
