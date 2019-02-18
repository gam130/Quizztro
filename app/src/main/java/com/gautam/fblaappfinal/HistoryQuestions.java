package com.gautam.fblaappfinal;
/*
This is the class that contains the FBLA History Questions and Answers
Accessed through QuestionActivity to display questions
*/
public class HistoryQuestions implements QuestionBank{

    public String[] historyQs = {
            "Who is the founder of FBLA?",
            "What state was the first FBLA state chapter?",
            "Where was the concept of FBLA first developed?",
            "When was the first high school chapter of FBLA chartered?",
            "Which foundation gave FBLA 1.6 acres of land to build the National Center?"
    };

    private String[][] options = {
            {"Hamden L. Forkner", "Barry Duarte", "Mallory Hogg"},
            {"Maryland", "Georgia", "Iowa"},
            {"Cornell University", "A classroom in North Carolina", "Columbia University"},
            {"1932", "1942", "1947"},
            {"The Wilhelmina Stewart Foundation", "The Conrad N. Hilton Foundation", "The Business Alliance of America"}
    };

    private String[] correctAnswers = {"Hamden L. Forkner", "Iowa", "Columbia University", "1942", "The Conrad N. Hilton Foundation"};
    public boolean[] askedAlready = {false, false, false, false, false};

    public String getQuestion(int s){
        return historyQs[s];
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
        return historyQs.length;
    }
}
