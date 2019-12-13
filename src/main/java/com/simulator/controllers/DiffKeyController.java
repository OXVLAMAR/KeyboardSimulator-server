package com.simulator.controllers;

import com.simulator.model.DiffKey;
import com.simulator.services.DifKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping({"/diff_key"})
@RestController
public class DiffKeyController {


    private DifKeyService difKeyService;


    @Autowired
    public void setDiffKey(DifKeyService dificultyService) {
        this.difKeyService = difKeyService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<DiffKey> listDiffKey() {
        return difKeyService.listAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public DiffKey getDiffKey(@PathVariable("id") Long id) {
        return difKeyService.getById(Long.valueOf(id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public DiffKey saveOrUpdate(@RequestBody DiffKey diffKey) {

        return difKeyService.saveOrUpdate(diffKey);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public DiffKey newDiffKey(@RequestBody DiffKey diffKey) {
        return difKeyService.create(diffKey);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    public DiffKey delete(@PathVariable("id") Long id) {
        return difKeyService.delete(Long.valueOf(id));
    }
}
