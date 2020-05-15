package sample.AdministratorKomponenter;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Datamaskin.*;
import sample.EgendefinerteAvvik.FinnerIkkeKomponent;
import sample.PCKonfigurasjon.PCKonfigurasjonController;


import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
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
        setTabellVerdierSkjermkort("skjermkort", "skjermkortPris");
        setTabellVerdierMinne("minne", "minnePris");
        setTabellVerdierHarddisk("harddisk", "harddiskPris");
        tableViewProsessor.setItems(prosessorListe);
        tableViewSkjermkort.setItems(skjermkortListe);
        tableViewMinne.setItems(minneListe);
        tableViewHarddisk.setItems(harddiskListe);
        FileInputStream fisPros = null;
        try {
            fisPros = new FileInputStream("src/sample/komponenterSerialisert/prosessor.ser");
        } catch (FileNotFoundException e) {
            System.err.println("Finner ikke fil");
        }
        catch (NullPointerException npe){
            System.err.println("Ikke lagren noen prosessorfil");
        }
        ObjectInputStream oisPros = null;
        try {
            oisPros = new ObjectInputStream(fisPros);
        } catch (IOException e) {
            e.printStackTrace();
        }
        catch(NullPointerException e){
            System.err.println("Null pointer for prosessor");
        }

        try {
            prosessorListeDeserialisert = FXCollections.observableList((List<Prosessor>) oisPros.readObject());
            tableViewProsessor.setItems(prosessorListeDeserialisert);

        } catch (IOException e) {
            System.err.println("Det er ingen readObjects for prosessor");;
        } catch (ClassNotFoundException e) {
            System.err.println("Finner ikke klasse for prosessor");
        }
        catch (NullPointerException npe){
            System.err.println("Det er ikke valgt et element");
        }
        /*#############################################################################*/
        FileInputStream fisMinne = null;
        try {
            fisMinne = new FileInputStream("src/sample/komponenterSerialisert/minne.ser");
        } catch (FileNotFoundException e) {
            System.err.println("Finner ikke serialisert  for minne");
        }
        ObjectInputStream oisMinne = null;
        try {
            oisMinne = new ObjectInputStream(fisMinne);
        } catch (IOException e) {
            System.err.println("Klarer ikke � �pne inputstream for minne");
        }
        catch(NullPointerException npe){
            System.err.println("Det er ikke opprettet en slik fil");
        }
        try {
            minneListeDeserialisert = FXCollections.observableList((List<Minne>) oisMinne.readObject());
            tableViewMinne.setItems(minneListeDeserialisert);

        } catch (IOException e) {
            System.err.println("Klarer ikke � �pne inputstream for ");
        } catch (ClassNotFoundException e) {
            System.err.println("Finner ikke klasse for minne");
        }
        catch(NullPointerException npe){
            System.err.println("Det er ikke opprettet en slik fil");
        }
        /*#############################################################################*/
        FileInputStream fisSkjermkort = null;
        try {
            fisSkjermkort = new FileInputStream("src/sample/komponenterSerialisert/skjermkort.ser");
        } catch (FileNotFoundException e) {
            System.err.println("Finner ikke fil for skjermkort");
        }
        catch(NullPointerException npe){
            System.err.println("Det er ikke opprettet en slik fil");
        }
        ObjectInputStream oisSkjermkort = null;
        try {
            oisSkjermkort = new ObjectInputStream(oisSkjermkort);
        } catch (IOException e) {
            System.err.println("Klarer ikke � lese inputstream");
        }
        catch(NullPointerException npe){
            System.err.println("Det er ikke opprettet en slik fil for skjermkort");
        }

        try {
            skjermkortListeDeserialisert= FXCollections.observableList((List<Skjermkort>) oisSkjermkort.readObject());
            tableViewSkjermkort.setItems(skjermkortListeDeserialisert);

        } catch (IOException e) {
            System.err.println("Finner ikke fil");
        } catch (ClassNotFoundException e) {
            System.err.println("Finner ikke klasse");
        }
        catch(NullPointerException npe){
            System.err.println("Det er ikke opprettet en slik fil");
        }



        FileInputStream fisHarddisk = null;
        try {
            fisSkjermkort = new FileInputStream("src/sample/komponenterSerialisert/harddisk.ser");
        } catch (FileNotFoundException e) {
            System.err.println("Finner ikke fil");
        }
        ObjectInputStream oisHarddisk = null;
        try {
            oisSkjermkort = new ObjectInputStream(oisSkjermkort);
        } catch (IOException e) {
            System.err.println("Finner ikke fil");
        }
        catch(NullPointerException npe){
            System.err.println("Det er ikke opprettet en slik fil");
        }
        try {
            harddiskListeDeserialisert= FXCollections.observableList((List<Harddisk>) oisHarddisk.readObject());
            tableViewHarddisk.setItems(harddiskListeDeserialisert);
        } catch (IOException e) {
            System.err.println("Finner ikke fil");
        } catch (ClassNotFoundException e) {
            System.err.println("Finner ikke klasse harddisk");
        }
        catch(NullPointerException npe){
            System.err.println("Finner ikke harddiskfil");
        }

    }


    public void btnLeggtil(ActionEvent actionEvent) {
        Thread t1=new Thread(new Runnable() {
            private  volatile boolean exit = false;
            public void stopOpp()
            {
                exit = true;
            }
            @Override
            public void run() {
                while (!exit) {
                    try {
                        Thread.sleep(3000);
                        if (komponenterchoiceBox.getValue().equals("Prosessor")) {
                            Prosessor prosessor = new Prosessor(txtKomponent.getText(), txtPris.getText());
                            prosessorListe.add(prosessor);
                            try {
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/sample/komponenterSerialisert/prosessor.ser"));
                                objectOutputStream.writeObject(new ArrayList<>(prosessorListe));
                                objectOutputStream.close();
                                tableViewProsessor.refresh();
                            } catch (FileNotFoundException e) {
                                System.err.println("Feil lagringsbane er angitt ");
                            } catch (IOException e) {
                                System.err.println("Noe gikk feil under serialisering");
                            }

                        } else if (komponenterchoiceBox.getValue().equals("Skjermkort")) {
                            Skjermkort skjermkort = new Skjermkort(txtKomponent.getText(), txtPris.getText());
                            skjermkortListe.add(skjermkort);
                            try {
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/sample/komponenterSerialisert/skjermkort.ser"));
                                objectOutputStream.writeObject(new ArrayList<>(skjermkortListe));
                                objectOutputStream.close();
                                tableViewSkjermkort.refresh();
                            } catch (FileNotFoundException e) {
                                System.err.println("Feil lagringsbane er angitt for skjermkort");
                            } catch (IOException e) {
                                System.err.println("Noe gikk feil under serialisering");
                            }
                        } else if (komponenterchoiceBox.getValue().equals("Minne")) {
                            Minne minne = new Minne(txtKomponent.getText(), txtPris.getText());
                            minneListe.add(minne);
                            try {
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/sample/komponenterSerialisert/Minne.ser"));
                                objectOutputStream.writeObject(new ArrayList<>(minneListe));
                                objectOutputStream.close();
                                tableViewMinne.refresh();
                            } catch (FileNotFoundException e) {
                                System.err.println("Feil lagringsbane er  for minne ");
                            } catch (IOException e) {
                                System.err.println("Noe gikk feil under serialisering");
                            }
                        } else if (komponenterchoiceBox.getValue().equals("Harddisk")) {
                            Harddisk harddisk = new Harddisk(txtKomponent.getText(), txtPris.getText());
                            harddiskListe.add(harddisk);
                            try {
                                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("src/sample/komponenterSerialisert/harddisk.ser"));
                                objectOutputStream.writeObject(new ArrayList<>(harddiskListe));
                                objectOutputStream.close();
                                tableViewHarddisk.refresh();
                            } catch (FileNotFoundException e) {
                                System.err.println("Feil lagringsbane er angitt harddisk");
                            } catch (IOException e) {
                                System.err.println("Ikke serialiserbar lagringsdata");
                            }
                        } else {
                            System.out.println("Noe gikk galt");
                        }
                    } catch (InterruptedException e) {
                        System.err.println("Trådprogrammering fungerer ikke");
                    }
                    finally{
                        stopOpp();
                    }
                }
            }
        });

        try{
            t1.start();
        }catch(IllegalThreadStateException e){
            System.err.println("Thread is in an illegal state");
        }

    }

    public void btnFjern(ActionEvent actionEvent) {
        int plSize=prosessorListe.size();
        int skSize=skjermkortListe.size();
        int mlSize=minneListe.size();
        int hdSize=harddiskListe.size();
            prosessorListe.removeIf(prosessor -> prosessor.getProsessor().equals(txtKomponent.getText()));
            skjermkortListe.removeIf(skjermkort -> skjermkort.getSkjermkort().equals(txtKomponent.getText()));
            minneListe.removeIf(minne -> minne.getMinne().equals(txtKomponent.getText()));
            harddiskListe.removeIf(harddisk -> harddisk.getHarddisk().equals(txtKomponent.getText()));
            int plSize2=prosessorListe.size();
            int skSize2=skjermkortListe.size();
            int mlSize2=minneListe.size();
            int hdSize2=harddiskListe.size();
        if(plSize2==plSize && skSize2==skSize &&mlSize2==mlSize&&hdSize2==hdSize){
            alarmboks.setTitle("Finner ingen komponenter");
            alarmboks.setContentText("Skriv inn en komponent og pris som skal slettes");
            alarmboks.show();


        }
    }

    public void btnTilbake(ActionEvent actionEvent) {
        lastInnStage(actionEvent, "/sample/sample.fxml");
    }
}
