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

import static sample.BytteAvScener.lastInnStage;
import static sample.Datamaskin.Harddisk.*;
import static sample.Datamaskin.Minne.*;
import static sample.Datamaskin.Prosessor.*;
import static sample.Datamaskin.Skjermkort.*;


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
        harddiskListe.add(harddisk2);
        minneListe.add(minne1);
        minneListe.add(minne2);
        prosessorListe.add(prosessor1);
        prosessorListe.add(prosessor2);
        skjermkortListe.add(skjermkort1);
        skjermkortListe.add(skjermkort2);

    setTabellVerdierProsessor("prosessor", "prosessorPris");
    tableViewProsessor.setItems(prosessorListe);
    setTabellVerdierSkjermkort("skjermkort", "skjermkortPris");
    tableViewSkjermkort.setItems(skjermkortListe);
    setTabellVerdierMinne("minne", "minnePris");
    tableViewMinne.setItems(minneListe);
    setTabellVerdierHarddisk("harddisk", "harddiskPris");
    tableViewHarddisk.setItems(harddiskListe);

    }

    public void setTabellVerdierProsessor(String prosessorIn, String prosessorInPris){
        prosessor.setCellValueFactory(new PropertyValueFactory<Prosessor,String>("prosessor"));
        prosessorPris.setCellValueFactory(new PropertyValueFactory<Prosessor,String>("prosessorPris"));
    }
    public void setTabellVerdierSkjermkort(String skjermkortIn, String skjermkortInpris){
        skjermkort.setCellValueFactory(new PropertyValueFactory<Skjermkort,String>("skjermkort"));
        skjermkortPris.setCellValueFactory(new PropertyValueFactory<Skjermkort,String>("skjermkortPris"));
    }
    public void setTabellVerdierMinne(String minneIn, String minneInPris){
        minne.setCellValueFactory(new PropertyValueFactory<Minne,String>("minne"));
        minnePris.setCellValueFactory(new PropertyValueFactory<Minne,String>("minnePris"));
    }
    public void setTabellVerdierHarddisk(String harddiskIn, String harddiskInPris){
        harddisk.setCellValueFactory(new PropertyValueFactory<Harddisk,String>("harddisk"));
        harddiskPris.setCellValueFactory(new PropertyValueFactory<Harddisk,String>("harddiskPris"));
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
        lastInnStage(actionEvent, "/sample/sample.fxml");

    }

    public void btnOrdreBekfreftelse(ActionEvent actionEvent) {
        String prosessorPris;
        String minnePris;
        String skjermkortPris;
        String harddiskPris;
        Integer totalPris;
        prosessorPris=tableViewProsessor.getSelectionModel().getSelectedItem().getProsessorPris().toString();
        minnePris=tableViewMinne.getSelectionModel().getSelectedItem().getMinnePris().toString();
        skjermkortPris=tableViewSkjermkort.getSelectionModel().getSelectedItem().getSkjermkortPris().toString();
        harddiskPris=tableViewHarddisk.getSelectionModel().getSelectedItem().getHarddiskPris().toString();
        totalPris=Integer.parseInt(prosessorPris)+Integer.parseInt(minnePris)+Integer.parseInt(skjermkortPris)+Integer.parseInt(harddiskPris);


        Datamaskin valgtDatamaskin=
                new Datamaskin(
                tableViewProsessor.getSelectionModel().getSelectedItem().getProsessor().toString(),
        tableViewMinne.getSelectionModel().getSelectedItem().getMinne().toString(),
        tableViewSkjermkort.getSelectionModel().getSelectedItem().getSkjermkort().toString(),
        tableViewHarddisk.getSelectionModel().getSelectedItem().getHarddisk().toString(),
                        totalPris.toString());

        System.out.println(valgtDatamaskin.getHarddisk());
    }

    public void regnUtPris(ActionEvent actionEvent) {
        String prosessorPris;
        String minnePris;
        String skjermkortPris;
        String harddiskPris;
        Integer totalPris;
        prosessorPris=tableViewProsessor.getSelectionModel().getSelectedItem().getProsessorPris().toString();
        minnePris=tableViewMinne.getSelectionModel().getSelectedItem().getMinnePris().toString();
        skjermkortPris=tableViewSkjermkort.getSelectionModel().getSelectedItem().getSkjermkortPris().toString();
        harddiskPris=tableViewHarddisk.getSelectionModel().getSelectedItem().getHarddiskPris().toString();
        totalPris=Integer.parseInt(prosessorPris)+Integer.parseInt(minnePris)+Integer.parseInt(skjermkortPris)+Integer.parseInt(harddiskPris);
        System.out.println(totalPris);

    }
}
