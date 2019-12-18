package com.simulator.services;

import com.simulator.model.DiffKey;
import com.simulator.model.KeybArea;


import java.util.List;

public interface DifKeyService {
    List<DiffKey> listAll();

    DiffKey getById(Long id);

    DiffKey create(DiffKey diffKey);

    DiffKey delete(Long id);

    DiffKey saveOrUpdate(DiffKey diffKey);

    List<KeybArea> getKeyboardZone(Long diff_id);
}
