import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class Main3 {

    public static void main(String a[]){

        ArrayList<SubjectInfo> sub = new ArrayList<>();

        ArrayList<Mark> marks = new ArrayList<>();

        for(int i = 1; i < 6; i++) {
            for (int j = 0; j < 5; j++) {
                int mark = (int) Math.round(Math.random() * 5);
                marks.add(new Mark(mark, new Date(), j));
            }
            sub.add(new SubjectInfo("sub" + i, i, marks, -1, 0, 0,0));
            marks = new ArrayList<>();
        }

        System.out.println(sub.get(0).toString());
        System.out.println(sub.get(1).toString());
        System.out.println(sub.get(2).toString());

    }

}
