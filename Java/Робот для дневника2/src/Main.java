import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class Main{

    static void inputString(String s, Robot r){
        StringSelection stringSelection = new StringSelection(s);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(stringSelection, stringSelection);

        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_CONTROL);
    }

    static void getMainFile(String login, String password) throws AWTException{

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        
        Robot robot = new Robot();
        
        // перевод курсора на поле ввода логина
        robot.mouseMove(369, 377);

        // нажатие на поле ввода логина
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        // Ввод логина
        inputString(login, robot);

        robot.delay(100);

        // Перевод курсора на поле ввода пароля
        robot.mouseMove(369, 479);

        // Нажатие на поле ввода логина
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.delay(100);

        // Ввод пароля
        inputString(password, robot);

        // Перевод курсора на кнопку "Войти"
        robot.mouseMove(369, 557);
        while(robot.getPixelColor(369,557).equals(new Color(156, 205, 84))){}

        // Нажатие на кнопку "Войти"
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.delay(5000);

        // Переместиться на вкладку "Дневник"
        robot.mouseMove(553,213);

        // Нажатие на кнопку "Дневник"
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.delay(100);

        // Переместиться на вкладку "По семестрам"
        robot.mouseMove(663, 439);

        // Нажатие на кнопку "По семестрам"
        robot.delay(2000);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.delay(3000);

        // Вызов меню сохранения
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_S);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_S);

        // Переместиться на строку ввода пути
        robot.mouseMove(522 , 49);

        robot.delay(1000);

        // Клик по строке ввода пути
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        // Удаление содержимого строки ввода
        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);

        // Ввод пути
        inputString("E:/Projects/IntelliJProjects/JavaServer/src/HTMLs", robot);

        // Сделать поле ввода не активным
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        robot.mouseMove(764, 376);

        robot.delay(1000);

        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.keyPress(KeyEvent.VK_BACK_SPACE);
        robot.keyRelease(KeyEvent.VK_BACK_SPACE);

        robot.delay(1000);

        inputString("main.html", robot);


        // Переместиться на кнопку "Сохранить"
        robot.mouseMove(634, 442);

        robot.delay(1000);

        // Нажать на кнопку "Сохранить"
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

    }

    static void DnevnikLogin(String login, String password) throws AWTException {

        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        Robot robot = new Robot();

        // перевод курсора на поле ввода логина
        robot.mouseMove(369, 377);

        // нажатие на поле ввода логина
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        // Ввод логина
        inputString(login, robot);

        robot.delay(100);

        // Перевод курсора на поле ввода пароля
        robot.mouseMove(369, 479);

        // Нажатие на поле ввода логина
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.delay(100);

        // Ввод пароля
        inputString(password, robot);

        // Перевод курсора на кнопку "Войти"
        robot.mouseMove(369, 557);
        /*while(robot.getPixelColor(369,557).equals(new Color(156, 205, 84))){
            System.out.println("0");
        }*/

        // Нажатие на кнопку "Войти"
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);

        robot.delay(1000);

        if(robot.getPixelColor(990, 347).equals(new Color(254, 217, 57))){
            robot.mouseMove(1074, 136);
            robot.mousePress(InputEvent.BUTTON1_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_MASK);
            System.out.println("Неверный логин или пароль =((");
            return;
        }

        robot.delay(5000);
    }
    
    static void DnevnikLogout() throws AWTException{
        Robot robot = new Robot();
        robot.mouseMove(1226 , 139);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        robot.delay(5000);
    }

    public static void main(String[] arg) throws AWTException, IOException, InterruptedException {
        
        String login = "08012002@mail.ru";
        String password = "1282565121024QWEasdfZXC";

        DnevnikLogin(login, password);



        /*File main_html = new File("E:/Projects/IntelliJProjects/JavaServer/src/HTMLs/main.html");

        if (!main_html.exists()) getMainFile(login, password);
        else try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

        Document doc = Jsoup.parse(main_html, "UTF-8");
        System.out.print(doc.getElementById("journal"));*/


    }

}
