// IT-2660 - Lab 1
// Student Name: Brandon Williams

public class Main {
    public static void main(String[] args) {
        System.out.println("hello, world!");

        // Create an instance of Lab1
        Lab1 lab = new Lab1();

        // Call increment method
        System.out.println("Increment 1: " + lab.increment(1));

        // Create the array
        int[] numbers = {5, 9, 3, 12, 7, 3, 11, 5};

        // Output the array in order using a while loop
        System.out.println("Array in order:");
        lab.printArrayForward(numbers);

        // Output the array in reverse using a for loop
        System.out.println("Array in reverse:");
        lab.printArrayReverse(numbers);

        // Output the first and last values of the array
        System.out.println("First and last values:");
        lab.printFirstAndLast(numbers);
    }
}

// Lab1 class with all required methods
class Lab1 {
    // Method to increment a number
    public int increment(int num) {
        return ++num;
    }

    // Method to print array in order using while loop
    public void printArrayForward(int[] arr) {
        int index = 0;
        while (index < arr.length) {
            System.out.println(arr[index]);
            index++;
        }
    }

    // Method to print array in reverse using for loop
    public void printArrayReverse(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    // Method to print first and last values of array
    public void printFirstAndLast(int[] arr) {
        if (arr.length > 0) {
            System.out.println("First: " + arr[0]);
            System.out.println("Last: " + arr[arr.length - 1]);
        }
    }
}
