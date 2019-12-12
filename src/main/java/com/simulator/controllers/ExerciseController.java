package com.simulator.controllers;

import com.simulator.model.Exercise;
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


    @GetMapping
    public List<Exercise> listExercise(long id_diff_lvl) {
        return exerciseService.listAllid(id_diff_lvl);
    }

    @GetMapping(path = "/{id}")
    public Exercise getExercise(@PathVariable("id") Long id) {
        return exerciseService.getById(Long.valueOf(id));
    }


    @PutMapping
    public Exercise saveOrUpdate(@RequestBody Exercise exercise) {

        return exerciseService.saveOrUpdate(exercise);
    }

    @PostMapping (path = {"/newExercise"})
    public Exercise newExercise(@RequestBody Exercise exercise) {
        return exerciseService.create(exercise);
    }

    @PostMapping (path = {"/generate"})
    public Exercise generateExercise(@RequestBody Exercise exercise) {
        return exerciseService.generate(exercise);
    }

    @DeleteMapping(path = "/{id}")
    public Exercise delete(@PathVariable("id") Long id) {
        return exerciseService.delete(Long.valueOf(id));
    }
}

