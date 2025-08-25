package com.example.hari;

import java.util.LinkedList;
import java.util.Scanner;

public class RecentAppMemory {
	public static void main(String[] args) {
        LinkedList<String> appList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Open 5 apps (one by one):");

        for (int i = 0; i < 5; i++) {
            String app = scanner.nextLine();

            // If already opened, remove it
            if (appList.contains(app)) {
                appList.remove(app);
            }

            // Add to the top (front of the list)
            appList.addFirst(app);
        }

        // Show final app list (most recent first)
        System.out.println("Final app list (most recent at top):");
        for (String app : appList) {
            System.out.println(app);
        }
    }

}
