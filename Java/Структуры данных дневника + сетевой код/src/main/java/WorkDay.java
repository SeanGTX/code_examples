import java.util.ArrayList;

public class WorkDay {

    private ArrayList<Lesson> lessons = new ArrayList<>();

    public void addLesson(String lessonTitle, String teacherName, int numDay, String lessonStartTime, String lessonEndTime, String cabinet){
        lessons.add(new Lesson(lessonTitle, teacherName, numDay, lessonStartTime, lessonEndTime, cabinet));
    }

    public void addLesson(String lessonTitle, String teacherName, int numDay, String cabinet){
        lessons.add(new Lesson(lessonTitle, teacherName, numDay, cabinet));
    }

    public int getNumberOfLessons(){
        return lessons.size();
    }

    public void clearDay(){
        lessons.clear();
    }

    public Lesson getLesson(int numLesson){
        return lessons.get(numLesson);
    }

    @Override
    public String toString() {
        return "WorkDay{" + "\n" +
                "lessons=" + lessons.toString() +
                '}';
    }

}