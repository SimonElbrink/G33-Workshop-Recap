package se.lexicon.model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StudentTest {

    private Student testObject;

    @Before
    public void setUp() {
        String[] courses = new String[]{"Java", "C#"};
        testObject = new Student("Mehrdad", "Javan", 32, "Male", courses);
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



    /*

    @Test
    public void test_equal(){
        AppUser isEqual =  new AppUser(1, "Mehrdad", "Javan", "mehrdad.javan@lexicon.se");
        assertTrue(testObject.equals(isEqual));
    }

    @Test
    public void test_hashCode(){
        AppUser  expected_obj =  new AppUser(1, "Mehrdad", "Javan", "mehrdad.javan@lexicon.se");
        assertEquals(expected_obj.hashCode(),testObject.hashCode());
    }

    @Test
    public void test_toString(){
        String toString = testObject.toString();
        assertTrue(toString.contains("1"));
        assertTrue(toString.contains("Mehrdad"));
        assertTrue(toString.contains("Javan"));
        assertTrue(toString.contains("mehrdad.javan@lexicon.se"));
    }

    */


}
