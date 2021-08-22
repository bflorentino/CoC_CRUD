/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.*;

/**
 *
 * @author Admin
 */
public class War {
    private int id;
    private String firstClanName;    
    private String secondClanName;
    private Date startOn;

    public War(String firstClanName, String secondClanName, Date startOn) {
        this.firstClanName = firstClanName;
        this.secondClanName = secondClanName;
        this.startOn = startOn;
    }
    
    public War(int id, String firstClanName, String secondClanName, Date startOn) {
        this.id = id;
        this.firstClanName = firstClanName;
        this.secondClanName = secondClanName;
        this.startOn = startOn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstClanName() {
        return firstClanName;
    }

    public void setFirstClanName(String firstClanName) {
        this.firstClanName = firstClanName;
    }

    public String getSecondClanName() {
        return secondClanName;
    }

    public void setSecondClanName(String secondClanName) {
        this.secondClanName = secondClanName;
    }

    public Date getStartOn() {
        return startOn;
    }

    public void setStartOn(Date startOn) {
        this.startOn = startOn;
    }
    
    

}
