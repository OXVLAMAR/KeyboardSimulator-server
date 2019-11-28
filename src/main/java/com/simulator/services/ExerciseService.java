package com.simulator.services;


import com.simulator.modeld.Exercise;

import java.util.List;


public interface ExerciseService {

    List<Exercise> listAll();

    Exercise getById(Long id);

    Exercise create(Exercise exercise);

    Exercise delete(Long id);

    Exercise saveOrUpdate(Exercise exercise);
}
