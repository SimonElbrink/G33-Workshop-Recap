package se.lexicon.data;

import se.lexicon.model.Student;

public interface StudentData {

    // define student functionalities
    // or CRUD operations CREATE - READ - UPDATE - DELETE

    Student addStudent(Student student);
    Student[] getAllStudents();
    Student findById(int studentId);
    Student findByName(String studentName);
    Student update(Student updatedStudent);
    boolean delete(int studentId);
    int size();
    void clear();

    static void printStudentInformation(Student student) {
        if (student != null) {
            System.out.println(student.getFirstName() + " " + student.getLastName());
        }else{
            System.out.println("Student is null");

        }
    }

}
