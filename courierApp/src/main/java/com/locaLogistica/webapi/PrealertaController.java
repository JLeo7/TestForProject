package com.locaLogistica.webapi;

import com.locaLogistica.core.Prealerta;
import com.locaLogistica.repository.PrealertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/prealerta")
public class PrealertaController {

    @Autowired
    PrealertaRepository repo;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Prealerta> findAll() {
        return repo.findAll();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Optional<Prealerta> findById(@PathVariable Long id) {
        return repo.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity crearPrealerta(@RequestBody  Prealerta prealerta) {
        repo.save(prealerta);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method= RequestMethod.PATCH)
    public ResponseEntity modificarPaquete(@RequestBody Prealerta prealerta){
        repo.save(prealerta);
        return new ResponseEntity(HttpStatus.OK);
    }
}
