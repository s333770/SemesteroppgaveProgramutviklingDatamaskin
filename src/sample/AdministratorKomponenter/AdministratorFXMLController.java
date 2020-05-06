package sample.AdministratorKomponenter;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Datamaskin.Harddisk;
import sample.Datamaskin.Minne;
import sample.Datamaskin.Prosessor;
import sample.Datamaskin.Skjermkort;
import sample.PCKonfigurasjon.PCKonfigurasjonController;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.ResourceBundle;

import static sample.Bruker.Bruker.brukereListe;
import static sample.BytteAvScener.lastInnStage;
import static sample.Datamaskin.Harddisk.*;
import static sample.Datamaskin.Minne.*;
import static sample.Datamaskin.Prosessor.*;
import static sample.Datamaskin.Skjermkort.*;

public class AdministratorFXMLController extends PCKonfigurasjonController implements Initializable, Serializable {
    @FXML
    private TableView<Prosessor> tableViewProsessor;
    @FXML
    private TableView<Skjermkort> tableViewSkjermkort;
    @FXML
    private TableView<Minne> tableViewMinne;
    @FXML
    private TableView<Harddisk> tableViewHarddisk;

    @FXML
    TableColumn<Prosessor, String> prosessor;
    @FXML
    TableColumn<Skjermkort, String> skjermkort;
    @FXML
    TableColumn<Minne, String> minne;
    @FXML
    TableColumn<Harddisk, String> harddisk;

    @FXML
    TableColumn<Prosessor, String> prosessorPris;
    @FXML
    TableColumn<Skjermkort, String> skjermkortPris;
    @FXML
    TableColumn<Minne, String> minnePris;
    @FXML
    TableColumn<Harddisk, String> harddiskPris;

    @FXML private ChoiceBox komponenterchoiceBox;

    @FXML private TextField txtKomponent;

    @FXML private TextField txtPris;

    Alert alarmboks = new Alert(Alert.AlertType.INFORMATION); // Lager en alarmboks
    Alert bekreftelse = new Alert(Alert.AlertType.INFORMATION); //Lager en bekreftelse




    @Override
    public void initialize(URL location, ResourceBundle resources) {
        komponenterchoiceBox.getItems().addAll("Prosessor","Skjermkort","Minne","Harddisk");
        setTabellVerdierProsessor("prosessor", "prosessorPris");
        tableViewProsessor.setItems(prosessorListe);
        setTabellVerdierSkjermkort("skjermkort", "skjermkortPris");
        tableViewSkjermkort.setItems(skjermkortListe);
        setTabellVerdierMinne("minne", "minnePris");
        tableViewMinne.setItems(minneListe);
        setTabellVerdierHarddisk("harddisk", "harddiskPris");
        tableViewHarddisk.setItems(harddiskListe);
    }
    public void btnLeggtil(ActionEvent actionEvent) {
        if(komponenterchoiceBox.getValue().equals("Prosessor")){
            Prosessor prosessor=new Prosessor(txtKomponent.getText(),txtPris.getText());
            prosessorListe.add(prosessor);
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/sample/komponenterSerialisert/prosessor.ser"));
                objectOutputStream.writeObject(new ArrayList<>(prosessorListe));
                objectOutputStream.close();
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
                System.err.println(e); // Ikke synlig for bruker,
            }
        }
        else if(komponenterchoiceBox.getValue().equals("Skjermkort")){
            Skjermkort skjermkort =new Skjermkort(txtKomponent.getText(),txtPris.getText());
            skjermkortListe.add(skjermkort);
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/sample/komponenterSerialisert/skjermkort.ser"));
                objectOutputStream.writeObject(new ArrayList<>(skjermkortListe));
                objectOutputStream.close();
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
                System.err.println(e); // Ikke synlig for bruker,
            }
        }
        else if(komponenterchoiceBox.getValue().equals("Minne")){
            Minne minne=new Minne(txtKomponent.getText(),txtPris.getText());
            minneListe.add(minne);
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/sample/komponenterSerialisert/Minne.ser"));
                objectOutputStream.writeObject(new ArrayList<>(minneListe));
                objectOutputStream.close();
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
                System.err.println(e); // Ikke synlig for bruker,
            }
        }
        else if(komponenterchoiceBox.getValue().equals("Harddisk")){
            Harddisk harddisk =new Harddisk(txtKomponent.getText(),txtPris.getText());
            harddiskListe.add(harddisk);
            try {
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/sample/komponenterSerialisert/harddisk.ser"));
                objectOutputStream.writeObject(new ArrayList<>(harddiskListe));
                objectOutputStream.close();
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
                System.err.println(e); // Ikke synlig for bruker,
            }

        }
        else{
            System.out.println("Noe gikk galt");
        }



    }

    public void btnFjern(ActionEvent actionEvent) {
        prosessorListe.removeIf(prosessor->prosessor.getProsessor().equals(txtKomponent.getText()));
        skjermkortListe.removeIf(skjermkort->skjermkort.getSkjermkort().equals(txtKomponent.getText()));
        minneListe.removeIf(minne->minne.getMinne().equals(txtKomponent.getText()));
        harddiskListe.removeIf(harddisk->harddisk.getHarddisk().equals(txtKomponent.getText()));
    }



    public void btnTilbake(ActionEvent actionEvent) {
        lastInnStage(actionEvent, "/sample/sample.fxml");
    }



}
