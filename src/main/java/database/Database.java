package database;

import flowers.Order;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Database {
    private FileWriter file;
    private ArrayList<Order> orders;
    private String Filename;

    public void Database(String filename) throws IOException {
        Filename = filename;
        file = new FileWriter(filename);
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
}
