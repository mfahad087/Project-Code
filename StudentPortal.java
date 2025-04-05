import java.util.Scanner;

public class StudentPortal {
    private Student student;
    private CourseManager courseManager = new CourseManager();
    
    public StudentPortal(Student student) {
        this.student = student;
    }

    public void start(Scanner scanner) {
        while (true) {
            UI.displayStudentMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    courseManager.listCourses();
                    break;
                case 2:
                    takeQuiz(scanner);
                    break;
                case 3:
                    student.viewGrades();
                    break;
                case 4:
                    return;
                default:
                    UI.showError("Invalid choice!");
            }
        }
    }

    private void takeQuiz(Scanner scanner) {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║           QUIZ TIME!              ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ What is 2+2?                      ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ 1. 3                              ║");
        System.out.println("║ 2. 4                              ║");
        System.out.println("║ 3. 5                              ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.print("➡ Your answer: ");
        
        int answer = scanner.nextInt();
        int score = (answer == 2) ? 100 : 0;
        student.addGrade("Math Quiz", score);
        UI.showSuccess("Quiz completed! Score: " + score + "/100");
    }
}
