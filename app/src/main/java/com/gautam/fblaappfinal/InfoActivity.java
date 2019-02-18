package com.gautam.fblaappfinal;
/*
This class controls the screen the user sees when the more info button is clicked
*/
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class InfoActivity extends AppCompatActivity {
    //declaration of all elements on the screen
    TextView abt;
    TextView src1;
    Typeface t;
    ImageButton aboutButton , srcbtn;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        //assignment of screen elements/change in font
        abt = (TextView) findViewById(R.id.abt);
        src1 = (TextView) findViewById(R.id.addinfo);
        t = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        abt.setTypeface(t);
        src1.setTypeface(t);
        aboutButton = (ImageButton) findViewById(R.id.abtbtn);
        srcbtn = (ImageButton) findViewById(R.id.srcbtn);
        //animation initialization
        final Animation ani = AnimationUtils.loadAnimation(this, R.anim.clickanim);
        final Animation ani2 = AnimationUtils.loadAnimation(this, R.anim.releaseanim);
        //send the user to the FBLA website's "About" section when the "About FBLA" button is clicked
        aboutButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        aboutButton.startAnimation(ani);
                        return true;
                    case MotionEvent.ACTION_UP:
                        aboutButton.startAnimation(ani2);

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.fbla-pbl.org/about/"));
                        startActivity(intent);
                        return true;
                }
                return false;
            }
        });
        srcbtn.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        srcbtn.startAnimation(ani);
                        return true;
                    case MotionEvent.ACTION_UP:
                        srcbtn.startAnimation(ani2);

                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/gam130"));
                        startActivity(intent);
                        return true;
                }
                return false;
            }
        });
    }
}
