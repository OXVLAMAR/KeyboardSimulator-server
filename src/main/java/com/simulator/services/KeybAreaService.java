package com.simulator.services;

import com.simulator.model.KeybArea;


import java.util.List;

public interface KeybAreaService {

    List<KeybArea> listAll();

    KeybArea getById(Long id);

    KeybArea create(KeybArea keyb_area);

    KeybArea delete(Long id);

    KeybArea saveOrUpdate(KeybArea keyb_area);
}
