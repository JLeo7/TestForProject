package com.locaLogistica.core;

import javax.persistence.*;

@Entity
@Table(name = "FACTURAS")
public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PAQUETE")
    private Paquete paquete = new Paquete();

    @Transient
    private int idPaquete;

    @Column(name = "MONTO_FACTURA")
    private String montoFactura;

    @Column(name = "NOMBRE_TIENDA")
    private String nombreTienda;

    public Factura() {
    }

    public Factura(Paquete paquete, String montoFactura, String nombreTienda) {
        this.paquete = paquete;
        this.montoFactura = montoFactura;
        this.nombreTienda = nombreTienda;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public int getIdPaquete() {
        return idPaquete;
    }

    public void setIdPaquete(int idPaquete) {
        this.idPaquete = idPaquete;
    }

    public String getMontoFactura() {
        return montoFactura;
    }

    public void setMontoFactura(String montoFactura) {
        this.montoFactura = montoFactura;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }
}
