import java.awt.*;

public class MousePosition {

    public static void main(String[] args) throws AWTException {

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        Point location = MouseInfo.getPointerInfo().getLocation();
        double x = location.getX();
        double y = location.getY();

        System.out.println((int)x + ", " + (int)y);

        Robot robot = new Robot();

        System.out.println(robot.getPixelColor(990, 347).equals(new Color(254, 217, 57)));

        System.out.print(robot.getPixelColor(990, 347));

    }
}
