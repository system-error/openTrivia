import java.util.ArrayList;

public class TrueFalseQuestions extends Question{
    private String correctAnswer;
    private ArrayList<String> allTheAnswers = new ArrayList<>();


    public TrueFalseQuestions(String question, String difficulty, String correctAnswer){
        super(question,difficulty);
        this.correctAnswer = correctAnswer.toLowerCase();


    }
    @Override
    protected void displayAllTheAnswers() {
        shuffleTheAnswers();
        int counter = 1;
        for (String theAnswer: allTheAnswers){
            System.out.println(counter+" "+theAnswer);
            counter++;
        }
    }


    @Override
    protected boolean checkTheAnswer(int number) {
        if(allTheAnswers.get(number-1).equals(correctAnswer)){
            System.out.println("found!");
            return true;
        }else{
            System.out.println("no");
            return false;
        }
    }

    @Override
    protected String displayTheCorrectAnswer() {
        return correctAnswer;
    }

    private ArrayList<String> shuffleTheAnswers(){
        if(correctAnswer.equals("true")){
            allTheAnswers.add("false");
            allTheAnswers.add("true");
        }else if(correctAnswer.equals("false")){
            allTheAnswers.add("true");
            allTheAnswers.add("false");
        }
        return allTheAnswers;
    }
}
