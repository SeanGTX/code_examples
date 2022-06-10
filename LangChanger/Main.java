import java.awt.*;
import java.awt.im.*;
import java.awt.event.KeyEvent;

class Main{

    public static void main(String a[]) throws Exception{
        
        Robot robot = new Robot();

        InputContext context = InputContext.getInstance(); 
        String language = context.getLocale().getLanguage();
        if(language.equals("en")) return;
        
        robot.keyPress(KeyEvent.VK_WINDOWS);
        robot.keyPress(KeyEvent.VK_SPACE);

        Thread.sleep(500);

        robot.keyRelease(KeyEvent.VK_SPACE);
        robot.keyRelease(KeyEvent.VK_WINDOWS);
            
    }

}