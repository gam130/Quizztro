package com.gautam.fblaappfinal;
/*
This is the class that contains the NLC Dates and Locations Questions and Answers
Accessed through QuestionActivity to display questions
*/
public class NLCQuestions implements QuestionBank {
    public String[] NLCQs = {
            "Where is 2019 NLC held?",
            "When is the first day of NLC?",
            "What season is NLC in?",
            "Where was last year's (2018) NLC held?",
            "How many days is NLC?"
    };

    private String[][] options = {
            {"Anaheim, CA", "Baltimore, MD", "San Antonio, TX"},
            {"April 13, 2019", "June 29, 2019", "May 26, 2019"},
            {"Summer", "Fall", "Spring"},
            {"Cleveland, OH", "Richmond, VA", "Baltimore, MD"},
            {"2", "4", "6"}
    };

    private String[] correctAnswers = {"San Antonio, TX", "June 29, 2019", "Summer", "Baltimore, MD", "4"};
    public boolean[] askedAlready = {false, false, false, false, false};

    public String getQuestion(int s){
        return NLCQs[s];
    }
    public String getChoice1(int s){
        return options[s][0];
    }
    public String getChoice2(int s){
        return options[s][1];
    }
    public String getChoice3(int s){
        return options[s][2];
    }
    public String getCorrectAnswer(int s){
        return correctAnswers[s];
    }
    public boolean getQuestionStatus(int s){return askedAlready[s];}
    public void setQuestionStatus(int s){askedAlready[s] = true;}
    public boolean checkAllAnswered(){
        for(int i = 0; i < askedAlready.length; i++){
            if(!askedAlready[i]){
                return false;
            }
        }
        return true;
    }
    public int getAmountQs(){
        return NLCQs.length;
    }
}
