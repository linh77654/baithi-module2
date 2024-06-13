package services;

import exceptions.NotFoundStudentException;
import models.Student;
import utils.CSVUtils;
import utils.ValidationUtils;

import java.io.FileNotFoundException;
import java.util.List;

public class StudentService {
    private static final String STUDENT_FILE_PATH = "data/students.csv";

    public void addStudent(Student student) {
        if (!ValidationUtils.validateStudent(student, STUDENT_FILE_PATH)) {
            System.out.println("Invalid student data.");
            return;
        }

        CSVUtils.appendToCSV(STUDENT_FILE_PATH, student.toString());
    }

    public void deleteStudent(int studentId) throws NotFoundStudentException {
        List<Student> students = null;
        try {
            students = getAllStudents();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        boolean found = false;
        for (Student student : students) {
            if (student.getId() == studentId) {
                students.remove(student);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new NotFoundStudentException("Student not found with ID: " + studentId);
        }
    }

    public List<Student> getAllStudents() throws FileNotFoundException {
        return CSVUtils.readStudentsFromCSV(STUDENT_FILE_PATH);
    }

    public List<Student> searchStudents(String keyword) {
        return null;
    }
}
