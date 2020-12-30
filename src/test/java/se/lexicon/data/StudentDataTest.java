package se.lexicon.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.model.Student;

public class StudentDataTest {

    private StudentData studentDataTest;
    private Student student;

    @Before
    public void setup() {
        studentDataTest = new StudentDataImpl();
        String[] courses = new String[]{"Java", "C#"};
        student = new Student("Mehrdad", "Javan", 32, "Male", courses);
    }

    @Test
    public void test_addStudent_length() {
        Student addStudentResult = studentDataTest.addStudent(student);
        System.out.println(addStudentResult.showInformation());
        int expectedLength = 0;
        int actualLength = studentDataTest.size();
        Assert.assertEquals(expectedLength,actualLength);
    }

    @Test
    public void test_findStudentById() {
        Student result = studentDataTest.addStudent(student);
        StudentData.printStudentInformation(result);

        Student actualResult = studentDataTest.findById(result.getStudentId());
        Assert.assertNotNull(actualResult);
    }

    @Test
    public void test_findStudentByName() {
        Student addedObject = studentDataTest.addStudent(new Student("Test", "Testsson", 32, "Male", new String[]{"Java", "Python"}));
        StudentData.printStudentInformation(addedObject);

        Student result = studentDataTest.findByName(addedObject.getFirstName());
        String expectedResult = "Test";
        String actualResult = result.getFirstName();
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void test_getAllStudent() {
        Student addedObject1 = studentDataTest.addStudent(student);
        Student addedObject2 = studentDataTest.addStudent(new Student("Test", "Testsson", 32, "Male", new String[]{"Java", "Python"}));

        Student[] result = studentDataTest.getAllStudents();
        int expectedResult = 2;
        int actualResult = result.length;
        Assert.assertEquals(expectedResult,actualResult);
    }



}
