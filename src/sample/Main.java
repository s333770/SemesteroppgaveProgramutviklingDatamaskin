package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.Datamaskin.Harddisk.*;
import static sample.Datamaskin.Minne.*;
import static sample.Datamaskin.Prosessor.*;
import static sample.Datamaskin.Skjermkort.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.sizeToScene();
        primaryStage.show();
    }


    public static void main(String[] args) {
        harddiskListe.add(harddisk1);
        harddiskListe.add(harddisk2);
        minneListe.add(minne1);
        minneListe.add(minne2);
        prosessorListe.add(prosessor1);
        prosessorListe.add(prosessor2);
        skjermkortListe.add(skjermkort1);
        skjermkortListe.add(skjermkort2);
        launch(args);
    }


}
