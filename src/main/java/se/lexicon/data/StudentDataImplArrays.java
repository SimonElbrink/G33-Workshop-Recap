package se.lexicon.data;

import se.lexicon.model.Student;

import java.util.Arrays;

public class StudentDataImplArrays implements StudentData {


    private Student[] students;

    public StudentDataImplArrays() {
        students = new Student[0];
    }

    @Override
    public Student addStudent(Student student) {
        if (nameExists(student.getFirstName())) {
            return null;
        }
        Student[] newArray = Arrays.copyOf(students, students.length + 1);
        newArray[newArray.length - 1] = student;
        students = newArray;
        return student;
    }

    @Override
    public Student[] getAllStudents() {
        return Arrays.copyOf(students, students.length);
    }

    @Override
    public Student findById(int studentId) {
        Student found = null;
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                found = student;
                break;
            }
        }
        return found;
    }

    @Override
    public Student findByName(String studentName) {
        Student found = null;
        for (Student student : students) {
            if (student.getFirstName().equalsIgnoreCase(studentName)) {
                found = student;
                break;
            }
        }
        return found;
    }

    private boolean nameExists(final String name) {
        boolean exists = false;
        for (Student student : students) {
            if (student.getFirstName().equalsIgnoreCase(name)) {
                exists = true;
                break;
            }
        }
        return exists;
    }

    @Override
    public Student update(Student updatedStudent) {
        Student toUpdate = findById(updatedStudent.getStudentId());
        if (toUpdate == null) {
            return null;
        }
        toUpdate.setFirstName(updatedStudent.getFirstName());
        toUpdate.setLastName(updatedStudent.getLastName());
        toUpdate.setAge(updatedStudent.getAge());
        toUpdate.setCourse(updatedStudent.getCourse());
        toUpdate.setGender(updatedStudent.getGender());
        toUpdate.setAddress(updatedStudent.getAddress());
        boolean isDelete = delete(toUpdate.getStudentId());
        if (isDelete) {
            addStudent(toUpdate);
        }
        return toUpdate;
    }

    @Override
    public boolean delete(int studentId) {
        int index = -1;
        for (int i = 0; i < students.length; i++) {
            if (students[i].getStudentId() == studentId) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return false;
        }

        Student[] newArray = new Student[students.length - 1];
        for (int i = 0, k = 0; i < students.length; i++) {
            if (i == index) {
                continue;
            }
            newArray[k++] = students[i];
        }
        students = newArray;
        return true;
    }


    @Override
    public int size() {
        return this.students.length;
    }

    @Override
    public void clear() {
        students = new Student[0];
    }



}
