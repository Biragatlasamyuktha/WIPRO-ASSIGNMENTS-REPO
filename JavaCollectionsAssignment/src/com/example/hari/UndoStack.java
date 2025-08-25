package com.example.hari;

import java.util.Stack;

public class UndoStack {
	public static void main(String[] args) {
        Stack<String> commandStack = new Stack<>();

        // Step 1: Add 3 commands
        commandStack.push("Open");
        commandStack.push("Edit");
        commandStack.push("Save");

        System.out.println("Initial stack: " + commandStack);

        // Step 2: Undo (pop the last command)
        String undoneCommand = commandStack.pop();
        System.out.println("Undo: " + undoneCommand);

        // Step 3: Redo by re-adding the reversed command
        String reversedCommand = new StringBuilder(undoneCommand).reverse().toString();
        commandStack.push(reversedCommand);

        System.out.println("After redo (reversed): " + commandStack);
    }

}
