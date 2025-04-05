import java.util.HashMap;
import java.util.Map;

public class Student extends User {
    private Map<String, Integer> grades = new HashMap<>();
    
    public Student(String username, String password) {
        super(username, password);
    }
    
    public String getRole() { return "Student"; }
    
    public void addGrade(String quizName, int score) {
        grades.put(quizName, score);
    }
    
    public void viewGrades() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║            YOUR GRADES            ║");
        System.out.println("╠════════════════════════════════════╣");
        grades.forEach((quiz, score) -> 
            System.out.println("║ " + quiz + ": " + score + "/100       ║"));
        System.out.println("╚════════════════════════════════════╝");
    }
}
