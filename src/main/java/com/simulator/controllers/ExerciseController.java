package com.simulator.controllers;

import com.simulator.modeld.Exercise;
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
    public List<Exercise> listExercise(){
        return exerciseService.listAll();
    }

    @GetMapping(path ="/{id}")
    public Exercise getExercise(@PathVariable("id") Long id){
        return  exerciseService.getById(Long.valueOf(id));
    }


    @PutMapping
    public Exercise saveOrUpdate(@RequestBody Exercise exercise)
            {

              return  exerciseService.saveOrUpdate(exercise);
    }

    @PostMapping
    public Exercise newExercise(@RequestBody Exercise exercise)
    {
        return exerciseService.create(exercise);
    }


    @DeleteMapping(path ="/{id}")
    public Exercise delete(@PathVariable("id") Long id){
        return exerciseService.delete(Long.valueOf(id));
    }
}

