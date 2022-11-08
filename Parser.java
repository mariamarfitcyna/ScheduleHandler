import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static String request(String urlPath){
        HttpURLConnection connection = null;
        String inputLine = "";
        String resultData = "";
        InputStream is = null;
        try {
            URL url = new URL(urlPath);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(300);
            connection.setReadTimeout(300);
            is = connection.getInputStream();
            BufferedReader bufferReader  = new BufferedReader(new InputStreamReader(is));
            while ((inputLine = bufferReader.readLine()) != null ){
                resultData +=inputLine + "\n";
            }
        } catch (MalformedURLException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (is != null){
                try{
                    is.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (connection != null){
                connection.disconnect();
            }
        }
        return resultData;
    }

    public static List<Group> getGroups(String jstr) throws ParseException {
        JSONParser parser = new JSONParser();
        JSONArray jsonArray = (JSONArray) parser.parse(jstr);
        List<Group> groupList = new ArrayList<>();
        for (Object it : jsonArray) {
            //System.out.println(it);
            JSONObject jsonGroup = (JSONObject) it;

            long id = (long)jsonGroup.get("id");
            long institute_id = (long)jsonGroup.get("institute_id");
            Group group = new Group((int)id, (int)institute_id);
            groupList.add(group);
        }
        return groupList;
    }

}
