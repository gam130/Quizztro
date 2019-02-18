package com.gautam.fblaappfinal;
/*
This class controls the categories screen
*/
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

public class CategoriesActivity extends AppCompatActivity {

    //declaration of all elements on the screen
    ImageButton historyButton;
    ImageButton eventsButton, NLCButton, parliButton, businessButton, randomButton;
    TextView chooseText1, chooseText2, chooseText3, chooseText4, chooseText5, chooseText6;
    String catType;
    @Override
    @SuppressLint("ClickableViewAccessibility")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        //assignment of screen elements/change in font
        historyButton = (ImageButton) findViewById(R.id.catButton1);
        eventsButton = (ImageButton) findViewById(R.id.catButton2);
        NLCButton = (ImageButton) findViewById(R.id.catButton3);
        parliButton = (ImageButton) findViewById(R.id.catButton4);
        businessButton = (ImageButton) findViewById(R.id.catButton5);
        randomButton = (ImageButton) findViewById(R.id.catButton6);
        chooseText1 = (TextView) findViewById(R.id.chooseText1);
        chooseText2 = (TextView) findViewById(R.id.chooseText2);
        chooseText3 = (TextView) findViewById(R.id.chooseText3);
        chooseText4 = (TextView) findViewById(R.id.chooseText4);
        chooseText5 = (TextView) findViewById(R.id.chooseText5);
        chooseText6 = (TextView) findViewById(R.id.chooseText6);
        Typeface t = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        chooseText1.setTypeface(t);
        chooseText2.setTypeface(t);
        chooseText3.setTypeface(t);
        chooseText4.setTypeface(t);
        chooseText5.setTypeface(t);
        chooseText6.setTypeface(t);
        //animation initialization
        final Animation ani = AnimationUtils.loadAnimation(this, R.anim.clickanim);

        //Each button goes to the same screen when clicked, but sends a different string to signal which set of questions should be used
        historyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyButton.startAnimation(ani);
                catType = "history";
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        QuestionActivity();// yourMethod();
                    }
                }, 150);

            }
        });
        eventsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eventsButton.startAnimation(ani);
                catType = "events";
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        QuestionActivity();// yourMethod();
                    }
                }, 150);

            }
        });
        NLCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NLCButton.startAnimation(ani);
                catType = "NLC";
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        QuestionActivity();// yourMethod();
                    }
                }, 150);

            }
        });
        parliButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                parliButton.startAnimation(ani);
                catType = "parlipro";
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        QuestionActivity();// yourMethod();
                    }
                }, 150);

            }
        });
        businessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                businessButton.startAnimation(ani);
                catType = "business";
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        QuestionActivity();// yourMethod();
                    }
                }, 150);

            }
        });


        randomButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomButton.startAnimation(ani);
                catType = "rand";
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    public void run() {
                        QuestionActivity();// yourMethod();
                    }
                }, 150);

            }
        });

    }
    //The method starts a new QuestionActivity activity and sends the category type as a string for context
    public void QuestionActivity(){
        Intent intent = new Intent(CategoriesActivity.this, QuestionActivity.class);
        intent.putExtra("type", catType);
        startActivity(intent);
    }
}
