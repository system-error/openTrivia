import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.*;

public class Categories {

    private static int id;
    private static String name;
    private static ArrayList<String> categories = new ArrayList<>();
    private static void takeAllTheCategories(){
        try {
            URL calltheUrl = new URL("https://opentdb.com/api_category.php");
            URLConnection conn = calltheUrl.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            if ((inputLine =in.readLine()) !=null){
                JSONObject json = new JSONObject(inputLine);
                JSONArray jsonarray = json.getJSONArray("trivia_categories");
                for (int i = 0; i < jsonarray.length(); i++) {
                    JSONObject jsonobject = jsonarray.getJSONObject(i);
                    id = (int)jsonobject.get("id");
                    name = (String)jsonobject.get("name");
                    categories.add(id + " " + name);
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void displayTheCategories(){
        takeAllTheCategories();
        for (String category : categories){
            System.out.println(category);
        }
    }
}
