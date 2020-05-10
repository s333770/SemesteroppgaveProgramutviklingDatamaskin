package sample.LoggInn;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import sample.Bruker.Bruker;
import javafx.scene.control.TextField;


import java.io.*;
import java.util.List;

import static java.util.Arrays.stream;
import static sample.Bruker.Bruker.*;
import static sample.BytteAvScener.lastInnStage;

public class LoggInnController implements Serializable {
    Alert alarmboks = new Alert(Alert.AlertType.INFORMATION); // Lager en alarmboks
    Alert bekreftelse = new Alert(Alert.AlertType.INFORMATION); //Lager en bekreftelse

    @FXML
    private TextField txtTelefonEmail;

    @FXML
    private TextField txtPassord;


    public void loggInn(ActionEvent actionEvent) throws IOException {
        String brukerTxtTelefonEmail=txtTelefonEmail.getText();
        String brukerTxtPassord=txtPassord.getText();

        FileInputStream fis=new FileInputStream("src/sample/brukerSerialisert/bruker.ser");
        ObjectInputStream ois=new ObjectInputStream(fis);
        try{
            opprettedeBrukere= FXCollections.observableList((List<Bruker>)ois.readObject());
            opprettedeBrukere.forEach((x)->{
                if((brukerTxtTelefonEmail.equals(x.getTelefon())||brukerTxtTelefonEmail.equals(x.getEmail()))&&(brukerTxtPassord.equals(x.getPassord()))) {
                    lastInnStage(actionEvent, "/sample/PCKonfigurasjon/PCKonfigurasjon.fxml");
                }
                else if(brukerTxtTelefonEmail.equals(testBruker.getTelefon())||brukerTxtTelefonEmail.equals(testBruker.getEmail())&&(testBruker.equals(x.getPassord()))){
                    lastInnStage(actionEvent,"/sample/PCKonfigurasjon/PCKonfigurasjon.fxml");
                }
                else{
                    alarmboks.setTitle("Feil i en av inputfeltene");
                    alarmboks.setContentText("Finner ikke brukerinfo");
                    alarmboks.show();
                }
            });

        }
        catch(EOFException e){
            System.out.println("Noe gikk galt under innlesning av serialisert data, bruk testbruker");
        }
        catch(ClassNotFoundException e){
            System.out.println("Class is not found");
        }
    }

    public void tilbake(ActionEvent actionEvent) {
        lastInnStage(actionEvent, "/sample/sample.fxml");
    }

}
