import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.*;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main0 {
    public static void main(String[] args) throws IOException {

        String login = "kitsekaterina"; //"08012002@mail.ru";

        String password = "k12345"; //"1282565121024QWEasdfZXC";

        String loginURL = "https://login.dnevnik.ru/";

        Connection.Response LoginCookiesResponse = null;

        try {
            LoginCookiesResponse = Jsoup.connect(loginURL)
                    .method(Connection.Method.POST)
                    .data("login", login)
                    .data("password", password)
                    .execute();
        }catch (Exception e){
            System.out.println(LoginCookiesResponse == null);
            e.printStackTrace();
            System.exit(0);
        }

        Map<String, String> cookies = LoginCookiesResponse.cookies();

        Connection.Response connect = null;
        Document doc = null;
        try {
            connect = Jsoup.connect("https://schools.dnevnik.ru/marks.aspx?school=19267&index=2&tab=period&period=3")
                    .referrer("https://dnevnik.ru/feed")
                    .cookies(cookies)
                    .execute();
            doc = connect.charset("utf-8").parse();
        }catch (Exception e){
            e.printStackTrace();
        }

        Main.ShowDetailsOf(connect);

        File marks = new File("E://marks_intelij.html");

        BufferedWriter MarksWriter = new BufferedWriter(new FileWriter(marks));
        MarksWriter.write(String.valueOf(doc.select("div#content").first()));
        MarksWriter.close();

    }
}
