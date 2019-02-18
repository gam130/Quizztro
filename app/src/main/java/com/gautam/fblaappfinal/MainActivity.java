package com.gautam.fblaappfinal;
/*
This class controls the home screen of the app
*/
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //declaration of all elements on the screen
    ImageButton infoButton;
    ImageButton playbutton;
    TextView title;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //Sets the app's DPI to 420 (eliminates need to resize resources or layouts for different phone screen sizes)
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();
        Configuration config = this.getResources().getConfiguration();
        displayMetrics.densityDpi = 420; //DisplayMetrics.DENSITY_LOW;
        config.densityDpi = 420; //DisplayMetrics.DENSITY_LOW;
        this.getResources().updateConfiguration(config, displayMetrics);


        setContentView(R.layout.activity_main);
        //assignment of screen elements/change in font
        title = (TextView) findViewById(R.id.open);
        Typeface t1 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        title.setTypeface(t1);
        infoButton = (ImageButton) findViewById(R.id.infoButton);
        playbutton = (ImageButton) findViewById(R.id.playButton);
        //animation initialization
        final Animation ani = AnimationUtils.loadAnimation(this, R.anim.clickanim);
        final Animation ani2 = AnimationUtils.loadAnimation(this, R.anim.releaseanim);
        //More info button sends user to InfoActivity
        infoButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        infoButton.startAnimation(ani);
                        return true;
                    case MotionEvent.ACTION_UP:
                        infoButton.startAnimation(ani2);

                        infoActivity();
                        return true;
                }
                return false;
            }
        });
        //Play button sends user to categories activity to pick a category
        playbutton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        playbutton.startAnimation(ani);
                        return true;
                    case MotionEvent.ACTION_UP:
                        playbutton.startAnimation(ani2);

                        categoriesActivity();
                        return true;
                }
                return false;
            }
        });
    }
    //Switch screen to InfoActivity
    public void infoActivity(){

        Intent intent = new Intent(MainActivity.this, InfoActivity.class);
        startActivity(intent);
    }
    //Switch screen to CategoriesActivity
    public void categoriesActivity(){

        Intent intent = new Intent(MainActivity.this, CategoriesActivity.class);
        startActivity(intent);
    }
}
