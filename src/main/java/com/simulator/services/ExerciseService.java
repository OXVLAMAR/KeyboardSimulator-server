package com.simulator.services;


import com.simulator.model.Exercise;

import java.util.List;


public interface ExerciseService {

    List<Exercise> listAll();

    List<Exercise> listAllid(Long id);

    Exercise getById(Long id);

    Exercise create(String textF, String textE, Long diff_id);

    Exercise generate(Long dif);

    Exercise delete(Long id);

    Exercise saveOrUpdate(Exercise exercise);




}
