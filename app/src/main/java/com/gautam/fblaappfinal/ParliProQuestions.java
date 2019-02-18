package com.gautam.fblaappfinal;
/*
This is the class that contains the Parlimentary Procedure Questions and Answers
Accessed through QuestionActivity to display questions
*/
public class ParliProQuestions implements QuestionBank {
    public String[] ParliProQs = {
            "No two national officers can be elected from the same...?",
            "If previous notice is to be given at a meeting, ",
            "Which article in the FBLA bylaws describes the information about FBLA dues?",
            "In case of a tie vote on an ordinary main motion...",
            "A board has the character of a deliberate assembly, except"
    };

    private String[][] options = {
            {"City", "State", "Region"},
            {"The full text of the motion or resolution must be submitted", "It must be in writing", "It is in order to do so even after it has been voted to adjourn"},
            {"Article IV", "Article II", "Article V"},
            {"Another vote must be taken", "The motion is lost", "The presiding officer, who is a member, must vote to break the tie"},
            {"Boards have no minimum size", "Its powers are delegated to it by an authority outside itself", "All of the above"}
    };

    private String[] correctAnswers = {"State", "It is in order to do so even after it has been voted to adjourn", "Article IV", "The motion is lost", "All of the above"};
    public boolean[] askedAlready = {false, false, false, false, false};

    public String getQuestion(int s){
        return ParliProQs[s];
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
        return ParliProQs.length;
    }
}
