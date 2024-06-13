package utils;

import models.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static void appendToCSV(String filePath, String data) {
        try (FileWriter fw = new FileWriter(filePath, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
            out.println(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Student> readStudentsFromCSV(String filePath) {
        List<Student> students = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Parse line to create Student object
                String[] values = line.split(",");
                // Assuming CSV structure: id,name,dateOfBirth,gender,phoneNumber,batchId
                Student student = new Student(
                        Integer.parseInt(values[0]),
                        values[1],
                        values[2],
                        values[3],
                        values[4],
                        Integer.parseInt(values[5])
                );
                students.add(student);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public static void writeStudentsToCSV(String studentFilePath, List<Student> students) {
    }

    public static void saveStudentsToCSV(String studentFilePath, List<Student> students) {
    }
}
