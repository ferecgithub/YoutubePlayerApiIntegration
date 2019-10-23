package com.example.youtubedenemekotlin

import android.os.Bundle
import android.widget.Toast
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : YouTubeBaseActivity() {

    companion object {
        val VIDEO_ID: String = "ATmOqUzJ_eU"
        val YOUTUBE_API_KEY: String = "oluşturduğumuz YOUTUBEAPIKEY"
    }

    lateinit var youtubePlayerInit: YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUI()
    }

    private fun initUI() {
        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(p0: YouTubePlayer.Provider?, youtubePlayer: YouTubePlayer?, p2: Boolean) {
                //kod hatasız olursa onInitializationSuccess implament metodu çalışacak
                youtubePlayer?.loadVideo(VIDEO_ID)
            }

            override fun onInitializationFailure(p0: YouTubePlayer.Provider?, p1: YouTubeInitializationResult?) {
                //Eğer hatalı olursa da onInitializationFailure bu implament metodu çalışacak
                Toast.makeText(applicationContext, "yolunda gitmeyen bir şeyler var!", Toast.LENGTH_LONG).show()
            }
        }

        btnPlay.setOnClickListener {
            youtubePlayer.initialize(YOUTUBE_API_KEY, youtubePlayerInit)
        }
    }

}