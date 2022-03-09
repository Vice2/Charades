package se.bashar.charader

import android.os.Bundle
import android.os.CountDownTimer
import android.os.PersistableBundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import kotlin.random.Random

class GameActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        lateinit var wordToGuess: String
        val theword = findViewById<TextView>(R.id.thewordTextView)
        val img = findViewById<ImageView>(R.id.redImageView)
        var alfa = 0f
        var dura = 1000
        val newGameButton = findViewById<Button>(R.id.newGameButton)

        /*
        fun imgAnime()
        {
            img.alpha = alfa
            img.animate().alpha(1f).duration = dura
        }
        */

        theword.text= "Tryck för att starta"

        newGameButton.setOnClickListener {

        }
        theword.setOnClickListener {
            val randomIndex = Random.nextInt(0, WordObject.thewords.size)
            wordToGuess = WordObject.thewords[randomIndex]
            theword.setText(wordToGuess)

            object : CountDownTimer(10000, 1000) {

                val timerTextField = findViewById<TextView>(R.id.textView)


                override fun onTick(millisUntilFinished: Long) {
                    //timerTextField.setText("seconds remaining: " + millisUntilFinished / 1000)
                    img.alpha = 0f
                    img.animate().alpha(1f).duration = 1000
                }

                override fun onFinish() {
                    //timerTextField.setText("done!")
                    //img.alpha = 0f
                    //img.animate().alpha(1f).duration = 0
                    theword.text = "Tiden är ute!!"
                    theword.isClickable = false
                }
            }.start()
        }




    }
}