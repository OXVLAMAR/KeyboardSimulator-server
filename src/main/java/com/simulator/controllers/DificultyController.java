package com.simulator.controllers;

import com.simulator.model.Dificulty;
import com.simulator.services.DificultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping({"/dificulty_lvl"})
@RestController
public class DificultyController {


    private DificultyService dificultyService;


    @Autowired
    public void setDificulty(DificultyService dificultyService) {
        this.dificultyService = dificultyService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Dificulty> listDificulty() {
        return dificultyService.listAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public Dificulty getDificulty(@PathVariable("id") Long id) {
        return dificultyService.getById(Long.valueOf(id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public Dificulty saveOrUpdate(@RequestBody Dificulty dificulty) {

        return dificultyService.saveOrUpdate(dificulty);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Dificulty newDificulty(@RequestBody Dificulty dificulty) {
        return dificultyService.create(dificulty);
    }

}
