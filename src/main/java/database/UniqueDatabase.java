package database;

import flowers.Order;
import lombok.Getter;
import lombok.Setter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

@Getter
@Setter
public class UniqueDatabase {
    private FileWriter file;
    private ArrayList<Order> orders;
    private String Filename;

    public void Database(String filename) throws IOException {

    }

    public void add(Order order) {
        orders.add(order);
    }

    public void comit() throws IOException {
        for (Order order : orders) {
            file.write(order.toString());
        }
        file.close();
    }
    private static UniqueDatabase ourInstance;

    public static UniqueDatabase getInstance() throws IOException {
        if (ourInstance == null){
            ourInstance = new UniqueDatabase(ourInstance.Filename);
        }
        return ourInstance;
    }

    private UniqueDatabase(String filename) throws IOException {
        Filename = filename;
        file = new FileWriter(filename);
    }
}
