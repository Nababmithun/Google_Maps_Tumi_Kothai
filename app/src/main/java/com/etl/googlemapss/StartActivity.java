package com.etl.googlemapss;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.logging.Handler;

public class StartActivity extends AppCompatActivity {
    ImageView mainLogo;
    Animation rotate,scale;
    TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_start);
        if(getIntent().getBooleanExtra("EXIT",false)){


            finish();

        }
        appName = findViewById(R.id.appName);
        mainLogo = findViewById(R.id.mainLogo);

        scale = AnimationUtils.loadAnimation(this,R.anim.eeees);
        rotate = AnimationUtils.loadAnimation(this,R.anim.rrrr);

        appName.startAnimation(scale);
        mainLogo.startAnimation(rotate);
        appName.startAnimation(scale);





        final ImageView iv = (ImageView) findViewById(R.id.mainLogo);
        final Animation an = AnimationUtils.loadAnimation(getBaseContext(),R.anim.eeees);
        final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(),R.anim.fade_out);


        iv.startAnimation(an);
        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(an2);
                finish();
                Intent i = new Intent(StartActivity.this, PermissionsActivity.class);
                startActivity(i);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });



    }

}