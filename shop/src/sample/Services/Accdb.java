package sample.Services;

import javafx.scene.control.ComboBox;
import sample.Wearings.Jeans;
import sample.Wearings.Wearings;

import java.sql.*;
import java.util.List;
import static sample.methodes.user;

public class Accdb {

    public void fillDbfResult(List<Wearings> result){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String databaseURL = "jdbc:ucanaccess://C://Users//"+user+"//Desktop//shop//inventory.accdb";
            Connection conn= DriverManager.getConnection(databaseURL);
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM [Jeans]");
            double price = 0; String product = ""; String brand =""; String size = "";String color =""; String gender = "";

            while (rs.next()) {
                product = rs.getString(2).trim();
                brand = rs.getString(3).trim();
                gender = rs.getString(4).trim();
                size = rs.getString(6).trim();
                color = rs.getString(5).trim();
                price = rs.getDouble(7);

                Jeans j = new Jeans(product,brand,price,size,color,gender);
                result.add(j);
            }
            s.close();
            conn.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }


    }
    public void getbrand(ComboBox<String> Brandfilter){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String databaseURL = "jdbc:ucanaccess://C://Users//"+user+"//Desktop//shop//inventory.accdb";
            Connection conn= DriverManager.getConnection(databaseURL);
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT DISTINCT [BRAND] FROM [Jeans]");

            while (rs.next()) {
                Brandfilter.getItems().add(rs.getString(1));
            }
            s.close();
            conn.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void getgender(ComboBox<String> Brandfilter){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String databaseURL = "jdbc:ucanaccess://C://Users//"+user+"//Desktop//shop//inventory.accdb";
            Connection conn= DriverManager.getConnection(databaseURL);
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT DISTINCT [GENDER] FROM [Jeans]");

            while (rs.next()) {
                Brandfilter.getItems().add(rs.getString(1));
            }
            s.close();
            conn.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void getsize(ComboBox<String> Brandfilter){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String databaseURL = "jdbc:ucanaccess://C://Users//"+user+"//Desktop//shop//inventory.accdb";
            Connection conn= DriverManager.getConnection(databaseURL);
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT DISTINCT [SIZE] FROM [Jeans]");

            while (rs.next()) {
                Brandfilter.getItems().add(rs.getString(1));
            }
            s.close();
            conn.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    public void getcolor(ComboBox<String> Brandfilter){
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String databaseURL = "jdbc:ucanaccess://C://Users//"+user+"//Desktop//shop//inventory.accdb";
            Connection conn= DriverManager.getConnection(databaseURL);
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("SELECT DISTINCT [COLOR] FROM [Jeans]");

            while (rs.next()) {
                Brandfilter.getItems().add(rs.getString(1));
            }
            s.close();
            conn.close();
        }catch (SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
