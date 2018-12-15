package com.locaLogistica.core;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PAQUETES")
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAQUETE")
    private Long idPaquete;

    @Column(name = "NOMBRE_CONSIGNATARIO")
    private String nombreConsignatario;

    @Column(name = "NUM_CUENTA_CONSIGNATARIO")
    private String numCuentaConsignatario;

    @Column(name = "RECIBIDO_DATETIME")
    private Date fechaRecibido;

    @Column(name = "ID_COURIER")
    private String idCourier;

    @Column(name = "COURIER")
    private String nombreCourier;

    @Column(name = "VUELO_ASIGNADO")
    private String vueloAsignado;

    public Paquete() {
    }

    public Paquete(String nombreConsignatario, String numCuentaConsignatario, Date fechaRecibido, String idCourier, String nombreCourier, String vueloAsignado) {
        this.nombreConsignatario = nombreConsignatario;
        this.numCuentaConsignatario = numCuentaConsignatario;
        this.fechaRecibido = fechaRecibido;
        this.idCourier = idCourier;
        this.nombreCourier = nombreCourier;
        this.vueloAsignado = vueloAsignado;
    }

    public Long getId() {
        return idPaquete;
    }

    public void setId(Long id) {
        this.idPaquete = id;
    }

    public String getNombreConsignatario() {
        return nombreConsignatario;
    }

    public void setNombreConsignatario(String nombreConsignatario) {
        this.nombreConsignatario = nombreConsignatario;
    }

    public String getNumCuentaConsignatario() {
        return numCuentaConsignatario;
    }

    public void setNumCuentaConsignatario(String numCuentaConsignatario) {
        this.numCuentaConsignatario = numCuentaConsignatario;
    }

    public Date getFechaRecibido() {
        return fechaRecibido;
    }

    public void setFechaRecibido(Date fechaRecibido) {
        this.fechaRecibido = fechaRecibido;
    }

    public String getIdCourier() {
        return idCourier;
    }

    public void setIdCourier(String idCourier) {
        this.idCourier = idCourier;
    }

    public String getNombreCourier() {
        return nombreCourier;
    }

    public void setNombreCourier(String nombreCourier) {
        this.nombreCourier = nombreCourier;
    }

    public String getVueloAsignado() {
        return vueloAsignado;
    }

    public void setVueloAsignado(String vueloAsignado) {
        this.vueloAsignado = vueloAsignado;
    }
}
