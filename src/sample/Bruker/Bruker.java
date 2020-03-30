package sample.Bruker;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Bruker {
    private static ObservableList<Bruker> kundeForsikring= FXCollections.observableArrayList();
    public static ObservableList<Bruker> getKundeForsikring() {
        return kundeForsikring;
    }
    public static void setKundeForsikring(ObservableList<Bruker> kundeForsikring) {
        Bruker.kundeForsikring = kundeForsikring;
    }
    private SimpleStringProperty fornavn;
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
