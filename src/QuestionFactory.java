import org.apache.commons.lang3.StringEscapeUtils;
import org.json.JSONArray;
import org.json.JSONObject;

public class QuestionFactory {

    public static Question getQuestion(JSONObject jsonObject){
        Question q =null;
        String question = StringEscapeUtils.unescapeHtml4(jsonObject.getString("question"));
        String difficulty = StringEscapeUtils.unescapeHtml4(jsonObject.getString("difficulty"));
        String correctAnswer = StringEscapeUtils.unescapeHtml4(jsonObject.getString("correct_answer"));
        String[] incorrectAnswers = getIncorrectAnswers(jsonObject.getJSONArray("incorrect_answers"));
        String multi = "multiple";
        String bool = "boolean";
        if(jsonObject.get("type").equals(multi)){
            q = new MultipleChoiceQuestions(question,difficulty,correctAnswer,incorrectAnswers);
        }else if(jsonObject.get("type").equals(bool)){
            q = new TrueFalseQuestions(question,difficulty,correctAnswer);
        }
        return q;
    }

    private static String[] getIncorrectAnswers(JSONArray array){
        String[] arr = new String[array.length()];
        for (int i=0; i< array.length(); i++){
            arr[i] = StringEscapeUtils.unescapeHtml4(array.getString(i));
        }
        return arr;
    }
}
