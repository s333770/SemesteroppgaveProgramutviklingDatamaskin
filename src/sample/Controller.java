package sample;

import javafx.event.ActionEvent;
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
        lastInnStage(actionEvent, "/sample/Administrator/administrator.fxml");
    }

    public void loggInn(ActionEvent actionEvent) {
        lastInnStage(actionEvent, "/sample/LoggInn/loggInn.fxml");

    }


    //lastInnStage(actionEvent, "/sample/OpprettBruker/opprettBruker.fxml");

}
