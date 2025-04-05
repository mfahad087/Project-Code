import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InstructorPortal {
    private Instructor instructor;
    private CourseManager courseManager = new CourseManager();
    private Map<String, String> courseMaterials = new HashMap<>();
    private Map<String, Map<String, Integer>> studentProgress = new HashMap<>();

    public InstructorPortal(Instructor instructor) {
        this.instructor = instructor;
        // Initialize sample data
        courseMaterials.put("Java Programming", "Object-oriented programming basics...");
        
        Map<String, Integer> student1Grades = new HashMap<>();
        student1Grades.put("Java Quiz", 85);
        studentProgress.put("student1", student1Grades);
    }

    public void start(Scanner scanner) {
        while (true) {
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║      INSTRUCTOR DASHBOARD         ║");
            System.out.println("╠════════════════════════════════════╣");
            System.out.println("║ 1. ✏️ Edit Course Materials       ║");
            System.out.println("║ 2. ➕ Add New Material            ║");
            System.out.println("║ 3. 🎯 Create Quiz                ║");
            System.out.println("║ 4. 👥 View Students              ║");
            System.out.println("║ 5. 🚪 Logout                    ║");
            System.out.println("╚════════════════════════════════════╝");
            System.out.print("➡ Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    editCourseMaterials(scanner);
                    break;
                case 2:
                    addNewMaterial(scanner);
                    break;
                case 3:
                    createQuiz(scanner);
                    break;
                case 4:
                    viewStudentProgress();
                    break;
                case 5:
                    return;
                default:
                    UI.showError("Invalid choice!");
            }
        }
    }

    private void editCourseMaterials(Scanner scanner) {
        courseManager.listCourses();
        System.out.print("Enter course name to edit: ");
        String courseName = scanner.nextLine();
        
        if (courseMaterials.containsKey(courseName)) {
            System.out.println("Current material:");
            System.out.println(courseMaterials.get(courseName));
            System.out.print("Enter new material: ");
            String newMaterial = scanner.nextLine();
            courseMaterials.put(courseName, newMaterial);
            UI.showSuccess("Material updated!");
        } else {
            UI.showError("Course not found!");
        }
    }

    private void addNewMaterial(Scanner scanner) {
        courseManager.listCourses();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter material content: ");
        String material = scanner.nextLine();
        courseMaterials.put(courseName, material);
        UI.showSuccess("Material added!");
    }

    private void createQuiz(Scanner scanner) {
        courseManager.listCourses();
        System.out.print("For which course? ");
        String courseName = scanner.nextLine();
        System.out.print("Enter quiz name: ");
        String quizName = scanner.nextLine();
        
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         QUIZ CREATED! ✅          ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ Course: " + courseName + "           ║");
        System.out.println("║ Quiz: " + quizName + "               ║");
        System.out.println("╚════════════════════════════════════╝");
    }

    private void viewStudentProgress() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║          STUDENT PROGRESS         ║");
        System.out.println("╠════════════════════════════════════╣");
        
        studentProgress.forEach((student, grades) -> {
            System.out.println("║ Student: " + student + "               ║");
            grades.forEach((quiz, score) -> 
                System.out.println("║   " + quiz + ": " + score + "/100      ║"));
            System.out.println("╠════════════════════════════════════╣");
        });
        System.out.println("╚════════════════════════════════════╝");
    }
}
