import java.util.Scanner;


public class OpenTrivia {

    private Scanner in = new Scanner(System.in);
    private String name;

    public void Greetings(){
        System.out.print("Hello, Please give me your name: ");
        name = in.next();
        System.out.println("Ok "+ name+ " now choose a category that you want to play. " +
                "You should write the number of the category.");
        System.out.println("If you just press 0 you will play with random categories:");
        System.out.println();
        Categories.displayTheCategories();
        int questionId = in.nextInt();
        System.out.println("Please tell me how many questions do you want to play?");
        int numberOfQuestions = in.nextInt();
        checkTheResponse(questionId,numberOfQuestions);

    }

    private void checkTheResponse(int questionId,int numberOfQuestions){
        Quiz q;
        if(questionId == 0){
            q = new Quiz(numberOfQuestions);
        }else{
            q = new Quiz(questionId,numberOfQuestions);
        }
        q.displayTheQuestions();

    }
}
