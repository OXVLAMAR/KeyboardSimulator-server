package com.simulator.services;


import com.simulator.model.Exercise;

import java.util.List;


public interface ExerciseService {

    List<Exercise> listAll();

    List<Exercise> listAllid(Long id);

    Exercise getById(Long id);

    Exercise create(Exercise exercise);

    Exercise generate(Long dif);

    Exercise delete(Long id);

    Exercise saveOrUpdate(Exercise exercise);


}
