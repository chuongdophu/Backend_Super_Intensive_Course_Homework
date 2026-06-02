// Lưu file này với tên chính xác là: User.java
public class User {
    private String firstName;
    private String lastName;
    private String dob;
    private String username;
    private String password;
    private String status; // "Active" hoặc "Locked"

    // Constructor: Hàm khởi tạo đối tượng User
    public User(String firstName, String lastName, String dob, String username, String password, String status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    // Chuyển đối tượng thành dòng chữ ngăn cách bởi dấu | để chuẩn bị ghi vào file
    // txt
    @Override
    public String toString() {
        return firstName + "|" + lastName + "|" + dob + "|" + username + "|" + password + "|" + status;
    }

    // Hàm chuyển đổi ngược: Đọc một dòng chữ từ file txt lên rồi biến nó thành đối
    // tượng User
    public static User fromString(String line) {
        String[] parts = line.split("\\|");
        if (parts.length == 6) {
            return new User(parts[0], parts[1], parts[2], parts[3], parts[4], parts[5]);
        }
        return null; // Dòng lỗi hoặc không đủ dữ liệu
    }

    // Các hàm Getter và Setter để bảo vệ dữ liệu (Tính đóng gói trong OOP)
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Hàm tự hiển thị thông tin của chính User đó ra màn hình
    public void display() {
        System.out.println("Full Name: " + firstName + " " + lastName + " | DOB: " + dob + " | Username: " + username
                + " | Status: " + status);
    }
}