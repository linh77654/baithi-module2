package utils;

import models.Student;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ValidationUtils {

    public static boolean validateStudent(Student student, String studentFilePath) {
        if (student.getName().length() < 4 || student.getName().length() > 50) {
            System.out.println("Name must be between 4 and 50 characters.");
            return false;
        }

        if (!isValidDate(student.getDateOfBirth())) {
            System.out.println("Invalid date format. Use dd/MM/yyyy.");
            return false;
        }

        if (!isValidPhoneNumber(student.getPhoneNumber())) {
            System.out.println("Invalid phone number. It should start with 090 or 091 and be 10 digits long.");
            return false;
        }

        if (isDuplicatePhoneNumber(student.getPhoneNumber(), studentFilePath)) {
            System.out.println("Phone number already exists.");
            return false;
        }

        return true;
    }

    private static boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            sdf.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("^(090|091)\\d{7}$");
    }

    private static boolean isDuplicatePhoneNumber(String phoneNumber, String studentFilePath) {
        List<Student> students = CSVUtils.readStudentsFromCSV(studentFilePath);
        for (Student student : students) {
            if (student.getPhoneNumber().equals(phoneNumber)) {
                return true;
            }
        }
        return false;
    }
}
