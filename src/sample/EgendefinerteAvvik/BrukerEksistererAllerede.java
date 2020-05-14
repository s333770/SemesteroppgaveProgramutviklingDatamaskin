package sample.EgendefinerteAvvik;

public class BrukerEksistererAllerede extends Exception {
    public BrukerEksistererAllerede(String melding) {
        super(melding);
    }
}