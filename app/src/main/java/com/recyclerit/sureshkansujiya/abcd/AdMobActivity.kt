package com.recyclerit.sureshkansujiya.abcd

import android.graphics.Color
import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.android.gms.ads.*
import com.google.android.gms.ads.AdView
import kotlinx.android.synthetic.main.activity_ad_mob.*
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import java.util.*
import android.widget.Toast
import android.content.Intent




class AdMobActivity : AppCompatActivity() {

    var mp: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ad_mob)

        MobileAds.initialize(this, "ca-app-pub-7486954764491752~3697969996")

        val adRequest = AdRequest.Builder()
                .build()

        // Start loading the ad in the background.
        ad_view.loadAd(adRequest)

        val alphabets = listOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")

        // Initialize a new pager adapter instance with list
        val adapter = AlphabetPagerAdapter(alphabets)

        // Finally, data bind the view pager widget with pager adapter
        view_pager.adapter = adapter

        view_pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {
                //throw UnsupportedOperationException()
                // your code
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
                //throw UnsupportedOperationException()
                // your code
            }
            // 6. when some views conflict with swipe back , you should do these, for example:
            override fun onPageSelected(position: Int) {

                when(position) {
                    0 -> setFragementData(playerItem = R.raw.a)
                    1 -> setFragementData(playerItem = R.raw.b)
                    2 -> setFragementData(playerItem = R.raw.c)
                    3 -> setFragementData(playerItem = R.raw.d)
                    4 -> setFragementData(playerItem = R.raw.e)
                    5 -> setFragementData(playerItem = R.raw.f)
                    6 -> setFragementData(playerItem = R.raw.g)
                    7 -> setFragementData(playerItem = R.raw.h)
                    8 -> setFragementData(playerItem = R.raw.i)
                    9 -> setFragementData(playerItem = R.raw.j)
                    10 -> setFragementData(playerItem = R.raw.k)
                    11 -> setFragementData(playerItem = R.raw.l)
                    12 -> setFragementData(playerItem = R.raw.m)
                    13 -> setFragementData(playerItem = R.raw.n)
                    14 -> setFragementData(playerItem = R.raw.o)
                    15 -> setFragementData(playerItem = R.raw.p)
                    16 -> setFragementData(playerItem = R.raw.q)
                    17 -> setFragementData(playerItem = R.raw.r)
                    18 -> setFragementData(playerItem = R.raw.s)
                    19 -> setFragementData(playerItem = R.raw.t)
                    20 -> setFragementData(playerItem = R.raw.u)
                    21 -> setFragementData(playerItem = R.raw.v)
                    22 -> setFragementData(playerItem = R.raw.w)
                    23 -> setFragementData(playerItem = R.raw.x)
                    24 -> setFragementData(playerItem = R.raw.y)
                    25 -> setFragementData(playerItem = R.raw.z)
                }
            }
        })
    }

    override fun onPause() {
        super.onPause()
        if (mp != null) {
            mp?.stop()
            if (isFinishing) {
                mp?.stop()
                mp?.release()
            }
        }
    }

    fun setFragementData(playerItem: Int) {
        this.mp?.stop()
        this.mp?.release()
        this.mp = MediaPlayer.create(this, playerItem)
        this.mp?.start()
        this.mp?.isLooping = true
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        openWhatsApp()
        return true
    }

    private fun openWhatsApp() {
        val smsNumber = "7****" //without '+'
        try {
            val sendIntent = Intent("android.intent.action.MAIN")
            //sendIntent.setComponent(new ComponentName("com.whatsapp", "com.whatsapp.Conversation"));
            sendIntent.action = Intent.ACTION_SEND
            sendIntent.type = "text/plain"
            var shareMessage = "\nLet me recommend you this application\n\n"
            shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID + "\n\n"
            sendIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            sendIntent.putExtra("jid", "$smsNumber@s.whatsapp.net") //phone number without "+" prefix
            sendIntent.`package` = "com.whatsapp"
            startActivity(sendIntent)
        } catch (e: Exception) {
            Toast.makeText(this, "Error/n" + e.toString(), Toast.LENGTH_SHORT).show()
        }

    }
}
