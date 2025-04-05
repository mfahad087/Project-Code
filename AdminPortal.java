import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminPortal {
    private Admin admin;
    private CourseManager courseManager = new CourseManager();
    private List<String> systemUsers = new ArrayList<>();
    private List<String> blockedUsers = new ArrayList<>();
    
    public AdminPortal(Admin admin) {
        this.admin = admin;
        systemUsers.add("admin");
        systemUsers.add("instructor1");
        systemUsers.add("student1");
    }

    public void start(Scanner scanner) {
        while (true) {
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║         ADMIN DASHBOARD          ║");
            System.out.println("╠════════════════════════════════════╣");
            System.out.println("║ 1. ➕ Add Course                  ║");
            System.out.println("║ 2. ❌ Delete Course               ║");
            System.out.println("║ 3. 👤 Add User                   ║");
            System.out.println("║ 4. 🚫 Block User                 ║");
            System.out.println("║ 5. 🖥️ Server Monitor            ║");
            System.out.println("║ 6. 🚪 Logout                     ║");
            System.out.println("╚════════════════════════════════════╝");
            System.out.print("➡ Choose option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    addCourse(scanner);
                    break;
                case 2:
                    deleteCourse(scanner);
                    break;
                case 3:
                    addUser(scanner);
                    break;
                case 4:
                    blockUser(scanner);
                    break;
                case 5:
                    viewServerStatus();
                    break;
                case 6:
                    return;
                default:
                    UI.showError("Invalid choice!");
            }
        }
    }

    private void addCourse(Scanner scanner) {
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        courseManager.addCourse(courseName);
        UI.showSuccess("Course added!");
    }

    private void deleteCourse(Scanner scanner) {
        courseManager.listCourses();
        System.out.print("Enter course to delete: ");
        String courseName = scanner.nextLine();
        
        if (courseManager.removeCourse(courseName)) {
            UI.showSuccess("Course deleted!");
        } else {
            UI.showError("Course not found!");
        }
    }

    private void addUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        systemUsers.add(username);
        UI.showSuccess("User added!");
    }

    private void blockUser(Scanner scanner) {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║           USER LIST               ║");
        System.out.println("╠════════════════════════════════════╣");
        systemUsers.forEach(user -> 
            System.out.println("║ " + user + 
                (blockedUsers.contains(user) ? " (BLOCKED)" : "") + " ║"));
        System.out.println("╚════════════════════════════════════╝");
        
        System.out.print("Enter username to block/unblock: ");
        String username = scanner.nextLine();
        
        if (systemUsers.contains(username)) {
            if (blockedUsers.contains(username)) {
                blockedUsers.remove(username);
                UI.showSuccess("User unblocked!");
            } else {
                blockedUsers.add(username);
                UI.showSuccess("User blocked!");
            }
        } else {
            UI.showError("User not found!");
        }
    }

    private void viewServerStatus() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         SERVER STATUS            ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ CPU Usage: 23%                   ║");
        System.out.println("║ Memory: 4.2GB/8GB                ║");
        System.out.println("║ Active Users: " + systemUsers.size() + "                 ║");
        System.out.println("║ Blocked Users: " + blockedUsers.size() + "                ║");
        System.out.println("╚════════════════════════════════════╝");
    }
}
