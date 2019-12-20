package com.simulator.controllers;

import com.simulator.model.DiffKey;
import com.simulator.model.Dificulty;
import com.simulator.model.KeybArea;
import com.simulator.services.DifKeyService;
import com.simulator.services.DificultyServiceImpl;
import com.simulator.services.KeybAreaServiceImpl;
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
    @GetMapping(path = "/setdif/{diff_id}/{title}/{max_length}/{min_length}/{mistakes}/{pressing_time}/{kArea1}/{kArea2}/{kArea3}/{kArea4}/{kArea5}")
    public Dificulty saveOrUpdate(@PathVariable("diff_id") Long diff_id, @PathVariable("title") String title,@PathVariable("max_length") int max_length,@PathVariable("min_length") int min_length,@PathVariable("mistakes") int mistakes,@PathVariable("pressing_time") int pressing_time,@PathVariable("kArea1") Long keyboardArea1, @PathVariable("kArea2") Long keyboardArea2,@PathVariable("kArea3") Long keyboardArea3, @PathVariable("kArea4") Long keyboardArea4, @PathVariable("kArea5") Long keyboardArea5) {
        List<KeybArea> keyboardArea = new ArrayList<>();
        if ( keyboardArea1 != 0){
            keyboardArea.add(KeybAreaServiceImpl.getK(keyboardArea1));
        }
        if ( keyboardArea2 != 0){
            keyboardArea.add(KeybAreaServiceImpl.getK(keyboardArea2));
        }
        if ( keyboardArea3 != 0){
            keyboardArea.add(KeybAreaServiceImpl.getK(keyboardArea3));
        }if ( keyboardArea4 != 0){
            keyboardArea.add(KeybAreaServiceImpl.getK(keyboardArea4));
        }  if ( keyboardArea5 != 0){
        keyboardArea.add(KeybAreaServiceImpl.getK(keyboardArea5));
    }
        return  difKeyService.saveOrUpdate(diff_id, title, max_length,min_length, mistakes,pressing_time,keyboardArea);
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
