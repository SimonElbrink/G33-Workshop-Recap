package se.lexicon;

import se.lexicon.model.Address;
import se.lexicon.model.Gender;
import se.lexicon.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

      Student student = new Student("Simon", "Elbrink", 23, Gender.MALE, null, new Address("växjövägen 1", "123 45", "Växjö"));




        System.out.println( "Hello World!" );
    }
}
