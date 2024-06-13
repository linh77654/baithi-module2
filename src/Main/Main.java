package Main;

import exceptions.NotFoundStudentException;
import models.Student;
import services.StudentService;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static StudentService studentService = new StudentService();

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Thêm mới sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Xem danh sách sinh viên");
            System.out.println("4. Tìm kiếm sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addNewStudent(scanner);
                    break;
                case 2:
                    deleteStudent(scanner);
                    break;
                case 3:
                    viewAllStudents();
                    break;
                case 4:
                    searchStudent(scanner);
                    break;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }
    }

    private static void addNewStudent(Scanner scanner) throws FileNotFoundException {
        System.out.print("Tên sinh viên: ");
        String name = scanner.nextLine();
        System.out.print("Ngày sinh (dd/MM/yyyy): ");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Giới tính: ");
        String gender = scanner.nextLine();
        System.out.print("Số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Mã lớp học: ");
        int batchId = scanner.nextInt();
        scanner.nextLine();

        int id = studentService.getAllStudents().size() + 1;
        Student student = new Student(id, name, dateOfBirth, gender, phoneNumber, batchId);
        studentService.addStudent(student);
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Nhập mã sinh viên để xóa: ");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        try {
            studentService.deleteStudent(studentId);
            System.out.println("Xóa sinh viên thành công.");
        } catch (NotFoundStudentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void viewAllStudents() throws FileNotFoundException {
        List<Student> students = studentService.getAllStudents();
        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void searchStudent(Scanner scanner) {
        System.out.print("Nhập tên sinh viên để tìm kiếm: ");
        String keyword = scanner.nextLine();
        List<Student> students = studentService.searchStudents(keyword);
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
