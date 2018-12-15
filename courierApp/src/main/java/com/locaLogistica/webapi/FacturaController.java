package com.locaLogistica.webapi;

import com.locaLogistica.core.Factura;
import com.locaLogistica.core.Paquete;
import com.locaLogistica.repository.FacturaRepository;
import com.locaLogistica.repository.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/factura")
public class FacturaController {

    @Autowired
    FacturaRepository repo;
    @Autowired
    PaqueteRepository paqRepo;

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Optional<Factura> findById(@PathVariable Long id) {
        return repo.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Factura> findAll() {
        return repo.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String crearFactura(@RequestBody  Factura factura) {
        Paquete paq = paqRepo.findByIdCourier(factura.getPaquete().getIdCourier());
        if(paq == null) return "No hay un paquete con el id del courier dado.";
        factura.setPaquete(paq);
        repo.save(factura);
        paq.setVueloAsignado(obtenerFechaProximoVuelo());
        paqRepo.save(paq);
        return "Factura creada con éxito, el paquete salrá en el vuelo de mañana.";
    }

    @RequestMapping(method= RequestMethod.PATCH)
    public ResponseEntity modificarPaquete(@RequestBody Factura factura){
        repo.save(factura);
        return new ResponseEntity(HttpStatus.OK);
    }

    private String obtenerFechaProximoVuelo(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        return "" + cal.get(Calendar.YEAR) + (cal.get(Calendar.MONTH) + 1) + (cal.get(Calendar.DAY_OF_MONTH) + 1);
    }
}
