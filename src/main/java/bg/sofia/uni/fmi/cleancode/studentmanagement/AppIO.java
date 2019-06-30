package bg.sofia.uni.fmi.cleancode.studentmanagement;

import java.util.Scanner;

public class AppIO {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static Scanner getSystemScanner() {
        return scanner;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
