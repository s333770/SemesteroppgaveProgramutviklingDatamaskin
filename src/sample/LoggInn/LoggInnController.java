package sample.LoggInn;

import javafx.event.ActionEvent;
import org.w3c.dom.ls.LSOutput;
import sample.Bruker.Bruker;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static sample.Bruker.Bruker.brukereListe;
import static sample.Bruker.Bruker.opprettedeBrukere;

public class LoggInnController {



    public void loggInn(ActionEvent actionEvent) throws IOException {
        FileInputStream fis=new FileInputStream("bruker.ser");
        ObjectInputStream ois=new ObjectInputStream(fis);
        try
        {
            while(true)
            {
                Bruker bruker = (Bruker)ois.readObject();
            }
        }
        catch(IOException e)
        {
            System.out.println("Serialisert begge objektene");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally
        {
            fis.close();    //<- Outside the while loop.
            ois.close();    //<- Outside the while loop.
        }





    }

    public void tilbake(ActionEvent actionEvent) {
        System.out.println(opprettedeBrukere.get(0));




    }
}
