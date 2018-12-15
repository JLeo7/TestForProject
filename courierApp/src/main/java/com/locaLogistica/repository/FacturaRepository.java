package com.locaLogistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.locaLogistica.core.Factura;

public interface FacturaRepository extends JpaRepository<Factura, Long>  {
}
