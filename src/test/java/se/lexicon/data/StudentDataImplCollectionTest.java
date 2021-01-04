package se.lexicon.data;

import org.junit.Before;
import org.junit.Test;
import se.lexicon.model.Address;
import se.lexicon.model.Gender;
import se.lexicon.model.Student;
import se.lexicon.model.StudentSequencer;

import static org.junit.Assert.*;

public class StudentDataImplCollectionTest {

    StudentDataImplCollection testObject;
    Student student;

    @Before
    public void setUp()  {

        StudentSequencer.reset();

        String[] courses = {"Java", "C#"};
        Address address = new Address("växjövägen 1", "123 45", "Växjö");
        student = new Student("Test", "Testsson", 50, Gender.FEMALE, courses, address);

        testObject = new StudentDataImplCollection();
    }


    @Test
    public void test_addStudent_should_addStudent_when_studentNotPresent(){

        //Arrange
        Student expected = student;
        Student actual = null;

        //Act
        actual = testObject.addStudent(student);

        //Assert
        assertNotNull(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void test_addStudent_should_NotReturnOrAddStudent_when_studentAlreadyAdded(){

        //Arrange
        Student actual = null;

        //Act
        testObject.addStudent(student);
        actual = testObject.addStudent(student);

        //Assert
        assertNull(actual);


    }

    @Test
    public void test_addStudent_should_NotIncreaseSize_when_studentAlreadyAdded(){

        //Arrange
        int expectedSize = 1;

        //Act
        testObject.addStudent(student);
        testObject.addStudent(student);

        //Assert
        assertEquals(expectedSize, testObject.size());

    }




}
