package com.simulator.controllers;

import com.simulator.model.DiffKey;
import com.simulator.model.KeybArea;
import com.simulator.services.KeybAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping({"/keyboard_area"})
@RestController
public class KeybAreaController {

    private KeybAreaService keyb_areaService;


    @Autowired
    public void setKeybAreaService(KeybAreaService keyb_areaService) {
        this.keyb_areaService = keyb_areaService;
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<KeybArea> listKeybArea() {
        return keyb_areaService.listAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id}")
    public KeybArea getKeybArea(@PathVariable("id") Long id) {
        return keyb_areaService.getById(Long.valueOf(id));
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public KeybArea saveOrUpdate(@RequestBody KeybArea keyb_area) {

        return keyb_areaService.saveOrUpdate(keyb_area);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public KeybArea newKeybArea(@RequestBody KeybArea keyb_area) {
        return keyb_areaService.create(keyb_area);
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    public KeybArea delete(@PathVariable("id") Long id) {
        return keyb_areaService.delete(Long.valueOf(id));
    }



}
