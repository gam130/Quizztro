package com.gautam.fblaappfinal;
/*
This is the class that contains the Events Questions and Answers
Accessed through QuestionActivity to display questions
*/
public class EventsQuestions implements QuestionBank {
    public String[] eventsQs = {
            "What are the different sets of events?",
            "How many FBLA events are there?",
            "The top _ from SLC qualify for NLC.",
            "Where are the tests/events developed?",
            "Which of the following is not a category of events?"
    };

    private String[][] options = {
            {"Individual, Team, Chapter", "Important, Team, School", "Individual, Group, Category"},
            {"13", "34", "72"},
            {"7", "5", "4"},
            {"California", "New York", "Virginia"},
            {"Objective Tests", "Challenges", "Speech"}
    };

    private String[] correctAnswers = {"Individual, Team, Chapter", "72", "4", "Virginia", "Challenges"};
    public boolean[] askedAlready = {false, false, false, false, false};

    public String getQuestion(int s){
        return eventsQs[s];
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
        return eventsQs.length;
    }
}
