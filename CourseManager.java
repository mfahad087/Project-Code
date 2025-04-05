import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private List<String> courses = new ArrayList<>();
    
    public CourseManager() {
        courses.add("Java Programming");
        courses.add("Data Structures");
    }
    
    public void listCourses() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║        AVAILABLE COURSES         ║");
        System.out.println("╠════════════════════════════════════╣");
        courses.forEach(course -> 
            System.out.println("║ 📖 " + course + "               ║"));
        System.out.println("╚════════════════════════════════════╝");
    }
    
    public void addCourse(String courseName) {
        courses.add(courseName);
    }
    
    public boolean removeCourse(String courseName) {
        return courses.remove(courseName);
    }
}
