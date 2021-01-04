package se.lexicon.data;

import se.lexicon.model.Student;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class StudentDataImplCollection implements StudentData {

    private Set<Student> studentStorage;

    public StudentDataImplCollection() {
        studentStorage = new TreeSet<>();
    }

    @Override
    public Student addStudent(Student student) {

        //Ternary Operator
        return studentStorage.add(student) ? student : null;
    }

    @Override
    public Student[] getAllStudents() {

       return Collections.unmodifiableSet(studentStorage).toArray(new Student[studentStorage.size()]);

    }

    @Override
    public Student findById(int studentId) {

        Student foundStudent = null;

        for (Student s : studentStorage){
            if (s.getStudentId() == studentId){
                foundStudent = s;
                break;
            }
        }

        return foundStudent;
    }

    @Override
    public Student findByName(String studentName) {
        return null;
    }

    @Override
    public Student update(Student updatedStudent) {
        return null;
    }

    @Override
    public boolean delete(int studentId) {
        return false;
    }

    @Override
    public int size() {
        return studentStorage.size();
    }

    @Override
    public void clear() {
        studentStorage = new TreeSet<>();

    }
}
