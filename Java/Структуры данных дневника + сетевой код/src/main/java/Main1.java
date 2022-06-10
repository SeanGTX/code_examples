import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Main1 {

    public static void main(String[] a){

        Gson gson = new Gson();

        ArrayList<SubjectInfo> Performance = new ArrayList<>();

        for(int i = 1; i < 6; i++){

            ArrayList<Mark> marks = new ArrayList<>();

            for(int j = 1; j < 11; j++){
                String mark_value = "";
                int mark = (int)((Math.random() * 7) + 1);

                if (mark == 6) mark_value = "О";
                else if (mark == 7) mark_value = "Б";
                else mark_value = mark + "";

                marks.add(new Mark(mark_value, new Date(), i));
            }

            Performance.add(new SubjectInfo("Урок" + i, i, marks, 0, 0, 0, 0));

        }

        System.out.println(gson.toJson(Performance));

    }

}
