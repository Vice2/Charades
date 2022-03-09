package se.bashar.charader

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import kotlin.random.Random

class GameActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        lateinit var wordToGuess: String
        val theword = findViewById<TextView>(R.id.thewordTextView)
        val redImg = findViewById<ImageView>(R.id.redImageView)
        val blueImg = findViewById<ImageView>(R.id.blueImageView)
        val newGameButton = findViewById<Button>(R.id.newGameButton)

        theword.text= "Tryck för att starta"
        redImg.isVisible = false
        blueImg.isVisible = true


        theword.setOnClickListener {
            val randomIndex = Random.nextInt(0, WordObject.thewords.size)
            wordToGuess = WordObject.thewords[randomIndex]
            theword.setText(wordToGuess)

            object : CountDownTimer(10000, 1000) {

                //val timerTextField = findViewById<TextView>(R.id.textView)

                override fun onTick(millisUntilFinished: Long) {
                    //timerTextField.setText("seconds remaining: " + millisUntilFinished / 1000)
                    blueImg.alpha = 0f
                    blueImg.animate().alpha(1f).duration = 1000
                }

                override fun onFinish() {
                    theword.text = "Tiden är ute!!"
                    theword.isClickable = false
                    blueImg.isInvisible = false
                    redImg.isVisible = true
                }
            }.start()
        }

        newGameButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            finish()
            startActivity(intent)

        }

    }
}