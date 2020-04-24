package sample.Administrator;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import sample.Bruker.Bruker;

import java.io.*;
import java.util.List;

import static sample.Bruker.Bruker.opprettedeBrukere;
import static sample.BytteAvScener.lastInnStage;

public class AdministratorController {

    public void btnListeBrukere(ActionEvent actionEvent) throws IOException {
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

    public void btnSerOrdre(ActionEvent actionEvent) {
    }

    public void btnTilbake(ActionEvent actionEvent) {
        lastInnStage(actionEvent, "/sample/sample.fxml");

    }
}
