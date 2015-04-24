package com.example.drinksafe;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Louise on 28/03/2015.
 */
public class Splash extends Activity {
    //declaring the variable/place to hold the splashsound for use in the code
MediaPlayer splashsound;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
            //set the splash screen to be shown
        setContentView(R.layout.splash);
            //allocating the splashsound to the sound stored in raw folder
        splashsound = MediaPlayer.create(Splash.this, R.raw.liquid);
            //starting splash sound
            splashsound.start();
            //creating the new thread to set the splashsound to run for a set amount of time
                Thread logoTimer = new Thread(){
                    public void run(){
                        try{sleep(5000);
                            //after set amount of time use the intent in manifest to open the main menu page
                            Intent menuIntent = new Intent("com.example.drinksafe.MAIN");
                            //start the declared intent to open manin menu page
                            startActivity(menuIntent);
                            //catch for if the logotimer does not work
                            }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        finally{
                        //finish
                            finish();
                        }
                    }
                };
            //start logotimer thread
            logoTimer.start();
        }

    }