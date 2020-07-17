package com.zelvi.shareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ComponentActivity.ExtraData
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ShareActionProvider
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService



class MainActivity : AppCompatActivity() {

    lateinit var sharebutton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharebutton = findViewById(R.id.button) as Button

        sharebutton.setOnClickListener {
            val shareIntent = Intent(android.content.Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here")
            val app_url = " https://play.google.com/store/apps/details?id=my.example.javatpoint"
            shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, app_url)
            startActivity(Intent.createChooser(shareIntent, "Share via"))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        var menuInflate = menuInflater
        menuInflate.inflate(R.menu.menu_bar, menu)
//        if (menu != null) {
//            fav = menu.add("My Cart")
//        };
//        fav.setIcon(R.drawable.ic_cart_outline);
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val shareIntent = Intent(android.content.Intent.ACTION_SEND)
        shareIntent.type = "text/plain"
        shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Insert Subject here")
        val app_url = " https://play.google.com/store/apps/details?id=my.example.javatpoint"
        shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, app_url)

        when(item.getItemId()){
            R.id.share -> {
                startActivity(Intent.createChooser(shareIntent, "Share via"))
            }
            R.id.menu_share -> {
                Toast.makeText(applicationContext, "Feature is locked", Toast.LENGTH_LONG).show()
            }
            R.id.menu_profile -> {
                startActivity(Intent.createChooser(shareIntent, "Share via"))
            }

            R.id.menu_logout -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }


}
