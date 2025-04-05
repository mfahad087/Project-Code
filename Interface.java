public class UI {
    public static void displayMainMenu() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║    🎓 E-LEARNING PLATFORM 🎓     ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ 1. 🔐 Authentication              ║");
        System.out.println("║ 2. 🎓 Student Portal              ║");
        System.out.println("║ 3. 👨‍🏫 Instructor Portal          ║");
        System.out.println("║ 4. 👨‍💼 Admin Portal               ║");
        System.out.println("║ 5. 🚪 Exit                        ║");
        System.out.println("╚════════════════════════════════════╝");
        System.out.print("➡ Choose option: ");
    }

    public static void showError(String message) {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║          ERROR! ❌                 ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ " + padRight(message, 34) + " ║");
        System.out.println("╚════════════════════════════════════╝");
    }

    public static void showSuccess(String message) {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         SUCCESS! ✅                ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║ " + padRight(message, 34) + " ║");
        System.out.println("╚════════════════════════════════════╝");
    }

    private static String padRight(String s, int n) {
        return String.format("%-" + n + "s", s);
    }
}
