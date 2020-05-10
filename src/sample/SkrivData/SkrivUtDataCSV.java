package sample.SkrivData;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class SkrivUtDataCSV extends SkrivData  {


    public static void skrivDataTilCSVFil(Object hvaSomSkrives, File filepath) throws FileNotFoundException {
        FileOutputStream fileOutputStream =new FileOutputStream(filepath,true);
        PrintWriter printWriter = new PrintWriter(fileOutputStream);
        printWriter.println(hvaSomSkrives);
        printWriter.close();
    }
}
