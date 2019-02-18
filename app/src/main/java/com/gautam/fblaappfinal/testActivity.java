package com.gautam.fblaappfinal;
/*
Test Actvity for Question Activity (NOT USED)
*/
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Random;

public class testActivity extends AppCompatActivity {

    ImageButton answer1, answer2, answer3;
    TextView question, answerText1, answerText2, answerText3, scoreD, streakD;



    private HistoryQuestions questions = new HistoryQuestions();

    private String cAnswer;
    private int score = 0;
    private int rawScore = 0;
    private int streak = 0;
    private int highestStreak = 0;
    private int numQuestions = questions.historyQs.length;

    Random r;
    LottieAnimationView check;
    LottieAnimationView xmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();

        Configuration config = this.getResources().getConfiguration();
        displayMetrics.densityDpi = 420; //DisplayMetrics.DENSITY_LOW;
        config.densityDpi = 420; //DisplayMetrics.DENSITY_LOW;

        this.getResources().updateConfiguration(config, displayMetrics);
        setContentView(R.layout.activity_question);
        HistoryQuestions questions = new HistoryQuestions();
        r = new Random();

        answer1 = (ImageButton) findViewById(R.id.answer1);
        answer2 = (ImageButton) findViewById(R.id.answer2);
        answer3 = (ImageButton) findViewById(R.id.answer3);

        question = (TextView) findViewById(R.id.question);
        answerText1 = (TextView) findViewById(R.id.answerText1);
        answerText2 = (TextView) findViewById(R.id.answerText2);
        answerText3 = (TextView) findViewById(R.id.answerText3);

        check = (LottieAnimationView) findViewById(R.id.checkmark);
        xmark = (LottieAnimationView) findViewById(R.id.xmark);

        scoreD = (TextView) findViewById(R.id.score);
        streakD = (TextView) findViewById(R.id.streak);

        Typeface t = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Regular.ttf");
        Typeface t1 = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Bold.ttf");

        question.setTypeface(t);
        answerText1.setTypeface(t);
        answerText2.setTypeface(t);
        answerText3.setTypeface(t);
        scoreD.setTypeface(t1);
        streakD.setTypeface(t1);

        updateQuestion();

        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer1.setEnabled(false);
                answer2.setEnabled(false);
                answer3.setEnabled(false);
                if(answerText1.getText() == cAnswer){
                    streak++;
                    if(streak > highestStreak){
                        highestStreak = streak;
                    }
                    rawScore++;
                    score += streak * 100;
                    check.setAnimation("success.json");
                    check.loop(false);
                    check.playAnimation();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            updateQuestion();// yourMethod();
                        }
                    }, 1500);


                }
                else{
                    streak = 0;
                    check.setAnimation("error_cross.json");
                    check.loop(false);
                    check.playAnimation();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            updateQuestion();// yourMethod();
                        }
                    }, 1500);
                }
            }
        });
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer1.setEnabled(false);
                answer2.setEnabled(false);
                answer3.setEnabled(false);
                if(answerText2.getText() == cAnswer){
                    streak++;
                    if(streak > highestStreak){
                        highestStreak = streak;
                    }
                    rawScore++;
                    score += streak * 100;
                    check.setAnimation("success.json");
                    check.loop(false);
                    check.playAnimation();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            updateQuestion();// yourMethod();
                        }
                    }, 1500);
                }
                else{
                    streak = 0;
                    check.setAnimation("error_cross.json");
                    check.loop(false);
                    check.playAnimation();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            updateQuestion();// yourMethod();
                        }
                    }, 1500);
                }
            }
        });
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                answer1.setEnabled(false);
                answer2.setEnabled(false);
                answer3.setEnabled(false);
                if(answerText3.getText() == cAnswer){
                    streak++;
                    if(streak > highestStreak){
                        highestStreak = streak;
                    }
                    rawScore++;
                    score += streak * 100;
                    check.setAnimation("success.json");
                    check.loop(false);
                    check.playAnimation();

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            updateQuestion();// yourMethod();
                        }
                    }, 1500);

                }
                else{
                    streak = 0;
                    check.setAnimation("error_cross.json");
                    check.loop(false);
                    check.playAnimation();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            updateQuestion();// yourMethod();
                        }
                    }, 1500);
                }
            }
        });

    }
    private void updateQuestion(){
        int a = questionCheck(r.nextInt(numQuestions));
        question.setText(questions.getQuestion(questionCheck(a)));
        answerText1.setText(questions.getChoice1(questionCheck(a)));
        answerText2.setText(questions.getChoice2(questionCheck(a)));
        answerText3.setText(questions.getChoice3(questionCheck(a)));
        cAnswer = questions.getCorrectAnswer(questionCheck(a));
        questions.setQuestionStatus(questionCheck(a));
        scoreD.setText(String.valueOf(score));
        streakD.setText(String.valueOf(streak));
        answer1.setEnabled(true);
        answer2.setEnabled(true);
        answer3.setEnabled(true);

    }
    private int questionCheck(int a){
        if(!questions.getQuestionStatus(a)){
            return a;
        }
        else if(questions.checkAllAnswered()){
            //replace with activity for end screen
            Intent intent = new Intent(testActivity.this, EndActivity.class);
            intent.putExtra("finalScore", rawScore);
            intent.putExtra("weightedScore", score);
            intent.putExtra("highStreak", highestStreak);
            startActivity(intent);
            return 0;
        }
        else{
            return questionCheck(r.nextInt(numQuestions));
        }
    }
}
