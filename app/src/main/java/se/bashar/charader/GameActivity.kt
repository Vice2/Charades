package se.bashar.charader

import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import se.bashar.charader.databinding.ActivityGameBinding
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private lateinit var binding : ActivityGameBinding
    lateinit var mediaPlayer : MediaPlayer

    lateinit var counttimer : CountDownTimer

    var isRunning = false
    var timerCount = 300
    var blinkCount = 0
    var blinkTarget = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)


        lateinit var wordToGuess: String
        val theword = binding.thewordTextView
        val newGameButton = binding.newGameButton

        theword.setTextColor(Color.rgb(0,0,0))
        theword.text= "STARTA"

        mediaPlayer = MediaPlayer.create(this, R.raw.beginsound)

        counttimer = object : CountDownTimer(1000000, 100) {

           override fun onTick(millisUntilFinished: Long) {
                //timerTextField.setText("seconds remaining: " + millisUntilFinished / 1000)
                if(isRunning)
                {
                    timerCount = timerCount - 1
                    /*
                    blinkCount = blinkCount + 1
                    if (blinkCount == blinkTarget)
                    {
                        blinkCount = 0
                        blinkTarget = blinkTarget -1

                        mediaPlayer.start()
                    }
                    */
                    if (timerCount == 0)
                    {
                        theword.setTextColor(Color.rgb(255,255,0))
                        theword.text = "Tiden är ute!!"
                        theword.isClickable = false
                        isRunning = false
                    }
                }
            }

            override fun onFinish() {
                theword.setTextColor(Color.rgb(255,0,0))
                theword.text = "Tiden är ute!!"
                theword.isClickable = false
                mediaPlayer.stop()
                isRunning = false
            }
        }.start()

        theword.setOnClickListener {

            if(isRunning == false)
            {
                mediaPlayer = MediaPlayer.create(this, R.raw.beginsound)
                mediaPlayer.start()
            }

            theword.setTextColor(Color.rgb(45,72,189))
            val randomIndex = Random.nextInt(0, WordObject.thewords.size)
            wordToGuess = WordObject.thewords[randomIndex]
            theword.setText(wordToGuess)
            isRunning = true
            //blinkTarget = 5
            //timerCount = 300
        }

        newGameButton.setOnClickListener {
            /*
            val intent = Intent(this, GameActivity::class.java)
            finish()
            mediaPlayer.stop()
            startActivity(intent)

             */

            isRunning = false
            timerCount = 300
            blinkCount = 0
            blinkTarget = 5
            mediaPlayer.stop()
            mediaPlayer.seekTo(0)
            theword.setText("Start")
        }

    }

    override fun onStop() {
        super.onStop()
        mediaPlayer.stop()

    }
}