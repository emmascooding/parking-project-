package parking.refactored;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// Class to log/write all the receipts in "parking.log"
public class FileParkingLog implements ParkingLog{
    private final String filename;

    public FileParkingLog(String filename){
        this.filename = filename;
    }
    @Override
    public void log(String line){
        try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))){
            out.println(line);
        } catch (IOException e) {
            throw new RuntimeException("Unable to write parking log", e);
        }
    }
}
