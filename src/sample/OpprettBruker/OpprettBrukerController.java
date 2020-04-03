package sample.OpprettBruker;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Bruker.Bruker;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.InputMismatchException;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static sample.Bruker.Bruker.brukereListe;
import static sample.BytteAvScener.lastInnStage;

public class OpprettBrukerController {
    Alert alarmboks = new Alert(Alert.AlertType.INFORMATION); // Lager en alarmboks
    Alert bekreftelse = new Alert(Alert.AlertType.INFORMATION); //Lager en bekreftelse


    @FXML
    private TextField txtFornavn;

    @FXML
    private TextField txtEtternavn;

    @FXML
    private TextField txtTelefon;

    @FXML
    private TextField txtEmail;

    @FXML
    private Label labelBekreftelse;


    public void btnRegistrer(ActionEvent actionEvent) throws InterruptedException {
        try {
            sjekkOmAlleFeltErFyltUt();
            regExforInputFeilt();
            labelBekreftelse.setText("Bruker opprettet");
            Bruker bruker1=new Bruker(txtFornavn.getText().toString(),txtEtternavn.getText().toString(),txtEmail.getText().toString(),txtTelefon.getText().toString());
            brukereListe.add(bruker1);
            ObjectOutputStream objectOutputStream=new ObjectOutputStream(new FileOutputStream("bruker.ser"));
            objectOutputStream.writeObject(bruker1);
            objectOutputStream.flush();
            objectOutputStream.close();
            lastInnStage(actionEvent, "/sample/sample.fxml");
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
        } catch (IOException e) {
            System.err.println(e);
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
        String regexEmail="[^@]+@[^\\.]+\\..+";
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
