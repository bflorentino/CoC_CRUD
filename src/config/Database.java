/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.*;
//import model.War;
import java.util.ArrayList;
import java.util.List;
import model.Evento;

/**
 *
 * @author Admin
 */
public class Database {

    private String url = "jdbc:mysql://localhost:3306/proyecto_final";
    private String username = "root";
    private String password = "";
    private Connection con;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs;

    private boolean conectar() {

        try {
            con = DriverManager.getConnection(url, username, password);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean desconectar() {

        try {

            if (con != null) {
                con.close();
            }
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public boolean insertarEvento(Evento evento) {

        boolean insertado = false;

        String query = "INSERT INTO EVENTOS" + "(NOMBRE," + " HORA_INICIO," + " HORA_FINAL," + "LUGAR," + "FECHA,"
                + "DETALLES)" + " VALUES (?, ?, ?, ?, ?, ?)";

        if (conectar()) {

            try {
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setString(1, evento.getNombreEvento());
                preparedStatement.setTime(2, evento.getHoraInicio());
                preparedStatement.setTime(3, evento.getHoraFinal());
                preparedStatement.setString(4, evento.getLugar());
                preparedStatement.setDate(5, evento.getFecha());
                preparedStatement.setString(6, evento.getDetalles());

                preparedStatement.executeUpdate();
                insertado = true;

            } catch (SQLException ex) {
                insertado = false;
            } finally {
                desconectar();
            }
        }
        return insertado;
    }
    
    

    public void eliminarEvento(int id) {

        String query = "DELETE FROM EVENTOS WHERE ID = ?";

        if (conectar()) {

            try {
                preparedStatement = con.prepareStatement(query);
                preparedStatement.setInt(1, id);

                preparedStatement.executeUpdate();
            } catch (SQLException ex) {

            } finally {
                desconectar();
            }
        }
    }
    
    
    public boolean actualizarEvento(Evento evento) {

        String query = "UPDATE EVENTOS SET NOMBRE = ? ,HORA_INICIO = ? ,HORA_FINAL = ? ,LUGAR = ? ,FECHA = ? ,DETALLES = ? WHERE ID = "
                + evento.getId();
        boolean actualizado = false;

        if (conectar()) {

            try {
                preparedStatement = con.prepareStatement(query);

                preparedStatement.setString(1, evento.getNombreEvento());
                preparedStatement.setTime(2, evento.getHoraInicio());
                preparedStatement.setTime(3, evento.getHoraFinal());
                preparedStatement.setString(4, evento.getLugar());
                preparedStatement.setDate(5, evento.getFecha());
                preparedStatement.setString(6, evento.getDetalles());

                preparedStatement.executeUpdate();

                actualizado = true;

            } catch (SQLException ex) {
                actualizado = false;
            } finally {
                desconectar();
            }
        }
        return actualizado;
    }
    
    public List<Evento> getEventos(String campo, String valor) {

        List<Evento> eventos = new ArrayList<>();

        String query = "SELECT * FROM EVENTOS " + 
                "WHERE " + campo + " LIKE '%" + valor + "%' ORDER BY FECHA";
        

        if (conectar()) {
            try {
                preparedStatement = con.prepareStatement(query);
                rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    eventos.add(new Evento(rs.getInt("id"), rs.getString("Nombre"), rs.getTime("Hora_Inicio"),
                            rs.getTime("Hora_Final"), rs.getString("Lugar"), rs.getDate("Fecha"),
                            rs.getString("Detalles")));
                }
            } catch (SQLException ex) {

            } finally {
                desconectar();
            }
        }
        return eventos;
    }

}
