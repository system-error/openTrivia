public abstract class Question {
    private String question;
//    private String type;
    private String difficulty;

    public Question(String question,String difficulty){
        this.question = question;
        this.difficulty = difficulty;
    }

    public String getQuestion() {
        return question;
    }

    abstract void displayAllTheAnswers();
    abstract boolean checkTheAnswer(int number);
    abstract String displayTheCorrectAnswer();

}
