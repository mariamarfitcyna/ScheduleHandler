import org.json.simple.parser.ParseException;

import java.util.List;

public class main {
    public static void main(String[] args) throws ParseException {
        Parser parser = new Parser();
        String text = parser.request("https://urfu.ru/api/schedule/groups/");
        System.out.println(text);
        Urfu_class urfu = new Urfu_class();
        urfu.urfuGroups = parser.getGroups(text);
        for (Group i : urfu.urfuGroups){
            System.out.println(i.getId() + " " + i.getInstitute_id());
        }
        for (Group group : urfu.urfuGroups){

        }
    }
}
