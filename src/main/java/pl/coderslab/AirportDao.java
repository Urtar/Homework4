package pl.coderslab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.*;

public class AirportDao {

    public List<Airport> getList() {
        List<Airport> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("/users/arturszczepanek/workspace/Homework4/src/main/airports.txt"));) {
            while (scanner.hasNextLine()) {
                StringTokenizer token = new StringTokenizer(scanner.nextLine(), ","+" ");
                String name = token.nextToken();
                String code = token.nextToken();
                String timezone = token.nextToken();
                Airport airport = new Airport(name, code, timezone);
                records.add(airport);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return records;
    }
}
