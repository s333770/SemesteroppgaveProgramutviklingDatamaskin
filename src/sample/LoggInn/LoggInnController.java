package sample.LoggInn;

import javafx.event.ActionEvent;
import org.w3c.dom.ls.LSOutput;
import sample.Bruker.Bruker;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static sample.Bruker.Bruker.brukereListe;
import static sample.Bruker.Bruker.opprettedeBrukere;
import static sample.BytteAvScener.lastInnStage;

public class LoggInnController {



    public void loggInn(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        FileInputStream fis=new FileInputStream("bruker.ser");
        ObjectInputStream ois=new ObjectInputStream(fis);
        try{
            String string1=(String)ois.readObject();
            String string2=(String)ois.readObject();
            String string3=(String)ois.readObject();
            String string4=(String)ois.readObject();
            String string5=(String)ois.readObject();
        }
        catch(EOFException e){
            System.out.println("ferdig");
        }
            fis.close();
            ois.close();







    }

    public void tilbake(ActionEvent actionEvent) {
        lastInnStage(actionEvent, "/sample/sample.fxml");




    }
}
