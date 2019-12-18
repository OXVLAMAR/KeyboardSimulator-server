package com.simulator.services;

import com.simulator.model.Dificulty;
import com.simulator.model.KeybArea;
import com.simulator.repositories.KeybAreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KeybAreaServiceImpl implements KeybAreaService {

    private static KeybAreaRepository keyb_areaRepository;

    public static KeybArea getK(Long id) {
        return keyb_areaRepository.findById(id).orElse(null);
    }

    @Autowired
    public KeybAreaServiceImpl(KeybAreaRepository keyb_areaRepository) {
        this.keyb_areaRepository = keyb_areaRepository;

    }

    @Override
    public List<KeybArea> listAll() {
        List<KeybArea> keyb_area = new ArrayList<>();
        keyb_areaRepository.findAll().forEach(keyb_area::add);
        return keyb_area;
    }

    @Override
    public KeybArea getById(Long id) {
        return keyb_areaRepository.findById(id).orElse(null);
    }

    @Override
    public KeybArea create(KeybArea keyb_area) {
        return keyb_areaRepository.save(keyb_area);
    }

    @Override
    public KeybArea delete(Long id) {
        keyb_areaRepository.deleteById(id);
        return null;
    }

    @Override
    public KeybArea saveOrUpdate(KeybArea keyb_area) {
        return keyb_areaRepository.save(keyb_area);
    }


}
