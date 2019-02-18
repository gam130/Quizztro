package com.gautam.fblaappfinal;
/*
This class controls the End Screen after the user completes a section
*/
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class EndActivity extends AppCompatActivity {
    //declaration of all elements on the screen
    TextView yougot;
    TextView scoreDisplay;
    LottieAnimationView endAnim;
    ImageButton playagain, shareButton;
    TextView scorefinal, highstreak;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        //assignment of screen elements/change in font
        yougot = (TextView) findViewById(R.id.yougot);
        scoreDisplay = (TextView) findViewById(R.id.scoreDisplay);
        endAnim = (LottieAnimationView) findViewById(R.id.trophyOrFail);
        playagain = (ImageButton) findViewById(R.id.playagain);
        shareButton = (ImageButton) findViewById(R.id.shareButton);
        scorefinal = (TextView) findViewById(R.id.scoreFinal);
        highstreak = (TextView) findViewById(R.id.streakFinal);

        Typeface t = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");
        yougot.setTypeface(t);
        scorefinal.setTypeface(t);
        highstreak.setTypeface(t);

        //Get the context of the previous activity and display the score based on that context
        final Bundle extras = getIntent().getExtras();
        scoreDisplay.setText(((extras.getInt("finalScore")) + " / 5"));
        scoreDisplay.setTypeface(t);
        scorefinal.setText(String.valueOf(extras.getInt("weightedScore")));
        highstreak.setText(String.valueOf(extras.getInt("highStreak")));
        //plays trophy animation if score was greater than 3 out of 5
        endAnim.setAnimation("2497-trophy.json");
        endAnim.loop(false);
        if((extras.getInt("finalScore") > 2)){
            endAnim.playAnimation();
        }

        //animation initialization
        final Animation ani = AnimationUtils.loadAnimation(this, R.anim.clickanim);
        final Animation ani2 = AnimationUtils.loadAnimation(this, R.anim.releaseanim);

        //Go back to categories when play again button is clicked
        playagain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        playagain.startAnimation(ani);
                        return true;
                    case MotionEvent.ACTION_UP:
                        playagain.startAnimation(ani2);

                        categoriesActivity();
                        return true;
                }
                return false;
            }
        });

        //Share the user's score when the share button is clicked
        //Supports any interface/application in which a share function is valid (all forms of social media)
        shareButton.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        shareButton.startAnimation(ani);
                        return true;
                    case MotionEvent.ACTION_UP:
                        shareButton.startAnimation(ani2);
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        String shareHead = "My Quizztro Score!";
                        String shareBody = "I scored " + String.valueOf(extras.getInt("weightedScore") + " points on Quizztro! Can you beat me?");
                        intent.putExtra(Intent.EXTRA_SUBJECT, shareHead);
                        intent.putExtra(Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(intent, "Share Score with"));
                        return true;
                }
                return false;
            }
        });
    }
    //Start categories activity
    public void categoriesActivity(){
        Intent intent = new Intent(EndActivity.this, CategoriesActivity.class);
        startActivity(intent);
    }

}
