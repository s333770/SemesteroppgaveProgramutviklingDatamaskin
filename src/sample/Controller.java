package sample;

import sample.Bruker.Bruker;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

import static sample.BytteAvScener.lastInnStage;

public class Controller {
    public void bruker(javafx.event.ActionEvent actionEvent) throws IOException {
        lastInnStage(actionEvent, "/sample/OpprettBruker/opprettBruker.fxml");
    }

    public void administrator(javafx.event.ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        System.out.println("hello");
        Bruker brukerList = null;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("bruker.txt"));
        brukerList= (Bruker) objectInputStream.readObject();
        System.out.println(brukerList.toString());
    }



        //lastInnStage(actionEvent, "/sample/OpprettBruker/opprettBruker.fxml");

}
