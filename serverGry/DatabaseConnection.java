package com.example.serverGry;

import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class DatabaseConnection {
    public Connection c;
    public Statement statement;
    ResultSet result;
    String sql;

    public DatabaseConnection(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            c = DriverManager.getConnection("","","");
            this.statement =  c.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            System.out.println("can not connect to database");
        }
        this.sql = "SELECT * FROM gracze";
        try {
            this.result =  statement.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
