package com.locaLogistica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.locaLogistica.core.Prealerta;

public interface PrealertaRepository extends JpaRepository<Prealerta, Long>  {
    Prealerta findByIdCourier(String idCourier);
}
