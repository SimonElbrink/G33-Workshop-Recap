// Hello

package se.lexicon.model;

import java.util.Arrays;

// Student = Child, Subclass
// Person = Parent, Super, Superclass
public class Student extends Person {

    //Fields
    private final int studentId;
    private String[] course;

    //Constructors
    public Student() {
        this.studentId = StudentSequencer.nextId();
    }


    public Student(String firstName, String lastName, int age, String gender, String[] course) {
        super(firstName, lastName, age, gender); // Calling matching constructor in Parent (Person)
        this.course = course;
        this.studentId = StudentSequencer.nextId();
    }

    //Custom Methods

    // Needs to be implemented, otherwise compile Error.
    @Override
    public String showInformation() {
        return "studentId: " + studentId + " courses: " +Arrays.toString(course);
    }

    // Convenience method = Helper. for Adding Courses
    public void addCourse(String courseName) {
        String[] newArr = Arrays.copyOf(course, course.length + 1);
        // add value to the latest index
        newArr[newArr.length -1] = courseName;
        course = newArr;
    }

    //Getters, Setters, Equals, hashCode, toString
    public int getStudentId() {
        return studentId;
    }

    public String[] getCourse() {
        return course;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }


}
