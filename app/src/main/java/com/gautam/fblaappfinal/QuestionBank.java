package com.gautam.fblaappfinal;
/*
This Interface holds all the questions classes
Enables polymorphism depending on what category user chooses
*/
public interface QuestionBank {
    String getQuestion(int s);
    String getChoice1(int s);
    String getChoice2(int s);
    String getChoice3(int s);
    String getCorrectAnswer(int s);
    boolean getQuestionStatus(int s);
    void setQuestionStatus(int s);
    boolean checkAllAnswered();
    int getAmountQs();
}
