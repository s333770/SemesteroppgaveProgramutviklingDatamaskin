package sample;

import sample.Bruker.Bruker;
import sample.Datamaskin.Datamaskin;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter  {
    public static void writer(Bruker bruker, Datamaskin datamaskin){
        JFileChooser fc = new JFileChooser();

        int returnVal = fc.showOpenDialog(aComponent);

        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
        try {
            FileWriter csvWriter = new FileWriter("new.csv");
            csvWriter.append(bruker.getFornavn());
            csvWriter.append(",");
            csvWriter.append(bruker.getEtternavn());
            csvWriter.append(",");
            csvWriter.append(bruker.getTelefon());
            csvWriter.append(",");
            csvWriter.append(bruker.getEmail());
            csvWriter.append(",");
            csvWriter.append(datamaskin.getProsessor());
            csvWriter.append(",");
            csvWriter.append(datamaskin.getSkjermkort());
            csvWriter.append(",");
            csvWriter.append(datamaskin.getMinne());
            csvWriter.append(",");
            csvWriter.append(datamaskin.getHarddisk());
            csvWriter.append(",");
            csvWriter.append(datamaskin.getPrisTotal());
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            System.err.println("Problemer med å skrive til fil");        }

    }
}
