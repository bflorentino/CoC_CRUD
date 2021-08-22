/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.*;
import model.War;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Database {

    private String url = "jdbc:mysql://localhost:3307/clash_of_clans";
    private String username = "root";
    private String password = "";
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public void connect() {
        try {
            con = DriverManager.getConnection(url, username, password);
            st = con.createStatement();
            System.out.println("connected");        
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect() {
        try {

            if (con != null) {
                con.close();
            }

            System.out.println("disconnected");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void insertWar(War war) {
        connect();

        String sql = "INSERT INTO wars(FIRST_CLAN_NAME,SECOND_CLAN_NAME,START_ON) "
                + "VALUES('" + war.getFirstClanName() + "', "
                + "'" + war.getSecondClanName() + "', '"
                + war.getStartOn() + "')";

        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        disconnect();
    }
    
    public void updateWar(War war) {
        connect();

        String sql = "UPDATE wars SET " + 
                "FIRST_CLAN_NAME='" + war.getFirstClanName() + 
                "',SECOND_CLAN_NAME='" + war.getSecondClanName() + 
                "',START_ON='" + war.getStartOn() + 
                "' WHERE ID=" + war.getId();

        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        disconnect();
    }
    
    public void deleteWar(int id) {
        connect();

        String sql = "DELETE FROM wars WHERE ID= " + id; 

        try {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        disconnect();
    }

    public War getWarById(int id) {
        connect();

        War war = null;

        String sql = "SELECT * "
                + "FROM wars WHERE id = " + id;

        try {
            rs = st.executeQuery(sql);

            if (rs.next()) {
                war = new War(
                        rs.getInt("ID"),
                        rs.getString("FIRST_CLAN_NAME"),
                        rs.getString("SECOND_CLAN_NAME"),
                        rs.getDate("START_ON")
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        disconnect();

        return war;
    }

    public List<War> getWars(String toSearch, String value) {
        List<War> wars = new ArrayList<>();

        connect();

        String sql = "SELECT * FROM wars " + 
                "WHERE " + toSearch + " LIKE '%" + value + "%'";

        try {
            rs = st.executeQuery(sql);

            while (rs.next()) {
                wars.add(new War(
                        rs.getInt("ID"),
                        rs.getString("FIRST_CLAN_NAME"),
                        rs.getString("SECOND_CLAN_NAME"),
                        rs.getDate("START_ON"))
                );
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        disconnect();

        return wars;
    }

}
