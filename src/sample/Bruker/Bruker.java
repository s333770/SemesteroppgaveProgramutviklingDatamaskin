package sample.Bruker;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bruker implements Serializable {
    public static ObservableList<Bruker> brukereListe= FXCollections.observableArrayList();
    public static List<Bruker> opprettedeBrukere=new ArrayList<>();


    private transient SimpleStringProperty fornavn;
    private transient SimpleStringProperty etternavn;
    private transient SimpleStringProperty email;
    private transient SimpleStringProperty telefon;
    private transient SimpleStringProperty passord;

    public String getPassord() {
        return passord.get();
    }

    public SimpleStringProperty passordProperty() {
        return passord;
    }

    public void setPassord(String passord) {
        this.passord.set(passord);
    }

    public Bruker(String fornavn, String etternavn, String email, String telefon, String passord) {
        this.fornavn = new SimpleStringProperty(fornavn);
        this.etternavn = new SimpleStringProperty(etternavn);
        this.email = new SimpleStringProperty(email);
        this.telefon = new SimpleStringProperty(telefon);
        this.passord=new SimpleStringProperty(passord);
    }


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

    private void writeObject(ObjectOutputStream objectOutputStream) {
        try {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeUTF(getFornavn());
            objectOutputStream.writeUTF(getEtternavn());
            objectOutputStream.writeUTF(getTelefon());
            objectOutputStream.writeUTF(getEmail());
            objectOutputStream.writeUTF(getPassord());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void readObject(ObjectInputStream objectInputStream){
        try {
            SimpleStringProperty fornavnInput = new SimpleStringProperty(objectInputStream.readUTF());
            SimpleStringProperty etternavnInput = new SimpleStringProperty(objectInputStream.readUTF());
            SimpleStringProperty telefonInput = new SimpleStringProperty(objectInputStream.readUTF());
            SimpleStringProperty emailInput= new SimpleStringProperty(objectInputStream.readUTF());
            SimpleStringProperty passordInput=new SimpleStringProperty(objectInputStream.readUTF());

        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    }
