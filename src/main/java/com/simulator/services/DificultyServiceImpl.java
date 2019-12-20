package com.simulator.services;

import com.simulator.model.Dificulty;
import com.simulator.repositories.DiffKeyRepository;
import com.simulator.repositories.DificultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DificultyServiceImpl implements DificultyService {

    private static DificultyRepository dificultyRepository;

    @Autowired
    public DificultyServiceImpl(DificultyRepository dificultyRepository) {
        this.dificultyRepository = dificultyRepository;

    }

    @Override
    public List<Dificulty> listAll() {
        List<Dificulty> dificulty = new ArrayList<>();
        dificultyRepository.findAll().forEach(dificulty::add);
        return dificulty;
    }


    public static Dificulty getD(Long id) {
        return dificultyRepository.findById(id).orElse(null);
    }

    public static Dificulty createD(Dificulty dificulty) {
        return dificultyRepository.save(dificulty);
    }

    @Override
    public Dificulty getById(Long id) {
        return dificultyRepository.findById(id).orElse(null);
    }

    @Override
    public Dificulty create(Dificulty dificulty) {
        return dificultyRepository.save(dificulty);
    }

    public static Dificulty delete(Long id) {
        dificultyRepository.deleteById(id);
        return null;
    }

    @Override
    public Dificulty saveOrUpdate(Dificulty dificulty) {
        return dificultyRepository.save(dificulty);
    }
}
