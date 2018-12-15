package com.locaLogistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.locaLogistica.core.Paquete;

import java.util.List;

public interface PaqueteRepository extends JpaRepository<Paquete, Long> {
    List<Paquete> findByVueloAsignado(String nombreVuelo);
    List<Paquete> findByNumCuentaConsignatario(String numCuenta);
    Paquete findByIdCourier(String idCourier);
}
