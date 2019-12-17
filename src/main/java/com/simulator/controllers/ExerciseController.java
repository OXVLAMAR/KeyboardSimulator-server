package com.simulator.controllers;

import com.simulator.model.Exercise;
import com.simulator.model.UserKS;
import com.simulator.services.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping({"/exercise"})
@RestController

public class ExerciseController {
    private ExerciseService exerciseService;


    @Autowired
    public void setExerciseService(ExerciseService exerciseService) {
        this.exerciseService = exerciseService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Exercise> listExerciseAll() {
        return exerciseService.listAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{id_diff_lvl}")
    public List<Exercise> listExercise(@PathVariable ("id_diff_lvl")  long id_diff_lvl) {
        return exerciseService.listAllid(id_diff_lvl);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "getExercise/{id}")
    public Exercise getExercise(@PathVariable("id") Long id) {
        return exerciseService.getById(Long.valueOf(id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public Exercise saveOrUpdate(@RequestBody Exercise exercise) {
        return exerciseService.saveOrUpdate(exercise);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping (path = {"/newExercise"})
    public Exercise newExercise(@RequestBody String textF, @RequestBody String textE, @RequestBody Long diff_id) {
        return exerciseService.create(textF,textE,diff_id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping (path = {"/generate"})
    public Exercise generateExercise(@RequestBody Long diff_id) {
        return exerciseService.generate(diff_id);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    public List<Exercise> delete(@PathVariable("id") Long id) {
        exerciseService.delete(id);
        return exerciseService.listAll();
    }
}

