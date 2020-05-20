package bg.sofia.uni.fmi.cleancode.studentmanagement.io;

import java.util.Scanner;

public class AppIO {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }
    
    private AppIO() {
    }

    public static Scanner getSystemScanner() {
        return scanner;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
