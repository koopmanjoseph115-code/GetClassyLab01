import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator01
{
    public static void main(String[] args)
    {
        ArrayList<Person> folks = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\personData.csv");

        boolean done = false;
        /*
         a. ID (a String)
         b.	FirstName
         c.	LastName
         d.	Title (a string like Mr., Mrs., Ms., Dr., etc.)
         e.	YearOfBirth (an int)
        */
        String ID = "";
        String firstname = "";
        String lastname = "";
        String title = "";
        int YOB = 0;

        do {
            SafeInputObj inputObj = new SafeInputObj(in);
            ID = inputObj.getNonZeroLenString("Enter the ID [6 digits]: ");
            firstname = inputObj.getNonZeroLenString("Enter the first name: ");
            lastname = inputObj.getNonZeroLenString("Enter the last name: ");
            title = inputObj.getNonZeroLenString("Enter the title: ");
            YOB = inputObj.getRangedInt("Enter the year of birth: ", 1940,2010);

            Person person = new Person(ID, firstname, lastname, title, YOB);
            folks.add(person);


            done = inputObj.getYNConfirm("Are you done?" );

        }while(!done);


        for( Person p: folks)
            System.out.println(p.toString());


        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Person person: folks)
            {
                writer.write(person.toCSVRecord(), 0, person.toCSVRecord().length());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }



    }
}
