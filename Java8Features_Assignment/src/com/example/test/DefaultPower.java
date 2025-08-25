package com.example.test;
//Define an interface with one abstract and one default method
interface Greeting {
// Abstract method (must be implemented)
 void sayHello(String name);

// Default method (has a body)
 default void sayWelcome() {
    System.out.println("Welcome to the Java interface demo!");
 }
}


public class DefaultPower implements Greeting {
	 // Implement the abstract method
	 public void sayHello(String name) {
	     System.out.println("Hello, " + name + "!");
	 }

	 public static void main(String[] args) {
		 DefaultPower demo = new DefaultPower();

	     // Call both methods
	     demo.sayHello("Alice");
	     demo.sayWelcome();
	 }
	
	

}
