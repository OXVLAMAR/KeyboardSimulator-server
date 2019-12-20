package com.simulator.services;

import com.simulator.model.DiffKey;
import com.simulator.model.Dificulty;
import com.simulator.model.KeybArea;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;

public interface DifKeyService {
    List<DiffKey> listAll();

    DiffKey getById(Long id);

    DiffKey create(DiffKey diffKey);

    DiffKey delete(Long id);

    Dificulty saveOrUpdate(Long diff_id, String title, int max_length,int min_length, int mistakes, int pressing_time,List<KeybArea> keyzone);

    List<KeybArea> getKeyboardZone(Long diff_id);
}
