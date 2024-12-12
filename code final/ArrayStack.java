import java.util.EmptyStackException;
import java.util.Random;
import java.util.Scanner;

class ArrayStack {
    private int maxSize;
    private Student[] stackArray;
    private int top;

    public ArrayStack(int size) {
        this.maxSize = size;
        this.stackArray = new Student[maxSize];
        this.top = -1;
    }

    public void push(Student student) {
        if (top == maxSize - 1) {
            throw new RuntimeException("Stack is full. Cannot add more students.");
        }
        stackArray[++top] = student;
    }

    public Student pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stackArray[top--];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public Student[] toArray() {
        Student[] array = new Student[top + 1];
        System.arraycopy(stackArray, 0, array, 0, top + 1);
        return stackArray.clone();
    }

    public void updateFromArray(Student[] array) {
        for (int i = 0; i < array.length; i++) {
            stackArray[i] = array[i];
        }
        top = array.length - 1;
    }

    public void displayStack() {
        for (int i = 0; i <= top; i++) {
            System.out.println(stackArray[i]);
        }
    }
}

 class SortingAlgorithmComparison {
    public static void bubbleSort(Student[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].getMarks() < array[j + 1].getMarks()) {
                    Student temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Student[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(Student[] array, int low, int high) {
        double pivot = array[high].getMarks();
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (array[j].getMarks() >= pivot) {
                i++;
                Student temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        Student temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        ArrayStack stack = new ArrayStack(numStudents);
        Random random = new Random();

        // Add random students to the stack
        for (int i = 0; i < numStudents; i++) {
            double marks = random.nextDouble() * 10; // Random marks between 0 and 10
            String name = "Student " + (i + 1);
            stack.push(new Student(i + 1, name, marks));
        }

        System.out.println("\nOriginal stack of students:");
        stack.displayStack();

        // Bubble Sort
        Student[] bubbleArray = stack.toArray();
        long bubbleStartTime = System.nanoTime();
        bubbleSort(bubbleArray);
        long bubbleEndTime = System.nanoTime();
        stack.updateFromArray(bubbleArray); // Update stack with sorted array
        System.out.println("\nStudents sorted by Bubble Sort:");
//        stack.displayStack();
        System.out.println("Bubble Sort completed in " + (bubbleEndTime - bubbleStartTime) + " nanoseconds.");

        // Quick Sort
        stack.updateFromArray(stack.toArray()); // Reset stack to original
        Student[] quickArray = stack.toArray();
        long quickStartTime = System.nanoTime();
        quickSort(quickArray, 0, quickArray.length - 1);
        long quickEndTime = System.nanoTime();
        stack.updateFromArray(quickArray); // Update stack with sorted array
        System.out.println("\nStudents sorted by Quick Sort:");
//        stack.displayStack();
        System.out.println("Quick Sort completed in " + (quickEndTime - quickStartTime) + " nanoseconds.");
    }
}
