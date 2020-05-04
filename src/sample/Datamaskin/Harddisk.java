package sample.Datamaskin;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Harddisk {

    public static ObservableList<Harddisk> harddiskListe= FXCollections.observableArrayList();

    private SimpleStringProperty harddisk;
    private SimpleStringProperty harddiskPris;

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

}
