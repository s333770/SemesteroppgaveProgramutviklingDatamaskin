package sample.Datamaskin;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Minne {
    public static ObservableList<Minne> minneListe= FXCollections.observableArrayList();

    private SimpleStringProperty minne;
    private SimpleStringProperty minnePris;

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
}
