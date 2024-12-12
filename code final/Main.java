import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    private static ArrayStack studentStack;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Nhập số lượng sinh viên cần quản lý
        System.out.println("Enter the number of students in the class: ");
        int numberOfStudents = scanner.nextInt();
        studentStack = new ArrayStack(numberOfStudents);
        while (true) {
            // Menu chính
            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Search Student by ID");
            System.out.println("6. Sort Students by Marks (Bubble Sort)");
            System.out.println("7. Sort Students by Marks (Quick Sort)");
            System.out.println("8. Exit");
//           System.out.println("9. Generate Random Students");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Xóa bộ đệm

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    editStudent(scanner);
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    searchStudent(scanner);
                    break;
                case 6:
                    sortStudentsBubbleSort();
                    break;
                case 7:
                    sortStudentsQuickSort();
                    break;
                case 8:
                    System.out.println("Exiting program. Goodbye!");
                    return;
//                case 9:
//                    System.out.print("Enter the number of students to generate: ");
//                    int generateCount = scanner.nextInt();
//                    generateStudents(generateCount);
//                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

//    private static void generateStudents(int count) {
//        for (int i = 1; i <= count; i++) {
//            int id = i; // ID tăng dần
//            String name = "Student" + i; // Tên dạng Student1, Student2, ...
//            double marks = Math.random() * 100; // Điểm ngẫu nhiên từ 0 đến 100
//            Student student = new Student(id, name, marks);
//            studentStack.push(student);
//        }
//        System.out.println(count + " students have been generated and added to the stack.");
//    }


    // Thêm sinh viên vào stack
    private static void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ đệm
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        Student student = new Student(id, name, marks); // Thêm cả tên vào constructor
        studentStack.push(student);
        System.out.println("Student added successfully.");
    }
    // Sửa thông tin sinh viên
    private static void editStudent(Scanner scanner) {
        System.out.print("Enter the Student ID to edit: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Xóa bộ đệm
        ArrayList<Student> tempStack = new ArrayList<>();

        boolean found = false;
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            if (student.getId() == id) {
                found = true;
                System.out.print("Enter new Name: ");
                String newName = scanner.nextLine();
                System.out.print("Enter new Marks: ");
                double newMarks = scanner.nextDouble();
                student = new Student(id, newName, newMarks); // Cập nhật student
            }
            tempStack.add(student);
        }
        // Đẩy lại vào stack
        for (int i = tempStack.size() - 1; i >= 0; i--) {
            studentStack.push(tempStack.get(i));
        }

        if (found) {
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student ID not found.");
        }
    }
    // Xóa sinh viên
    private static void deleteStudent() {
        if (studentStack.isEmpty()) {
            System.out.println("Stack is empty. No student to delete.");
        } else {
            Student removedStudent = studentStack.pop();
            System.out.println("Removed: " + removedStudent);
        }
    }
    // Hiển thị tất cả sinh viên
    private static void displayAllStudents() {
        if (studentStack.isEmpty()) {
            System.out.println("No students in the stack.");
            return;
        }
        ArrayList<Student> tempStack = new ArrayList<>();
        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            tempStack.add(student);
            System.out.println(student); // Tự động hiển thị rank nhờ toString
        }
        // Đẩy lại vào stack
        for (int i = tempStack.size() - 1; i >= 0; i--) {
            studentStack.push(tempStack.get(i));
        }
    }
    // Tìm kiếm sinh viên theo ID
    private static void searchStudent(Scanner scanner) {
        System.out.print("Enter the Student ID to search: ");
        int id = scanner.nextInt();

        ArrayList<Student> tempStack = new ArrayList<>();
        boolean found = false;

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            tempStack.add(student);

            if (student.getId() == id) {
                System.out.println(student); // Hiển thị cả rank nhờ toString
                found = true;
            }
        }
        // Đẩy lại vào stack
        for (int i = tempStack.size() - 1; i >= 0; i--) {
            studentStack.push(tempStack.get(i));
        }
        if (!found) {
            System.out.println("Student not found.");
        }
    }
    // Bubble Sort với tính toán thời gian
    private static void sortStudentsBubbleSort() {
        ArrayList<Student> tempStack = new ArrayList<>();

        while (!studentStack.isEmpty()) {
            tempStack.add(studentStack.pop());
        }

        long startTime = System.nanoTime(); // Bắt đầu đếm thời gian

        // Bubble Sort
        for (int i = 0; i < tempStack.size() - 1; i++) {
            for (int j = 0; j < tempStack.size() - 1 - i; j++) {
                if (tempStack.get(j).getMarks() < tempStack.get(j + 1).getMarks()) {
                    // Hoán đổi
                    Student temp = tempStack.get(j);
                    tempStack.set(j, tempStack.get(j + 1));
                    tempStack.set(j + 1, temp);
                }
            }
        }
        long endTime = System.nanoTime(); // Kết thúc đếm thời gian
        long elapsedTime = endTime - startTime;

        // Đẩy lại vào stack
        for (int i = tempStack.size() - 1; i >= 0; i--) {
            studentStack.push(tempStack.get(i));
        }
        System.out.println("Students sorted by marks using Bubble Sort.");
        System.out.println("Time taken for Bubble Sort: " + elapsedTime + " nanoseconds.");
       // displayAllStudents();
    }
    // Quick Sort với tính toán thời gian
    private static void sortStudentsQuickSort() {
        ArrayList<Student> tempStack = new ArrayList<>();
        while (!studentStack.isEmpty()) {
            tempStack.add(studentStack.pop());
        }
        long startTime = System.nanoTime(); // Bắt đầu đếm thời gian
        quickSort(tempStack, 0, tempStack.size() - 1);
        long endTime = System.nanoTime(); // Kết thúc đếm thời gian
        long elapsedTime = endTime - startTime;
        // Đẩy lại vào stack
        for (int i = tempStack.size() - 1; i >= 0; i--) {
            studentStack.push(tempStack.get(i));
        }
        System.out.println("Students sorted by marks using Quick Sort.");
        System.out.println("Time taken for Quick Sort: " + elapsedTime + " nanoseconds.");
        displayAllStudents();
    }
    // Thuật toán Quick Sort
    private static void quickSort(ArrayList<Student> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }
    private static int partition(ArrayList<Student> list, int low, int high) {
        double pivot = list.get(high).getMarks();
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).getMarks() >= pivot) {
                i++;
                // Hoán đổi
                Student temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        // Hoán đổi phần tử chốt (pivot) với phần tử sau cùng của danh sách bên trái
        Student temp = list.get(i + 1);
        list.set(i + 1, list.get(high));
        list.set(high, temp);
        return i + 1;
    }
}


