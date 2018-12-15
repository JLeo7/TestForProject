package com.locaLogistica.webapi;

import com.locaLogistica.core.Paquete;
import com.locaLogistica.repository.PaqueteRepository;
import com.locaLogistica.repository.PrealertaRepository;
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
@RequestMapping("/paquete")
public class PaqueteController {

    @Autowired
    PaqueteRepository repo;
    @Autowired
    PrealertaRepository paRepo;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Optional<Paquete> findById(@PathVariable Long id) {
        return repo.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Paquete> findAll() {
        return repo.findAll();
    }

    @RequestMapping(value ="/proximoVuelo", method = RequestMethod.GET)
    @ResponseBody
    public List<Paquete> findByVueloAsignado() {
        return repo.findByVueloAsignado(obtenerFechaProximoVuelo());
    }

    @RequestMapping(value ="/retenidos", method = RequestMethod.GET)
    @ResponseBody
    public List<Paquete> findAwaitingPackages() {
        return repo.findByVueloAsignado("");
    }

    @RequestMapping(value ="/cuenta/", method = RequestMethod.GET)
    @ResponseBody
    public List<Paquete> findByVueloAsignado(@RequestParam(value = "numCuenta")String numCuenta) {
        return repo.findByNumCuentaConsignatario(numCuenta);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity crearPaquete(@RequestBody Paquete paquete) {
        paquete.setFechaRecibido(new Date());
        paquete.setVueloAsignado("");
        if (paRepo.findByIdCourier(paquete.getIdCourier()) != null) asignarNombreVuelo(paquete);
        repo.save(paquete);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public ResponseEntity modificarPaquete(@RequestBody Paquete paquete) {
        repo.save(paquete);
        return new ResponseEntity(HttpStatus.OK);
    }

    private void asignarNombreVuelo(Paquete paquete) {
        paquete.setVueloAsignado(obtenerFechaProximoVuelo());
    }

    private String obtenerFechaProximoVuelo(){
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        return "" + cal.get(Calendar.YEAR) + (cal.get(Calendar.MONTH) + 1) + (cal.get(Calendar.DAY_OF_MONTH) + 1);
    }
}
