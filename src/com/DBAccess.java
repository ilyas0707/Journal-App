package com;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBAccess {
    private final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private final String USER = "postgres";
    private final String PASSWORD = "12345";

    public Connection connect(){

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            String message = "Connected to the database successfully!";
            System.out.println(message);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public List<Data> fetchData() {
        String SQL = "select name, points FROM data_app_fxml";
        List<Data> debts = new ArrayList<>();
        try (Connection conn = connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SQL)) {

            while (rs.next()) {
                Data product = new Data();
                product.setName(rs.getString("name"));
                product.setPoints(rs.getString("points"));
                debts.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return debts;
    }
    public Data addData(Data data){
        String SQL = "insert into data_app_fxml(name,points) values ('"+data.getName()+"', '"+data.getPoints()+"')";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(SQL);
            System.out.println("Added new Data to db " + data);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return data;
    }

    public void reset(){
        String SQL = "delete from data_app_fxml";
        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            stmt.execute(SQL);
            System.out.println("All data was deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
