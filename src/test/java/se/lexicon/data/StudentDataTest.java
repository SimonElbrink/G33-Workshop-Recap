package se.lexicon.data;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.lexicon.model.Address;
import se.lexicon.model.Gender;
import se.lexicon.model.Student;
import se.lexicon.model.StudentSequencer;

public class StudentDataTest {

    private StudentData studentDataTest;
    private Student student;

    @Before
    public void setup() {
        studentDataTest = new StudentDataImplArrays();
        String[] courses = new String[]{"Java", "C#"};
        Address address = new Address("Campus 1", "123 45", "Växjö");
        student = new Student("Mehrdad", "Javan", 32, Gender.MALE, courses, address);
    }

    @After
    public void tearDown(){
        StudentSequencer.reset();
    }

    @Test
    public void test_addStudent_length_successfullyAdded() {
        Student addStudentResult = studentDataTest.addStudent(student);
        System.out.println(addStudentResult.showInformation());
        int expectedLength = 1;
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
        Student addedObject = studentDataTest.addStudent(new Student("Test", "Testsson", 32, Gender.MALE, new String[]{"Java", "Python"}, new Address("TestStreet 1", "987 65", "TestCity")));
        StudentData.printStudentInformation(addedObject);

        Student result = studentDataTest.findByName(addedObject.getFirstName());
        String expectedResult = "Test";
        String actualResult = result.getFirstName();
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void test_getAllStudent() {
        Student addedObject1 = studentDataTest.addStudent(student);
        Student addedObject2 = studentDataTest.addStudent(new Student("Test", "Testsson", 32, Gender.MALE, new String[]{"Java", "Python"}, new Address("TestStreet 1", "987 65", "TestCity")));

        Student[] result = studentDataTest.getAllStudents();
        int expectedResult = 2;
        int actualResult = result.length;
        Assert.assertEquals(expectedResult,actualResult);
    }



}
