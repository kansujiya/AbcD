package com.recyclerit.sureshkansujiya.abcd

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.constraint.ConstraintLayout
import android.transition.TransitionManager
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.recyclerit.sureshkansujiya.abcd.R.id.constraintLayout
import com.recyclerit.sureshkansujiya.abcd.R.styleable.ConstraintSet
import kotlinx.android.synthetic.main.activity_splash.*
import android.view.animation.AnimationUtils.loadAnimation
import android.view.animation.Animation
import android.view.animation.LinearInterpolator
import android.view.animation.RotateAnimation
import com.google.android.gms.ads.*
import java.util.*


/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class Splash : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        getWindow().getDecorView().setBackgroundColor(randomLightColor(70,80))

        appCompatTextView.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.animation_text))

        icon.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.animation_v))

        Handler().postDelayed({
            startActivity(Intent(this@Splash, AdMobActivity::class.java))
            finish()
        },4000)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        // Trigger the initial hide() shortly after the activity has been
        // created, to briefly hint to the user that UI controls
        // are available.
    }

    // Generate random light hsv color
    private fun randomLightColor(lightPercent:Int,blackPercent:Int=100):Int{
        // Color variance - red, green, blue etc
        val hue = Random().nextInt(361).toFloat()

        // Color light to dark - 0 light 100 dark
        val saturation = lightPercent.toFloat()/100F

        // Color black to bright - 0 black 100 bright
        val brightness:Float = blackPercent.toFloat()/100F

        // Transparency level, full opaque
        val alpha = 255

        // Return the color
        return Color.HSVToColor(alpha,floatArrayOf(hue,saturation,brightness))
    }
}
