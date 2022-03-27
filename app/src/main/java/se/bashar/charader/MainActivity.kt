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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.playButton)
        val rulesText : TextView = findViewById(R.id.rulesTextview)
        val theText =  "\n" +
                "Regler för spelet\n" +
                "\n" +
                "Låt alla sitta i en ring. Varannan person är i samma lag.\n" +
                "\n" +
                "Målet med spelet är att få din lagkamrat att gissa ordet utan att använda något av nedanstående:\n" +
                "-- Order\n" +
                "-- En del av ordet\n" +
                "-- Ord som rimmar\n" +
                "\n" +
                "Om ditt lag gissar ordet korrekt skicka enheten till personen till höger om dig (som tillhör det andra laget).\n" +
                "\n" +
                "Tryck på skärmen för att få nästa ord.\n" +
                "Fortsätt att passera enheten tills timern tar slut.\n" +
                "\n" +
                "Teamet som håller enheten när timern tar slut förlorar.\n"

        startButton.setOnClickListener {
            val intent = Intent(this, GameActivity::class.java)
            startActivity(intent)
        }

        rulesText.text = theText



    }


}