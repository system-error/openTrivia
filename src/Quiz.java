import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;


public class Quiz {
    private Scanner in = new Scanner(System.in);
    private int score = 0;
    private Question[] questions;
    //https://opentdb.com/api.php?amount=2&category=21&difficulty=easy&type=multiple
    //for future changes

    public Quiz(int numberOfQuestions){
        callTheUrl("https://opentdb.com/api.php?amount="+numberOfQuestions, numberOfQuestions);

    }

    public Quiz(int id,int numberOfQuestions){
        callTheUrl("https://opentdb.com/api.php?amount="+numberOfQuestions+"&category=" + id, numberOfQuestions);

    }

    public void displayTheQuestions(){

        for(Question q : questions){
            System.out.println(q.getQuestion());
            q.displayAllTheAnswers();// display answers 1,2,3,4 or 1,2
            int numberOfAnswer = in.nextInt();// get user response
            System.out.println("Your answer is "+numberOfAnswer);
            if(q.checkTheAnswer(numberOfAnswer)){
                score++; // check response and increase score if correct
            }else{
                if(score == 0){
                    score = 0;
                }else{
                    score--;
                }
                System.out.println("The correct answer is "+ q.displayTheCorrectAnswer() + ".");
            }
        }

        if(score > 0){
            System.out.println("Finished. Well done");
            System.out.println("Your total score is "+ score + " points!");
        }else{
            System.out.println("Your score is 0!");
        }
    }

    private void callTheUrl(String url, int numberOfQuestions){
         questions = new Question[numberOfQuestions];
        try {
            URL callTheUrl = new URL(url);
            URLConnection conn = callTheUrl.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            if ((inputLine =in.readLine()) !=null){
                JSONObject json = new JSONObject(inputLine);
                JSONArray jsonarray = json.getJSONArray("results");
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    System.out.println(jsonobject);
                    questions[i] = QuestionFactory.getQuestion(jsonobject);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
