package sample.Datamaskin;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Prosessor implements Serializable {
    public static ObservableList<Prosessor> prosessorListe= FXCollections.observableArrayList();


    private SimpleStringProperty prosessor;
    private SimpleStringProperty prosessorPris;

    public Prosessor(String prosessor, String prosessorPris) {
        this.prosessor = new SimpleStringProperty(prosessor);
        this.prosessorPris = new SimpleStringProperty(prosessorPris);
    }

    public String getProsessor() {
        return prosessor.get();
    }

    public SimpleStringProperty prosessorProperty() {
        return prosessor;
    }

    public void setProsessor(String prosessor) {
        this.prosessor.set(prosessor);
    }

    public String getProsessorPris() {
        return prosessorPris.get();
    }

    public SimpleStringProperty prosessorPrisProperty() {
        return prosessorPris;
    }

    public void setProsessorPris(String prosessorPris) {
        this.prosessorPris.set(prosessorPris);
    }

    private void readObject(ObjectInputStream objectInputStream){
        try {
            objectInputStream.defaultReadObject();
            this.prosessor=new SimpleStringProperty((String)objectInputStream.readObject());
            this.prosessorPris=new SimpleStringProperty((String)objectInputStream.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private void writeObject(ObjectOutputStream objectOutputStream) {
        try {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(getProsessor());
            objectOutputStream.writeObject(getProsessorPris());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







    public static Prosessor prosessor1=new Prosessor("i3","800");
    public static Prosessor prosessor2=new Prosessor("i5","1000");
}
