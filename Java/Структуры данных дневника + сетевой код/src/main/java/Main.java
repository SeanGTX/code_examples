import org.jsoup.Connection;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.w3c.dom.UserDataHandler;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void ShowDetailsOf(Connection.Response response){
        System.out.println(
                "Cookies: " + response.cookies() + "\n" +
                "Cookies length = " + response.cookies().size() + "\n" +
                "Location: " + response.headers().get("Location") + "\n" +
                "URL: " + response.url() + "\n" +
                "Status: " + response.statusCode() + " " + response.statusMessage() + "\n"
        );
    }

    public static void main(String[] args) throws IOException, ParseException {

        String date1 = "01.05.2020 22:43:00";

        Date SomeDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").parse(date1);

        Date nowDate = new Date();

        long milliseconds = SomeDate.getTime() - nowDate.getTime();

        float hours = (milliseconds / (60 * 60 * 1000));
        System.out.println("Разница между датами в часах: " + hours);

        System.out.println(SomeDate + "\n" + nowDate);

        //ef8122a0-1333-4776-9814-efe1aeed8f28|18.05.2020 20:47:37
        String s = "736ca040-72da-485a-914b-ebef1194d099|18.05.2020 20:47:59";

        System.out.println(s.substring(37,56));


        ///System.exit(0);

        String login = "kitsekaterina"; //"08012002@mail.ru";

        String password = "k12345"; //"1282565121024QWEasdfZXC";

        String loginURL = "https://login.dnevnik.ru/";

        String dnevnikURL = "https://dnevnik.ru/";

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

        ShowDetailsOf(LoginCookiesResponse);

        Connection.Response MarksResponse = null;

        try {
            MarksResponse = Jsoup.connect("https://schools.dnevnik.ru/marks.aspx?school=19267&index=10&tab=period%period=4")
                    .referrer(dnevnikURL)
                    .cookies(LoginCookiesResponse.cookies())
                    //.followRedirects(false)
                    .execute();
        }catch (Exception e){
            e.printStackTrace();
        }

        ShowDetailsOf(MarksResponse);

        Document doc = MarksResponse.charset("utf-8").parse();

        System.out.println(doc.title());

        //System.out.println(doc.select("#content").select("h2").text());

        System.out.println(doc.select(".crumbs").select("li").first().select("a").text());

        System.out.println(doc.select(".player").select("h3").text());

        Element DocBody = doc.select("div#content").first();


        //System.out.println(DocBody);

    }
}
