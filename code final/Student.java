class Student {
    private int id;
    private String name;
    private double marks; // Assuming marks is a double for more precision
    private String rank;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.rank = calculateRank(marks); // Tính rank ngay khi tạo đối tượng
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public String getRank() {
        return rank;
    }

    // Tính rank dựa vào điểm
    private static String calculateRank(double marks) {
        if (marks < 5.0) return "Fail";
        if (marks < 6.5) return "Medium";
        if (marks < 7.5) return "Good";
        if (marks < 9.0) return "Very Good";
        return "Excellent";
    }

    // Override phương thức toString để hiển thị thông tin sinh viên
    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", rank='" + rank + '\'' +
                '}';
    }
}
