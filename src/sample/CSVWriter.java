package sample;

import javafx.stage.FileChooser;
import sample.Bruker.Bruker;
import sample.Datamaskin.Datamaskin;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CSVWriter  {
    public static void writer(Bruker bruker, Datamaskin datamaskin) {
JFileChooser fileChooser=new JFileChooser();
fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
fileChooser.setPreferredSize(new Dimension(1200,1200));
fileChooser.showSaveDialog(null);
File file=new File(fileChooser.getCurrentDirectory(),"kvittering.csv");
FileWriter csvWriter=null;
            try {
                csvWriter=new FileWriter(file);
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
                System.err.println("Problemer med å skrive til fil");
            }
            catch (NullPointerException e){
                System.err.println("fil er allerede skrevet ut, velg fil på nytt ");
            }

        }


    }

