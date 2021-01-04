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

      Student student1 = new Student(1,"S1", "", 23, Gender.MALE, null, null);

      Student student2 = new Student(1,"S1", "", 23, Gender.MALE, null, null);


        System.out.println("ToString:");
        System.out.println(student1);
        System.out.println(student2);

        System.out.println("Hashcode:");
        System.out.println(student1.hashCode());
        System.out.println(student2.hashCode());

        System.out.println("These are the same: " + student1.equals(student2));

    }
}
