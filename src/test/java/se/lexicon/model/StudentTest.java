package se.lexicon.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    private Student testObject;

    @Before
    public void setUp() {
        String[] courses = new String[]{"Java", "C#"};
        Address address = new Address("Campus 1", "123 45", "Växjö");
        testObject = new Student("Mehrdad", "Javan", 32, Gender.MALE, courses, address);
    }

    @After
    public void tearDown(){
        StudentSequencer.reset();
    }

    @Test
    public void test_successfully_created() {
        assertEquals(1, testObject.getStudentId());
        assertEquals("Mehrdad", testObject.getFirstName());
        assertEquals("Javan", testObject.getLastName());
        assertEquals(2, testObject.getCourse().length);
    }

    @Test
    public void test_equal_firstName() {
        assertEquals("Mehrdad", testObject.getFirstName());
    }

    @Test
    public void Test_compareTo_notGreater() {

        //Arrange
        Student toCompare = new Student(10, "", "", 0, null, null, new Address("Campus 1", "123 45", "Växjö"));
        int expected = -1;
        int actual;

        //Act
        actual = testObject.compareTo(toCompare);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void Test_compareTo_When_Same() {

        //Arrange
        Student toCompare = new Student(1, "", "", 0, null, null, new Address("Campus 1", "123 45", "Växjö"));
        int expected = 0;
        int actual;

        //Act
        actual = testObject.compareTo(toCompare);

        //Assert
        assertEquals(expected, actual);
    }

    @Test
    public void Test_compareTo_When_Greater() {

        //Arrange
        Student toCompare = new Student(0, "", "", 0, null, null, new Address("Campus 1", "123 45", "Växjö"));
        int expected = 1;
        int actual;

        //Act
        actual = testObject.compareTo(toCompare);

        //Assert
        assertEquals(expected, actual);
    }
}
