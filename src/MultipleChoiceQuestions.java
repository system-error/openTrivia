import java.util.ArrayList;
import java.util.Collections;

public class MultipleChoiceQuestions extends Question {
    private String correctAnswer;
    private String[] incorrectAnswers;
    private ArrayList<String> allTheAnswers = new ArrayList<>();

    public MultipleChoiceQuestions(String question, String difficulty, String correctAnswer,String[] incorrectAnswers){
        super(question,difficulty);
        this.correctAnswer = correctAnswer;
        this.incorrectAnswers = incorrectAnswers;
    }

    @Override
    protected void displayAllTheAnswers() {
        shuffleTheAnswers();
        int counter = 1;
        for (String theAnswer: allTheAnswers){
            System.out.println(counter+" "+theAnswer);
            counter++;
        }
        System.out.println("Choose one number of "+(counter-1)+" :");
    }

    @Override
    protected String displayTheCorrectAnswer() {
        return correctAnswer;
    }

    @Override
    protected boolean checkTheAnswer(int number) {
            if(allTheAnswers.get(number-1).equals(correctAnswer)){
                System.out.println("You found it!");
                return true;
            }else{
                System.out.println("Wrong answer");
                return false;
            }
    }

    private ArrayList<String> shuffleTheAnswers(){
        int numberOfAnswers = this.incorrectAnswers.length;
            for(int i=0; i < numberOfAnswers; i++){
                allTheAnswers.add(this.incorrectAnswers[i]);
            }
        allTheAnswers.add(this.correctAnswer);
        Collections.shuffle(allTheAnswers);
        return allTheAnswers;
    }

}
