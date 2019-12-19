package com.simulator.controllers;

import com.simulator.model.DiffKey;
import com.simulator.model.Dificulty;
import com.simulator.model.KeybArea;
import com.simulator.services.DifKeyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping({"/diff_key"})
@RestController
public class DiffKeyController {


    private DifKeyService difKeyService;


    @Autowired
    public void setDiffKey(DifKeyService difKeyService) {
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
    @GetMapping(path = "setdif/{diff}/{kArea1}/{kArea2}/{kArea3}/{kArea4}")
    public Dificulty saveOrUpdate(@PathVariable("diff") Dificulty diff, @PathVariable("kArea1") KeybArea keyboardArea1, @PathVariable("kArea2") KeybArea keyboardArea2,@PathVariable("kArea3") KeybArea keyboardArea3, @PathVariable("kArea4") KeybArea keyboardArea4) {
        List<KeybArea> keyboardArea = new ArrayList<>();
        keyboardArea.add(keyboardArea1);
        keyboardArea.add(keyboardArea2);
        keyboardArea.add(keyboardArea3);
        keyboardArea.add(keyboardArea4);
        return  difKeyService.saveOrUpdate(diff,keyboardArea);
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "getZone/{diff_id}")
    public List<KeybArea> getKeyZone(@PathVariable("diff_id") Long id)
    {
         return difKeyService.getKeyboardZone(id);
    }

}
