import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AuthManager authManager = new AuthManager();
        User currentUser = null;
        
        while (true) {
            UI.displayMainMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    currentUser = authManager.handleAuthentication(scanner);
                    break;
                case 2:
                    if (currentUser instanceof Student) {
                        new StudentPortal((Student)currentUser).start(scanner);
                    } else {
                        UI.showError("Please login as student first");
                    }
                    break;
                case 3:
                    if (currentUser instanceof Instructor) {
                        new InstructorPortal((Instructor)currentUser).start(scanner);
                    } else {
                        UI.showError("Please login as instructor first");
                    }
                    break;
                case 4:
                    if (currentUser instanceof Admin) {
                        new AdminPortal((Admin)currentUser).start(scanner);
                    } else {
                        UI.showError("Please login as admin first");
                    }
                    break;
                case 5:
                    UI.showExitMessage();
                    System.exit(0);
                default:
                    UI.showError("Invalid choice!");
            }
        }
    }
}
