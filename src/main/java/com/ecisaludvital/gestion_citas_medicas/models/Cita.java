package com.ecisaludvital.gestion_citas_medicas.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "citas")
public class Cita {

    @Id
    private String id;
    private String idecisaludvital;
    private String usuario;
    private Date fecha;
    private String horaInicio;
    private String horaFin;
    private String especialidad;
    private String estado;

    public Cita() {
    }

    public Cita(String idecisaludvital, String usuario, Date fecha, String horaInicio, String horaFin, String especialidad, String estado) {
        this.idecisaludvital = idecisaludvital;
        this.usuario = usuario;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.especialidad = especialidad;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdecisaludvital() {
        return idecisaludvital;
    }

    public void setIdecisaludvital(String idecisaludvital) {
        this.idecisaludvital = idecisaludvital;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
