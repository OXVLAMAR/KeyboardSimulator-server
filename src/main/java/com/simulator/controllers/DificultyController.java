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


    @GetMapping
    public List<Dificulty> listDificulty() {
        return dificultyService.listAll();
    }

    @GetMapping(path = "/{id}")
    public Dificulty getDificulty(@PathVariable("id") Long id) {
        return dificultyService.getById(Long.valueOf(id));
    }


    @PutMapping
    public Dificulty saveOrUpdate(@RequestBody Dificulty dificulty) {

        return dificultyService.saveOrUpdate(dificulty);
    }

    @PostMapping
    public Dificulty newDificulty(@RequestBody Dificulty dificulty) {
        return dificultyService.create(dificulty);
    }


    @DeleteMapping(path = "/{id}")
    public Dificulty delete(@PathVariable("id") Long id) {
        return dificultyService.delete(Long.valueOf(id));
    }
}
