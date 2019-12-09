package com.simulator.services;


import com.simulator.model.Dificulty;

import java.util.List;

public interface DificultyService {

    List<Dificulty> listAll();

    Dificulty getById(Long id);

    Dificulty create(Dificulty difficulty);

    Dificulty delete(Long id);

    Dificulty saveOrUpdate(Dificulty difficulty);
}
