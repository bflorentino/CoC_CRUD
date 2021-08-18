/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.*;

 /**
 *
 * @author Admin
 */
public class Database {

    private String url = "jdbc:mysql://localhost:3307/clash_of_clans";
    private String username = "root";
    private String password = "";
    private Connection con;

    public Database() {
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return con;
    }

}