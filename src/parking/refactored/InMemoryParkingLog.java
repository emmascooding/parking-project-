package parking.refactored;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
// this class serves as tester without creating of modifying the file
public class InMemoryParkingLog implements ParkingLog{
    private final List<String> entries = new ArrayList<>();

    @Override
    public void log(String line){
        entries.add(line);
    }
    public List<String> getEntries(){
        return Collections.unmodifiableList(entries);
    }
}
