package com.labawsrh.aws.budibet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    //  Variabel
    private ImageView imgLogo;
    Animation animAlpha;
    Thread thread;
    TextView tvLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //  Deklarasi Variabel
        tvLogo = (TextView)findViewById(R.id.tvLogo);
        imgLogo = (ImageView)findViewById(R.id.activitysplash_ivlogo);
        animAlpha = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
        final Intent intent = new Intent(this, LoginActivity.class);

        //  Eksekusi
        tvLogo.startAnimation(animAlpha);
        imgLogo.startAnimation(animAlpha);
        thread = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                } catch(InterruptedException ie) {
                    ie.printStackTrace();
                } finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        thread.start();

    }
}
