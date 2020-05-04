package sample.PCKonfigurasjon;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Datamaskin.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import static sample.Datamaskin.Harddisk.harddisk1;
import static sample.Datamaskin.Harddisk.harddiskListe;
import static sample.Datamaskin.Minne.minne1;
import static sample.Datamaskin.Minne.minneListe;
import static sample.Datamaskin.Prosessor.prosessor1;
import static sample.Datamaskin.Prosessor.prosessorListe;
import static sample.Datamaskin.Skjermkort.skjermkort1;
import static sample.Datamaskin.Skjermkort.skjermkortListe;


public class PCKonfigurasjonController implements Initializable {

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


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        harddiskListe.add(harddisk1);
        minneListe.add(minne1);
        prosessorListe.add(prosessor1);
        skjermkortListe.add(skjermkort1);


    setTabellVerdier(harddiskListe.get(0).getHarddisk(),minneListe.get(0).getMinne(),prosessorListe.get(0).getProsessor(),harddiskListe.get(0).getHarddisk());
    tableViewProsessor.setItems(prosessorListe);
    tableViewSkjermkort.setItems(skjermkortListe);
    tableViewMinne.setItems(minneListe);
    tableViewHarddisk.setItems(harddiskListe);
    }
    public void setTabellVerdier(String prosessorIn, String skjermkortIn, String minneIn, String harddiskIn){
        prosessor.setCellValueFactory(new PropertyValueFactory<Prosessor,String>("prosessor"));
        skjermkort.setCellValueFactory(new PropertyValueFactory<Skjermkort,String>("skjermkort"));
        minne.setCellValueFactory(new PropertyValueFactory<Minne,String>("minne"));
        harddisk.setCellValueFactory(new PropertyValueFactory<Harddisk,String>("harddisk"));

    }

/*
    public void setTabellVerdier(String prosessorIn, String skjermkortIn, String minneIn, String harddiskIn){
        prosessor.setCellValueFactory(new PropertyValueFactory<Datamaskin,String>("prosessor"));
        skjermkort.setCellValueFactory(new PropertyValueFactory<Datamaskin,String>("skjermkort"));
        minne.setCellValueFactory(new PropertyValueFactory<Datamaskin,String>("minne"));
        harddisk.setCellValueFactory(new PropertyValueFactory<Datamaskin,String>("harddisk"));

    }
    */



    public void btnTilbake(ActionEvent actionEvent) {

    }

    public void btnOrdreBekfreftelse(ActionEvent actionEvent) {


    }
}
