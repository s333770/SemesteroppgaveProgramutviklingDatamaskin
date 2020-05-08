package sample.Datamaskin;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Harddisk implements Serializable {

    public static ObservableList<Harddisk> harddiskListe= FXCollections.observableArrayList();
    public static ObservableList<Harddisk> harddiskListeDeserialisert= FXCollections.observableArrayList();


    private transient SimpleStringProperty harddisk;
    private transient SimpleStringProperty harddiskPris;

    public Harddisk(String harddisk, String harddiskPris) {
        this.harddisk = new SimpleStringProperty(harddisk);
        this.harddiskPris = new SimpleStringProperty(harddiskPris);
    }
    public String getHarddisk() {
        return harddisk.get();
    }

    public SimpleStringProperty harddiskProperty() {
        return harddisk;
    }

    public void setHarddisk(String harddisk) {
        this.harddisk.set(harddisk);
    }

    public String getHarddiskPris() {
        return harddiskPris.get();
    }

    public SimpleStringProperty harddiskPrisProperty() {
        return harddiskPris;
    }

    public void setHarddiskPris(String harddiskPris) {
        this.harddiskPris.set(harddiskPris);
    }
    public static Harddisk harddisk1=new Harddisk("200 GB", "500");
    public static Harddisk harddisk2=new Harddisk("100GB","1000");

    private void readObject(ObjectInputStream objectInputStream){
        try {
            objectInputStream.defaultReadObject();
            this.harddisk=new SimpleStringProperty((String)objectInputStream.readObject());
            this.harddiskPris=new SimpleStringProperty((String)objectInputStream.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private void writeObject(ObjectOutputStream objectOutputStream) {
        try {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(getHarddisk());
            objectOutputStream.writeObject(getHarddiskPris());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
