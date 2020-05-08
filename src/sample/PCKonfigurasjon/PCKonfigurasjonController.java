package sample.PCKonfigurasjon;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Bruker.Bruker;
import sample.Datamaskin.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import static sample.Bruker.Bruker.opprettedeBrukere;
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
        setTabellVerdierProsessor("prosessor", "prosessorPris");
        tableViewProsessor.setItems(prosessorListe);
        setTabellVerdierSkjermkort("skjermkort", "skjermkortPris");
        tableViewSkjermkort.setItems(skjermkortListe);
        setTabellVerdierMinne("minne", "minnePris");
        tableViewMinne.setItems(minneListe);
        setTabellVerdierHarddisk("harddisk", "harddiskPris");
        tableViewHarddisk.setItems(harddiskListe);

        FileInputStream fisPros = null;
        try {
            fisPros = new FileInputStream("src/sample/komponenterSerialisert/prosessor.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream oisPros = null;
        try {
            oisPros = new ObjectInputStream(fisPros);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            prosessorListeDeserialisert = FXCollections.observableList((List<Prosessor>) oisPros.readObject());
            tableViewProsessor.setItems(prosessorListeDeserialisert);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        FileInputStream fisMinne = null;
        try {
            fisMinne = new FileInputStream("src/sample/komponenterSerialisert/minne.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream oisMinne = null;
        try {
            oisMinne = new ObjectInputStream(fisMinne);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            minneListeDeserialisert = FXCollections.observableList((List<Minne>) oisMinne.readObject());
            tableViewMinne.setItems(minneListeDeserialisert);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        FileInputStream fisSkjermkort = null;
        try {
            fisSkjermkort = new FileInputStream("src/sample/komponenterSerialisert/skjermkort.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream oisSkjermkort = null;
        try {
            oisSkjermkort = new ObjectInputStream(oisSkjermkort);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            skjermkortListeDeserialisert= FXCollections.observableList((List<Skjermkort>) oisSkjermkort.readObject());
            tableViewSkjermkort.setItems(skjermkortListeDeserialisert);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        FileInputStream fisHarddisk = null;
        try {
            fisSkjermkort = new FileInputStream("src/sample/komponenterSerialisert/harddisk.ser");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectInputStream oisHarddisk = null;
        try {
            oisSkjermkort = new ObjectInputStream(oisSkjermkort);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            harddiskListeDeserialisert= FXCollections.observableList((List<Harddisk>) oisHarddisk.readObject());
            tableViewHarddisk.setItems(harddiskListeDeserialisert);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

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
