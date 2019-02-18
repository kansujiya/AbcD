package com.recyclerit.sureshkansujiya.abcd

import android.graphics.Color
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_splash.*
import java.util.*

class AlphabetPagerAdapter(private val list: List<String>) : PagerAdapter() {

    init {}

    override fun isViewFromObject(v: View, `object`: Any): Boolean {
        // Return the current view
        return v === `object` as View
    }


    override fun getCount(): Int {
        // Count the items and return it
        return list.size
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        // Get the view from pager page layout
        val view = LayoutInflater.from(container?.context)
                .inflate(R.layout.activity_alphabet_pager_adapter,container,false)

        // Get the widgets reference from layout
        val linearLayout: LinearLayout = view.findViewById(R.id.linear_layout)
        val tvLower: TextView = view.findViewById(R.id.tv_lower)
        val tvLUpper: TextView = view.findViewById(R.id.tv_upper)

        // Set the text views text
        tvLower.text = list.get(position).toUpperCase()
        tvLUpper.text = list.get(position)

        // Set the text views text color
        tvLower.setTextColor(randomLightColor(70,80))
        tvLUpper.setTextColor(randomLightColor(90,70))
        tvLUpper.setBackgroundColor(randomLightColor(50,60))
        tvLower.setBackgroundColor(randomLightColor(40,30))
        // Set the layout background color
        linearLayout.setBackgroundColor(randomLightColor(10))

        // Add the view to the parent
        container?.addView(view)

        tvLower.startAnimation(AnimationUtils.loadAnimation(view.context,
                        R.anim.rotation_animation))

        tvLUpper.startAnimation(AnimationUtils.loadAnimation(view.context,
                R.anim.rotation_animation))

        // Return the view
        return view
    }


    override fun destroyItem(parent: ViewGroup, position: Int, `object`: Any) {
        // Remove the view from view group specified position
        parent.removeView(`object` as View)
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