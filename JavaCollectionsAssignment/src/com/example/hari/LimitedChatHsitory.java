package com.example.hari;

import java.util.ArrayDeque;
import java.util.Scanner;

public class LimitedChatHsitory {
	public static void main(String[] args) {
        ArrayDeque<String> chatBox = new ArrayDeque<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter chat messages (type 'exit' to quit):");

        while (true) {
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("exit")) break;

            if (chatBox.size() == 4) {
                chatBox.removeFirst(); // Drop oldest
            }

            chatBox.addLast(message);

            System.out.println("Last 4 messages:");
            for (String msg : chatBox) {
                System.out.println(msg);
            }
            System.out.println("-----");
        }

        System.out.println("Chat session ended.");
    }

}
