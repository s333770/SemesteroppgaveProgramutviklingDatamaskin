package sample.LoggInn;

import javafx.collections.FXCollections;
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

public class LoggInnController implements Serializable {



    public void loggInn(ActionEvent actionEvent) throws IOException {
        FileInputStream fis=new FileInputStream("bruker.ser");
        ObjectInputStream ois=new ObjectInputStream(fis);
        try{
           opprettedeBrukere= FXCollections.observableList((List<Bruker>)ois.readObject());
            System.out.println(opprettedeBrukere.toString());

        }
        catch(EOFException e){
            System.out.println(e);
        }
        catch(ClassNotFoundException e){
            System.out.println("Class is not found");
        }








    }

    public void tilbake(ActionEvent actionEvent) {
        lastInnStage(actionEvent, "/sample/sample.fxml");




    }
}
