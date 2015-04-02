package com.example.drinksafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.ErrorReason;
import com.google.android.youtube.player.YouTubePlayer.PlaybackEventListener;
import com.google.android.youtube.player.YouTubePlayer.PlayerStateChangeListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;


public class YouTube extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {
    Button main;
        public static final String API_KEY = "AIzaSyBzwHsLoTZExz8MPM9LL866EwKTCVZvunM";

        //my youtube video id>
        public static final String VIDEO_ID = "6jl1ur2qrY8";

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //calling to set you tube xml
            setContentView(R.layout.activity_you_tube);

            //inistialising YouTubePlayerView
            YouTubePlayerView youTubePlayerView;
            //telling which object to look for
            youTubePlayerView = (YouTubePlayerView) findViewById(R.id.youtube_player);
            youTubePlayerView.initialize(API_KEY, this);
            //call buttons method
            Buttons();

        }

    private void Buttons() {
        main = (Button) findViewById(R.id.btnHome);
        //setting on click listener for button to do something when clicked
        main.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                //message to say you clicked button
                Toast.makeText(YouTube.this, "You clicked the Main Menu Button", Toast.LENGTH_SHORT).show();
                Intent mainmenu = new Intent("com.example.drinksafe.MAIN");
                startActivity(mainmenu);
            }
        });
    }

    @Override
        public void onInitializationFailure(Provider provider, YouTubeInitializationResult result) {
            Toast.makeText(this, "Failed to Initialize!", Toast.LENGTH_LONG).show();
        }

        @Override
        public void onInitializationSuccess(Provider provider, YouTubePlayer player, boolean wasRestored) {

            //creating listeners for player
            player.setPlayerStateChangeListener(playerStateChangeListener);
            player.setPlaybackEventListener(playbackEventListener);

            //start playing video
            if (!wasRestored) {
                player.cueVideo(VIDEO_ID);
            }
        }

        private PlaybackEventListener playbackEventListener = new PlaybackEventListener() {

            @Override
            public void onBuffering(boolean arg0) {
            }

            @Override
            public void onPaused() {
            }

            @Override
            public void onPlaying() {
            }

            @Override
            public void onSeekTo(int arg0) {
            }

            @Override
            public void onStopped() {
            }

        };

        private PlayerStateChangeListener playerStateChangeListener = new PlayerStateChangeListener() {

            @Override
            public void onAdStarted() {
            }

            @Override
            public void onError(ErrorReason arg0) {
            }

            @Override
            public void onLoaded(String arg0) {
            }

            @Override
            public void onLoading() {
            }

            @Override
            public void onVideoEnded() {
            }

            @Override
            public void onVideoStarted() {
            }
        };
}
