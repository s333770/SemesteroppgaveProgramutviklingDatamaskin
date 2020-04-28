package sample;

import javafx.event.ActionEvent;

import java.io.IOException;

import static sample.BytteAvScener.lastInnStage;

public class Controller {
    public void bruker(javafx.event.ActionEvent actionEvent) throws IOException {
        lastInnStage(actionEvent, "/sample/OpprettBruker/opprettBruker.fxml");
    }

    public void administrator(javafx.event.ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        lastInnStage(actionEvent, "/sample/AdministratorLoggInn/administrator.fxml");
    }

    public void loggInn(ActionEvent actionEvent) {
        lastInnStage(actionEvent, "/sample/LoggInn/loggInn.fxml");

    }


    //lastInnStage(actionEvent, "/sample/OpprettBruker/opprettBruker.fxml");

}
