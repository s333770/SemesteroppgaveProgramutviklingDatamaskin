package sample.Datamaskin;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Minne implements Serializable {
    public static ObservableList<Minne> minneListe= FXCollections.observableArrayList();
    public static ObservableList<Minne> minneListeDeserialisert= FXCollections.observableArrayList();

    private transient SimpleStringProperty minne;
    private transient SimpleStringProperty minnePris;

    public Minne(String minne, String minnePris) {
        this.minne =new SimpleStringProperty(minne);
        this.minnePris = new SimpleStringProperty(minnePris);
    }

    public String getMinne() {
        return minne.get();
    }

    public SimpleStringProperty minneProperty() {
        return minne;
    }

    public void setMinne(String minne) {
        this.minne.set(minne);
    }

    public String getMinnePris() {
        return minnePris.get();
    }

    public SimpleStringProperty minnePrisProperty() {
        return minnePris;
    }

    public void setMinnePris(String minnePris) {
        this.minnePris.set(minnePris);
    }
    public static Minne minne1=new Minne("25GB","400");
    public static Minne minne2=new Minne("50GB","800");

    private void readObject(ObjectInputStream objectInputStream){
        try {
            objectInputStream.defaultReadObject();
            this.minne=new SimpleStringProperty((String)objectInputStream.readObject());
            this.minnePris=new SimpleStringProperty((String)objectInputStream.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private void writeObject(ObjectOutputStream objectOutputStream) {
        try {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(getMinne());
            objectOutputStream.writeObject(getMinnePris());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
