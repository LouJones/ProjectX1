package com.example.drinksafe;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by Louise on 28/03/2015.
 */
public class Splash extends Activity {
MediaPlayer splashsound;


        @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        splashsound = MediaPlayer.create(Splash.this, R.raw.liquid);
            splashsound.start();
                Thread logoTimer = new Thread(){
                    public void run(){
                        try{sleep(5000);
                            Intent menuIntent = new Intent("com.example.drinksafe.MAIN");
                            startActivity(menuIntent);
                            }catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        finally{


                            finish();
                                             }
                    }
                };
            logoTimer.start();
        }


    }