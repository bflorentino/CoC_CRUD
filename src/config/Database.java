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

    String url = "jdbc:mysql://localhost:3307/clash_of_clans";
    String username = "root";
    String password = "";
    Connection con;

    public Database() {
        try {
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
        }
    }

    public Connection getConnection() {
        return con;
    }

}