package sample.Datamaskin;

import javafx.beans.property.SimpleStringProperty;

public class Datamaskin {
    private SimpleStringProperty prosessor;
    private SimpleStringProperty skjermkort;
    private SimpleStringProperty minne;
    private SimpleStringProperty harddisk;
    private SimpleStringProperty prisTotal;

    public Datamaskin(String prosessor, String skjermkort, String minne, String harddisk, String prisTotal) {
        this.prosessor =new SimpleStringProperty(prosessor);
        this.skjermkort = new SimpleStringProperty(skjermkort);
        this.minne = new SimpleStringProperty(minne);
        this.harddisk = new SimpleStringProperty(harddisk);
        this.prisTotal = new SimpleStringProperty(prisTotal);
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

    public String getSkjermkort() {
        return skjermkort.get();
    }

    public SimpleStringProperty skjermkortProperty() {
        return skjermkort;
    }

    public void setSkjermkort(String skjermkort) {
        this.skjermkort.set(skjermkort);
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

    public String getHarddisk() {
        return harddisk.get();
    }

    public SimpleStringProperty harddiskProperty() {
        return harddisk;
    }

    public void setHarddisk(String harddisk) {
        this.harddisk.set(harddisk);
    }

    public String getPrisTotal() {
        return prisTotal.get();
    }

    public SimpleStringProperty prisTotalProperty() {
        return prisTotal;
    }

    public void setPrisTotal(String prisTotal) {
        this.prisTotal.set(prisTotal);
    }
}
