package sample.Datamaskin;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Skjermkort implements Serializable {
    public static ObservableList<Skjermkort> skjermkortListe= FXCollections.observableArrayList();



    private SimpleStringProperty skjermkort;
    private SimpleStringProperty skjermkortPris;

    public Skjermkort(String skjermkort, String skjermkortPris) {
        this.skjermkort = new SimpleStringProperty(skjermkort);
        this.skjermkortPris = new SimpleStringProperty(skjermkortPris);
    }

    public String getSkjermkort() {
        return skjermkort.get();
    }

    public SimpleStringProperty skjermkortProperty() {
        return skjermkort;
    }

    public void setSkjermkort(String skjermkort) {
        this.skjermkort.set(skjermkort);
    }

    public String getSkjermkortPris() {
        return skjermkortPris.get();
    }

    public SimpleStringProperty skjermkortPrisProperty() {
        return skjermkortPris;
    }

    public void setSkjermkortPris(String skjermkortPris) {
        this.skjermkortPris.set(skjermkortPris);
    }
    public static Skjermkort skjermkort1=new Skjermkort("GTX 950", "800");
    public static Skjermkort skjermkort2=new Skjermkort("GTX 1050", "1200");

    private void readObject(ObjectInputStream objectInputStream){
        try {
            objectInputStream.defaultReadObject();
            this.skjermkort=new SimpleStringProperty((String)objectInputStream.readObject());
            this.skjermkortPris=new SimpleStringProperty((String)objectInputStream.readObject());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    private void writeObject(ObjectOutputStream objectOutputStream) {
        try {
            objectOutputStream.defaultWriteObject();
            objectOutputStream.writeObject(getSkjermkort());
            objectOutputStream.writeObject(getSkjermkortPris());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
