package com.simulator.services;

import com.simulator.model.DiffKey;
import com.simulator.model.Dificulty;
import com.simulator.model.KeybArea;
import com.simulator.repositories.DiffKeyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DifKeyServiceImpl implements DifKeyService {

    private DiffKeyRepository diffKeyRepository;


    @Autowired
    public DifKeyServiceImpl(DiffKeyRepository diffKeyRepository) {
        this.diffKeyRepository = diffKeyRepository;
    }

    @Override
    public List<DiffKey> listAll() {
        List<DiffKey> diffKey = new ArrayList<>();
        diffKeyRepository.findAll().forEach(diffKey::add);
        return diffKey;
    }


    @Override
    public DiffKey getById(Long id) {
        return diffKeyRepository.findById(id).orElse(null);
    }

    @Override
    public DiffKey create(DiffKey diffKey) {
        return diffKeyRepository.save(diffKey);
    }

    @Override
    public DiffKey delete(Long id) {
        diffKeyRepository.deleteById(id);
        return null;
    }

    @Override
    public DiffKey saveOrUpdate(DiffKey diffKey) {
        return diffKeyRepository.save(diffKey);
    }


    @Override
    public List<KeybArea> getKeyboardZone(Long diff_id) {
        Long i = 0L;
        int c = 0;
        List<KeybArea> keyb_area = new ArrayList<>();
        List<DiffKey> diffKey = new ArrayList<>();
        diffKeyRepository.findAll().forEach(diffKey::add);
        while (c < diffKey.size()) {
            if (diffKey.get(c).getDiff_id() == diff_id) {
                keyb_area.add(KeybAreaServiceImpl.getK(i));
            }
            i++;
            c++;
        }

        return keyb_area;
    }


}
