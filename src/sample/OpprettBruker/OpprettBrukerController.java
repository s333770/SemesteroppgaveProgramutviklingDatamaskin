package sample.OpprettBruker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

import java.util.InputMismatchException;

import static sample.BytteAvScener.lastInnStage;

public class OpprettBrukerController {
    Alert alarmboks = new Alert(Alert.AlertType.INFORMATION); // Lager en alarmboks


    @FXML
    private TextField txtFornavn;

    @FXML
    private TextField txtEtternavn;

    @FXML
    private TextField txtTelefon;

    @FXML
    private TextField txtEmail;


    public void btnRegistrer(ActionEvent actionEvent) {
        try {
            sjekkOmAlleFeltErFyltUt();
            regExforInputFeilt();
        }
        catch (InputMismatchException e){
            System.err.println(e.getMessage());
            alarmboks.setTitle("Feil i en av inputfeltene");
            alarmboks.setContentText(e.getMessage());
            alarmboks.show();
        }
        catch (IllegalArgumentException e){
            System.err.println(e.getMessage());
            alarmboks.setTitle("Feil i en av inputfeltene");
            alarmboks.setContentText(e.getMessage());
            alarmboks.show();
        }

    }

    public void btnAvbryt(ActionEvent actionEvent) {
        lastInnStage(actionEvent, "/sample/sample.fxml");
    }

    private void sjekkOmAlleFeltErFyltUt() throws InputMismatchException {
        if (txtFornavn.getText().equals("")  || txtEtternavn.getText().equals("") || txtEmail.getText().equals("")||txtTelefon.getText().equals("")) {
            throw new InputMismatchException("Alle feltene er ikke fylt ut ");
        }
    }
    private String regExforInputFeilt() throws IllegalArgumentException{
        String fornavn =txtFornavn.getText();
        String etternavn= txtEtternavn.getText();
        String email=txtEmail.getText();
        String telefon=txtTelefon.getText();
        String regexFornavn = "^[a-zA-Z\\s]+";
        String regexEtternavn= "^[a-zA-Z\\s]+";
        String regexEmail="^\\S+@\\S+$";
        String regexTelefon="\\d{8}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{4}";
        if (!(fornavn.matches(regexFornavn))){
            throw new IllegalArgumentException("Ikke gyldig fornavn");
        }
        if (!(etternavn.matches(regexEtternavn))){
            throw new IllegalArgumentException("Ikke gyldig etternavn");
        }
        if (!(email.matches(regexEmail))){
            throw new IllegalArgumentException("Ikke gyldig email");
        }
        if (!(telefon.matches(regexTelefon))){
            throw new IllegalArgumentException("Ikke gyldig telefon");
        }

    return "vellyktet";
    }
}
