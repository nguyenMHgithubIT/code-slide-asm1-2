public class MemoryStackDemo {
    private int maxSize;
    private int[] stackArray;
    private int top;

    public MemoryStackDemo(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;  // Start with an empty stack
    }

    // 2.2: Push Operation - Adds an item (stack frame) to the stack
    public void push(int value) {
        if (top < maxSize - 1) {
            stackArray[++top] = value;
            System.out.println("Pushed value: " + value);
        } else {
            System.out.println("Stack is full, cannot push " + value);
        }
    }

    // 2.2: Pop Operation - Removes an item (stack frame) from the stack
    public int pop() {
        if (top >= 0) {
            int value = stackArray[top--];
            System.out.println("Popped value: " + value);
            return value;
        } else {
            System.out.println("Stack is empty, cannot pop");
            return -1;  // Returns -1 when stack is empty
        }
    }

    // 2.2: Peek Operation - Gets the top item without removing it
    public int peek() {
        if (top >= 0) {
            System.out.println("Top value: " + stackArray[top]);
            return stackArray[top];
        } else {
            System.out.println("Stack is empty, nothing to peek");
            return -1;
        }
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return (top == -1);
    }

    // Iterative method to calculate factorial using stack to simulate stack frames
    public void calculateFactorialIteratively(int n) {
        System.out.println("\nCalculating factorial of " + n + " iteratively:");

        // Push each number onto the stack to simulate calculation frames
        for (int i = 1; i <= n; i++) {
            push(i);
        }

        int result = 1;
        while (!isEmpty()) {
            result *= pop();  // Pop each frame and multiply for factorial result
        }

        System.out.println("Factorial calculated iteratively: " + result);
    }

    // Show current stack frames for visualization
    public void showStackFrames() {
        System.out.println("\nCurrent Stack Frames:");
        for (int i = top; i >= 0; i--) {
            System.out.println("Frame " + i + " - Value: " + stackArray[i]);
        }
    }

    // Method to demonstrate the stack frames with the factorial example
    public void demoStackFrame() {
        int n = 5;  // Change this value to test with other numbers
        calculateFactorialIteratively(n);
        System.out.println("\nFinal Stack State (should be empty if all frames are processed):");
        showStackFrames();
    }

    // Main method to execute the demo
    public static void main(String[] args) {
        MemoryStackDemo stackDemo = new MemoryStackDemo(10);  // Initialize stack with size 10
        stackDemo.demoStackFrame();
    }
}