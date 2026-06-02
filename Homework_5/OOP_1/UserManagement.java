
// Lưu file này với tên chính xác là: UserManagement.java
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserManagement {
    private static final String FILE_NAME = "users.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- USER MANAGEMENT SYSTEM ---");
            System.out.println("1. Register");
            System.out.println("2. View Registered Users");
            System.out.println("3. Login");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Error: Please enter a number!");
                scanner.nextLine(); // Bỏ qua ký tự lỗi
                continue;
            }
            int option = scanner.nextInt();
            scanner.nextLine(); // Dọn dẹp dấu Enter rác trong bộ nhớ đệm

            if (option == 1) {
                handleRegister(scanner);
            } else if (option == 2) {
                handleViewUsers(scanner);
            } else if (option == 3) {
                handleLogin(scanner);
            } else if (option == 4) {
                System.out.println("System exited. Goodbye!");
                break;
            } else {
                System.out.println("Invalid option! Please choose from 1 to 4.");
            }
        }
        scanner.close();
    }

    // ==================== 1. XỬ LÝ ĐĂNG KÝ (GHI FILE) ====================
    private static void handleRegister(Scanner scanner) {
        System.out.println("\n--- REGISTER NEW USER ---");
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("DOB (dd/mm/yyyy): ");
        String dob = scanner.nextLine();
        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        // Tạo đối tượng User mới từ class User bên file User.java (Trạng thái mặc định:
        // Active)
        User newUser = new User(firstName, lastName, dob, username, password, "Active");

        // Ghi dòng text của đối tượng đó nối tiếp vào file users.txt (Append mode =
        // true)
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
                PrintWriter out = new PrintWriter(new BufferedWriter(fw))) {
            out.println(newUser.toString());
            System.out.println("Registration successful! Data saved.");
        } catch (IOException e) {
            System.out.println("File error: Cannot save user info.");
        }
    }

    // ==================== 2. XỬ LÝ XEM DANH SÁCH (ĐỌC FILE) ====================
    private static void handleViewUsers(Scanner scanner) {
        ArrayList<User> userList = loadUsersFromFile(); // Đọc hết text lên thành mảng các Object User
        if (userList.isEmpty()) {
            System.out.println("No users registered yet.");
            return;
        }

        System.out.println("\n--- VIEW REGISTERED USERS ---");
        System.out.println("1. Show all");
        System.out.println("2. Find by name");
        System.out.print("Choose sub-option: ");
        int subOption = scanner.nextInt();
        scanner.nextLine(); // Dọn dẹp dấu Enter

        if (subOption == 1) {
            System.out.println("\n--- ALL USERS LIST ---");
            for (User u : userList) {
                u.display(); // Gọi hàm hiển thị từ class User
            }
        } else if (subOption == 2) {
            System.out.print("Enter search character(s): ");
            String keyword = scanner.nextLine().toLowerCase();
            System.out.println("\n--- SEARCH RESULTS ---");
            boolean found = false;
            for (User u : userList) {
                // Kiểm tra xem FirstName HOẶC LastName có chứa ký tự tìm kiếm không
                if (u.getFirstName().toLowerCase().contains(keyword) ||
                        u.getLastName().toLowerCase().contains(keyword)) {
                    u.display();
                    found = true;
                }
            }
            if (!found)
                System.out.println("No users match the search keyword.");
        }
    }

    // ==================== 3. XỬ LÝ ĐĂNG NHẬP (SO SÁNH DATA) ====================
    private static void handleLogin(Scanner scanner) {
        ArrayList<User> userList = loadUsersFromFile(); // Đọc dữ liệu mới nhất từ file lên
        System.out.println("\n--- LOGIN SYSTEM ---");
        System.out.print("Username: ");
        String inputUser = scanner.nextLine();

        // Bước 1: Quét xem username nhập vào có tồn tại trong hệ thống không
        User targetUser = null;
        for (User u : userList) {
            if (u.getUsername().equals(inputUser)) {
                targetUser = u;
                break;
            }
        }

        // Bước 2: Nếu tìm thấy user, kiểm tra xem nó có bị khóa sẵn từ trước không
        if (targetUser != null && targetUser.getStatus().equals("Locked")) {
            System.out.println("Access Denied: This account is already LOCKED!");
            return;
        }

        // Bước 3: Cho thử mật khẩu tối đa 3 lần
        int attempts = 0;
        while (attempts < 3) {
            System.out.print("Password: ");
            String inputPass = scanner.nextLine();

            // Nếu user có tồn tại VÀ mật khẩu trùng khớp
            if (targetUser != null && targetUser.getPassword().equals(inputPass)) {
                System.out.println("Login success!");
                System.exit(0); // Kết thúc (finish) luồng chương trình theo yêu cầu đề bài
            } else {
                attempts++;
                System.out.println("Login failed! Remaining attempts: " + (3 - attempts));
            }
        }

        // Bước 4: Sau 3 lần thử thất bại -> Khóa tài khoản
        if (targetUser != null) {
            targetUser.setStatus("Locked"); // Đổi trạng thái đối tượng sang Locked
            saveAllUsersToFile(userList); // Ghi đè cập nhật lại trạng thái mới này vào file users.txt
            System.out.println("Your account has been officially LOCKED.");
        } else {
            System.out.println("Login session terminated. Username does not exist.");
        }
    }

    // ==================== HÀM BỔ TRỢ 1: ĐỌC TEXT RA THÀNH OBJECT LIST
    // ====================
    private static ArrayList<User> loadUsersFromFile() {
        ArrayList<User> list = new ArrayList<>();
        File file = new File(FILE_NAME);
        if (!file.exists())
            return list;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                User u = User.fromString(line); // Ép dòng chữ thành Object User
                if (u != null)
                    list.add(u);
            }
        } catch (IOException e) {
            System.out.println("Error reading database file.");
        }
        return list;
    }

    // ==================== HÀM BỔ TRỢ 2: GHI ĐÈ LẠI TOÀN BỘ FILE ĐỂ CẬP NHẬT TRẠNG
    // THÁI KHÓA ====================
    private static void saveAllUsersToFile(ArrayList<User> list) {
        // Tham số false ở FileWriter để thực hiện lệnh GHI ĐÈ (Overwrite) toàn bộ file
        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_NAME, false))) {
            for (User u : list) {
                out.println(u.toString());
            }
        } catch (IOException e) {
            System.out.println("Error updating database file.");
        }
    }
}