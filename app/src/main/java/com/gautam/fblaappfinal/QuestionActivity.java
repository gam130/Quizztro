package com.gautam.fblaappfinal;
/*
This class controls the Question/Quiz screen
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

public class QuestionActivity extends AppCompatActivity {

    //declaration of all elements on the screen
    ImageButton answer1, answer2, answer3;
    TextView question, answerText1, answerText2, answerText3, scoreD, streakD;



    private QuestionBank questions;

    private String cAnswer;
    private int score = 0;
    private int rawScore = 0;
    private int streak = 0;
    private int highestStreak = 0;
    private int numQuestions;

    Random r;
    //Lottie Animations used for correct/incorrect animations, learn more at https://github.com/airbnb/lottie-android
    LottieAnimationView check;
    LottieAnimationView xmark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //Sets the app's DPI to 420 (eliminates need to resize resources or layouts for different phone screen sizes)
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();

        Configuration config = this.getResources().getConfiguration();
        displayMetrics.densityDpi = 420; //DisplayMetrics.DENSITY_LOW;
        config.densityDpi = 420; //DisplayMetrics.DENSITY_LOW;

        this.getResources().updateConfiguration(config, displayMetrics);
        setContentView(R.layout.activity_question);


        r = new Random();
        //Gets the context of the earlier activity
        Bundle extras = getIntent().getExtras();
        //Chooses the question bank based on the button pressed on the categories screen
        if(extras.getString("type").equals("history")){
            questions = new HistoryQuestions();
        }
        else if ((extras.getString("type").equals("events"))){
            questions = new EventsQuestions();
        }
        else if(extras.getString("type").equals("NLC")){
            questions = new NLCQuestions();
        }
        else if(extras.getString("type").equals("parlipro")){
            questions = new ParliProQuestions();
        }
        else if (extras.getString("type").equals("business")){
            questions = new BusinessSkillsQuestions();
        }
        else {
            //Chooses a random Question Bank
            int picker = (int)(Math.random() * 5 + 1);
            switch(picker){
                case 1:
                    questions = new HistoryQuestions();
                    break;
                case 2:
                    questions = new EventsQuestions();
                    break;
                case 3:
                    questions = new NLCQuestions();
                    break;
                case 4:
                    questions = new ParliProQuestions();
                    break;
                case 5:
                    questions = new BusinessSkillsQuestions();
                    break;
                default:
                    questions = new HistoryQuestions();
            }
        }
        //Sets the number of questions to the length of the questions array in the Question Bank
        numQuestions = questions.getAmountQs();



        //assignment of screen elements/change in font
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

        //Shows First question
        updateQuestion();

        //When the top answer button is clicked
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //disables all answer buttons
                answer1.setEnabled(false);
                answer2.setEnabled(false);
                answer3.setEnabled(false);
                //checks if answer is correct and adds score and streak appropriately + plays animation
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
                    //updates question after small delay for animation
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            updateQuestion();
                        }
                    }, 1500);


                }
                //if answer is wrong
                else{
                    streak = 0;
                    check.setAnimation("error_cross.json");
                    check.loop(false);
                    check.playAnimation();
                    //updates question after small delay for animation
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            updateQuestion();
                        }
                    }, 1500);
                }
            }
        });
        //When the middle answer button is clicked
        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //disables all answer buttons
                answer1.setEnabled(false);
                answer2.setEnabled(false);
                answer3.setEnabled(false);
                //checks if answer is correct and adds score and streak appropriately + plays animation
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
                    //updates question after small delay for animation
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            updateQuestion();
                        }
                    }, 1500);
                }
                //if answer is wrong
                else{
                    streak = 0;
                    check.setAnimation("error_cross.json");
                    check.loop(false);
                    check.playAnimation();
                    //updates question after small delay for animation
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            updateQuestion();
                        }
                    }, 1500);
                }
            }
        });
        //When the bottom answer button is clicked
        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //disables all answer buttons
                answer1.setEnabled(false);
                answer2.setEnabled(false);
                answer3.setEnabled(false);
                //checks if answer is correct and adds score and streak appropriately + plays animation
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
                    //updates question after small delay for animation
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            updateQuestion();
                        }
                    }, 1500);

                }
                //if answer is wrong
                else{
                    streak = 0;
                    check.setAnimation("error_cross.json");
                    check.loop(false);
                    check.playAnimation();
                    //updates question after small delay for animation
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            updateQuestion();
                        }
                    }, 1500);
                }
            }
        });

    }
    //method to update question
    private void updateQuestion(){
        //checks if questions are over or if randomly selected question has already been used before updating
        int a = questionCheck(r.nextInt(numQuestions));

        //sets elements to new question if questions are not over and if new question has not been used already
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
    //Checks if randomly selected question was used already
    private int questionCheck(int a){
        //return parameter (question number) if that question has not been used
        if(!questions.getQuestionStatus(a)){
            return a;
        }
        //checks if all the questions have been answered
        else if(questions.checkAllAnswered()){
            //replace with activity for end screen
            Intent intent = new Intent(QuestionActivity.this, EndActivity.class);
            intent.putExtra("finalScore", rawScore);
            intent.putExtra("weightedScore", score);
            intent.putExtra("highStreak", highestStreak);
            startActivity(intent);
            return 0;
        }
        //if the question has been answered and not all questions have been answered, the function calls itself with a different parameter to recursively check questions until it finds an unused one
        else{
            return questionCheck(r.nextInt(numQuestions));
        }
    }
}
