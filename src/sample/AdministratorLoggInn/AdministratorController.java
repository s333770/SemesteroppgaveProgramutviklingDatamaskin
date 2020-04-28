package sample.AdministratorLoggInn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.Administrator.Administrator;

import java.io.*;

import static sample.BytteAvScener.lastInnStage;

public class AdministratorController {

    @FXML
    TextField txtAdministratorBrukernavn;

    @FXML
    TextField txtAdministratorPassord;







    public void btnLoggInn(ActionEvent actionEvent) {
        System.out.println(Administrator.Administrator1.getAdministratorBrukernavn());

        if(txtAdministratorBrukernavn.getText().equals(Administrator.Administrator1.getAdministratorBrukernavn())){

            if(txtAdministratorPassord.getText().equals(Administrator.Administrator1.getAdministratorPassord())){
                lastInnStage(actionEvent,"/sample/PCKonfigurasjon/PCKonfigurasjon.fxml");
            }
            else if(!(txtAdministratorPassord.equals(Administrator.Administrator1.getAdministratorPassord()))){
                System.out.println("Du har ikke adgang, ugyldig passord");
            }
        }
        else if(!(txtAdministratorBrukernavn.equals(Administrator.Administrator1.getAdministratorBrukernavn()))){
            System.out.println("Du har ikke adgang, ugyldig brukernavn");
        }



    }

    public void btnTilbake(ActionEvent actionEvent) {
        lastInnStage(actionEvent, "/sample/sample.fxml");

    }


}
