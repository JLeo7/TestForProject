package com.locaLogistica.core;

import javax.persistence.*;

@Entity
@Table(name = "PREALERTAS")
public class Prealerta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NUM_CUENTA_CONSIGNATARIO")
    private String numCuentaConsignatario;

    @Column(name = "COURIER")
    private String nombreCourier;

    @Column(name = "ID_COURIER")
    private String idCourier;

    @Column(name = "MONTO_FACTURA")
    private double montoFactura;

    @Column(name = "NOMBRE_TIENDA")
    private String nombreTienda;

    public Prealerta() {
    }

    public Prealerta(String numCuentaConsignatario, String nombreCourier, String idCourier, double montoFactura, String nombreTienda) {
        this.numCuentaConsignatario = numCuentaConsignatario;
        this.nombreCourier = nombreCourier;
        this.idCourier = idCourier;
        this.montoFactura = montoFactura;
        this.nombreTienda = nombreTienda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumCuentaConsignatario() {
        return numCuentaConsignatario;
    }

    public void setNumCuentaConsignatario(String numCuentaConsignatario) {
        this.numCuentaConsignatario = numCuentaConsignatario;
    }

    public String getNombreCourier() {
        return nombreCourier;
    }

    public void setNombreCourier(String nombreCourier) {
        this.nombreCourier = nombreCourier;
    }

    public String getIdCourier() {
        return idCourier;
    }

    public void setIdCourier(String idCourier) {
        this.idCourier = idCourier;
    }

    public double getMontoFactura() {
        return montoFactura;
    }

    public void setMontoFactura(double montoFactura) {
        this.montoFactura = montoFactura;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }
}
