package sample.Datamaskin;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Skjermkort {
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
}
