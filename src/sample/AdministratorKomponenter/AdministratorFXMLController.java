package sample.AdministratorKomponenter;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Datamaskin.Harddisk;
import sample.Datamaskin.Minne;
import sample.Datamaskin.Prosessor;
import sample.Datamaskin.Skjermkort;
import sample.PCKonfigurasjon.PCKonfigurasjonController;

import java.net.URL;
import java.util.ResourceBundle;

import static sample.BytteAvScener.lastInnStage;
import static sample.Datamaskin.Harddisk.*;
import static sample.Datamaskin.Minne.*;
import static sample.Datamaskin.Prosessor.*;
import static sample.Datamaskin.Skjermkort.*;

public class AdministratorFXMLController extends PCKonfigurasjonController implements Initializable {
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
        }
        else if(komponenterchoiceBox.getValue().equals("Skjermkort")){
            Skjermkort skjermkort =new Skjermkort(txtKomponent.getText(),txtPris.getText());
            skjermkortListe.add(skjermkort);
        }
        else if(komponenterchoiceBox.getValue().equals("Minne")){
            Minne minne=new Minne(txtKomponent.getText(),txtPris.getText());
            minneListe.add(minne);
        }
        else if(komponenterchoiceBox.getValue().equals("Harddisk")){
            Harddisk harddisk =new Harddisk(txtKomponent.getText(),txtPris.getText());
            harddiskListe.add(harddisk);
        }
        else{
            System.out.println("Noe gikk galt");
        }



    }

    public void btnFjern(ActionEvent actionEvent) {
        ObservableList<Prosessor> valgtProsessor;
        valgtProsessor=tableViewProsessor.getItems();
        prosessorListe.forEach(valgtProsessor::remove);
        tableViewProsessor.refresh();

    }



    public void btnTilbake(ActionEvent actionEvent) {
        lastInnStage(actionEvent, "/sample/sample.fxml");
    }



}
