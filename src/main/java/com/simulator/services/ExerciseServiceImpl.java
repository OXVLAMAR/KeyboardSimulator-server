package com.simulator.services;
import com.simulator.modeld.Exercise;
import com.simulator.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ExerciseServiceImpl implements ExerciseService {

    private ExerciseRepository exerciseRepository;
    //   private ExerciseFormToWarehouse productFormToProduct;

    @Autowired
    public ExerciseServiceImpl(ExerciseRepository exerciseRepository) {
        this.exerciseRepository = exerciseRepository;

    }

    @Override
    public List<Exercise> listAll() {
        List<Exercise> exercises = new ArrayList<>();
        exerciseRepository.findAll().forEach(exercises::add);
        return exercises;
    }

    @Override
    public Exercise getById(Long id) {
        return exerciseRepository.findById(id).orElse(null);
    }

    @Override
    public Exercise create(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    @Override
    public Exercise delete(Long id) {
        exerciseRepository.deleteById(id);
        return null;
    }
    @Override
    public Exercise saveOrUpdate(Exercise exercise)
    {
        return exerciseRepository.save(exercise);
    }

}
