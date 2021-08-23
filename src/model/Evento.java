package model;

import java.sql.Date;
import java.sql.Time;

public class Evento {

    private int idEvento;
    private String nombreEvento;
    private Time horaInicio;
    private Time horaFinal;
    private String lugar;
    private Date fecha;
    private String detalles;

    public Evento(String nombreEvento, Time horaInicio, Time horaFinal, String lugar, Date fecha, String detalles) {

        this.nombreEvento = nombreEvento;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.lugar = lugar;
        this.fecha = fecha;
        this.detalles = detalles;

    }

    public Evento(int idEvento, String nombreEvento, Time horaInicio, Time horaFinal, String lugar, Date fecha,
            String detalles) {

        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.lugar = lugar;
        this.fecha = fecha;
        this.detalles = detalles;
    }

    public int getId() {
        return idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Time horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }
}