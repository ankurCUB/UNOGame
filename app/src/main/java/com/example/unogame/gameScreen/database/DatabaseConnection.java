package com.example.unogame.gameScreen.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Hashtable;

public class DatabaseConnection {
    private final String url = "jdbc:postgresql://raja.db.elephantsql.com:5432/";
    private final String username = "sqycyiku";
    private final String password = "UsWXHoEn38oK-yLAFqYM4xWZ1YtLCKs_";

    public ArrayList<Map<String,String>> QueryDatabase(String query){
        try {
            Class.forName("org.postgresql.Driver");
        }
        catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        ArrayList<Map<String,String>> values = new ArrayList<Map<String,String>>();
        try {
            Connection db = DriverManager.getConnection(url, username, password);
            Statement st = db.createStatement();
            ResultSet rs = st.executeQuery(query);
            ResultSetMetaData metadata = rs.getMetaData();
            int columnCount = metadata.getColumnCount();
            while (rs.next()) {
                Map<String,String> data = new Hashtable<String, String>();
                for (int i = 1; i <= columnCount; i++) {
                    data.put(metadata.getColumnName(i), rs.getString(i));
                }
                values.add(data);
            }
            rs.close();
            st.close();
        }
        catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
        return values;
    }
}
