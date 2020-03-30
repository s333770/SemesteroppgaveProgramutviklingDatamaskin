package sample.Bruker;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Bruker {
    public static ObservableList<Bruker> brukereListe= FXCollections.observableArrayList();
    public static ObservableList<Bruker> getKundeForsikring() {
        return brukereListe;
    }
    public static void setKundeForsikring(ObservableList<Bruker> kundeForsikring) {
        Bruker.brukereListe = brukereListe;
    }
    private SimpleStringProperty fornavn;

    public Bruker(String fornavn, String etternavn, String email, String telefon) {
        this.fornavn = new SimpleStringProperty(fornavn);
        this.etternavn = new SimpleStringProperty(etternavn);
        this.email = new SimpleStringProperty(email);
        this.telefon = new SimpleStringProperty(telefon);
    }

    private SimpleStringProperty etternavn;
    private SimpleStringProperty email;
    private SimpleStringProperty telefon;
    public String getFornavn() {
        return fornavn.get();
    }
    public SimpleStringProperty fornavnProperty() {
        return fornavn;
    }
    public void setFornavn(String fornavn) {
        this.fornavn.set(fornavn);
    }
    public String getEtternavn() {
        return etternavn.get();
    }
    public SimpleStringProperty etternavnProperty() {
        return etternavn;
    }
    public void setEtternavn(String etternavn) {
        this.etternavn.set(etternavn);
    }
    public String getEmail() {
        return email.get();
    }
    public SimpleStringProperty emailProperty() {
        return email;
    }
    public void setEmail(String email) {
        this.email.set(email);
    }
    public String getTelefon() {
        return telefon.get();
    }
    public SimpleStringProperty telefonProperty() {
        return telefon;
    }
    public void setTelefon(String telefon) {
        this.telefon.set(telefon);
    }




}
