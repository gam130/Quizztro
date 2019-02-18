package com.gautam.fblaappfinal;

/*
This is the class that contains the Business Skills Questions and Answers
Accessed through QuestionActivity to display questions
*/
public class BusinessSkillsQuestions implements QuestionBank {
    public String[] BusinessSkillsQs = {
            "The ability of use one's time effectively or productively at work: ",
            "A set of principles of right conduct: ",
            "Plan and carry on activities effectively - to put order to a situation, objects, or purpose: ",
            "Norms of appropriate, responsible behavior with regard to technology use: ",
            "To assume a position of authority at appropriate times: "
    };

    private String[][] options = {
            {"Clock work", "Time management", "Plagiarism"},
            {"Morals", "The law", "Ethics"},
            {"Organizational skills", "Copyrights", "Top-down management"},
            {"Publishing", "Fair use", "Digital citizenship"},
            {"Freelance", "Leadership", "Teamwork"}
    };

    private String[] correctAnswers = {"Time management", "Ethics", "Organizational skills", "Digital citizenship", "Leadership"};
    public boolean[] askedAlready = {false, false, false, false, false};

    public String getQuestion(int s){
        return BusinessSkillsQs[s];
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
        return BusinessSkillsQs.length;
    }
}
