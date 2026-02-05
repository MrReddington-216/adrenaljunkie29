// IT-2660 - Lab 2
// Student Name: Brandon Williams

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class App { // Use your class name "App"
    public static void main(String[] args) {
        System.out.println("Hello, World!"); // Your original message

        // ===============================
        // LinkedList Example
        // ===============================
        System.out.println("\n--- LinkedList Example ---");

        LinkedList<String> progLanguages = new LinkedList<>();
        progLanguages.add("Java");
        progLanguages.add("Python");
        progLanguages.add("JavaScript");
        progLanguages.add("C++");

        progLanguages.remove("C++");
        progLanguages.add(2, "HTML");

        System.out.println("Programming Languages:");
        Iterator<String> iterator = progLanguages.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // ===============================
        // Queue Example
        // ===============================
        System.out.println("\n--- Queue Example ---");

        Queue<String> q = new LinkedList<>();
        q.add("Alice");
        q.add("Bob");
        q.add("Charlie");
        q.add("Diana");
        q.add("Ethan");

        System.out.println("Elements of queue: " + q);

        String removedElement = q.remove();
        System.out.println("Removed element: " + removedElement);

        System.out.println("Head of queue: " + q.peek());

        System.out.println("Remaining elements in queue:");
        for (String element : q) {
            System.out.println(element);
        }

        // ===============================
        // Stack Example
        // ===============================
        System.out.println("\n--- Stack Example ---");

        Stack<String> bookStack = new Stack<>();
        bookStack.push("Clean Code");
        bookStack.push("Design Patterns");
        bookStack.push("Pragmatic Programmer");

        String poppedBook = bookStack.pop();
        System.out.println("Popped book: " + poppedBook);

        System.out.println("Top book: " + bookStack.peek());

        bookStack.push("Web DB Technologies");
        System.out.println("Top book after push: " + bookStack.peek());

        int position = bookStack.search("Design Patterns");
        if (position != -1) {
            System.out.println("\"Design Patterns\" found at position: " + position);
        } else {
            System.out.println("\"Design Patterns\" not found in stack.");
        }

        System.out.println("Is stack empty? " + bookStack.empty());

        System.out.println("Books on stack:");
        for (String book : bookStack) {
            System.out.println(book);
        }
    }
}
