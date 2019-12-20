package com.simulator.services;

import com.simulator.model.Dificulty;
import com.simulator.model.Exercise;
import com.simulator.repositories.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


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
    public List<Exercise> listAllid(Long id) {
        List<Exercise> exercises = new ArrayList<>();
        List<Exercise> exfinals = new ArrayList<>();
        exerciseRepository.findAll().forEach(exercises::add);
        for (int i =0; i< exercises.size(); i++)
        {
            if (id.equals(exercises.get(i).getDiff_id())){
                exfinals.add(exercises.get(i));
            }
        }
        return exfinals;
    }

    @Override
    public Exercise getById(Long id) {
        return exerciseRepository.findById(id).orElse(null);
    }

    @Override
    public Exercise create(String textF, String textE, Long diff_id) {
        Exercise exercise = new Exercise();
        exercise.setTextF(textF);
        exercise.setTextE(textE);
        exercise.setDiff_id(DificultyServiceImpl.getD(diff_id));
        String full = exercise.getTextE() + exercise.getTextF();
        Dificulty dif = DificultyServiceImpl.getD(exercise.getDiff_id());
        if (dif.getMin_length() > full.length() ||
                full.length() > dif.getMax_length()) {
                throw new IllegalArgumentException("Неверная длина упражнения");
        } else {
            char [] fulltext  = full.toCharArray();
            String zone = " ";
            for (int j = 0; j< dif.getDiffKey().size();j++ ){
                zone += KeybAreaServiceImpl.getK(dif.getDiffKey().get(j).getKeybArea_id()).getDescription();
            }

            for (int i = 0; i< fulltext.length;i++ ){
                if (zone.indexOf(fulltext[i])<0) {
                    throw new IllegalArgumentException("Символ не входит в текущие зоны клавиатуры");
                }
            }
        }

        return exerciseRepository.save(exercise);
    }

    @Override
    public Exercise generate(Long dif) {
        Random random = new Random();
        Exercise exercise = new Exercise();
        int count = 0;
        String textF = "";
        String textE = "";
        Dificulty dif_lvl =  DificultyServiceImpl.getD(dif);
        exercise.setDiff_id(dif_lvl);
        StringBuilder sb = new StringBuilder(dif_lvl.getMax_length());
        String zone = "";
        for (int j = 0; j< dif_lvl.getDiffKey().size();j++ ){
            zone += KeybAreaServiceImpl.getK(dif_lvl.getDiffKey().get(j).getKeybArea_id()).getDescription();
        }
        while (count < dif_lvl.getMax_length()) {
            char[] word = new char[random.nextInt(3) + 3]; // words of length
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) (zone.charAt(random.nextInt(zone.length())));
                if (count < dif_lvl.getMax_length()) {
                    if (textF.length()<= 251) {
                        textF += word[j];
                        count++;
                    }  else {
                        textE += word[j];
                        count++;
                    }
                }
            }
            if (count < dif_lvl.getMax_length()) {
                if (textF.length()<= 251) {
                    textF += " ";
                    count++;
                }  else {
                    textE += " ";
                    count++;
                }
            }
        }
        exercise.setTextF(textF);
        exercise.setTextE(textE);
        return exercise;
    }

    @Override
    public Exercise delete(Long id) {
        exerciseRepository.deleteById(id);
        return null;
    }

    @Override
    public Exercise saveOrUpdate(Exercise exercise) {
        String full = exercise.getTextE() + exercise.getTextF();
        Dificulty dif = DificultyServiceImpl.getD(exercise.getDiff_id());
        if (dif.getMin_length() > full.length() ||
                full.length() > dif.getMax_length()) {
             throw new IllegalArgumentException("Неверная длина упражнения");
        } else {
            char [] fulltext  = full.toCharArray();
            String zone = " ";
            for (int j = 0; j< dif.getDiffKey().size();j++ ){
                zone += KeybAreaServiceImpl.getK(dif.getDiffKey().get(j).getKeybArea_id()).getDescription();
            }

            for (int i = 0; i< fulltext.length;i++ ){
                if (zone.indexOf(fulltext[i])<0) {
                   throw new IllegalArgumentException("Символ не входит в текущие зоны клавиатуры");
                }
            }
        }
        return exerciseRepository.save(exercise);
    }

}
