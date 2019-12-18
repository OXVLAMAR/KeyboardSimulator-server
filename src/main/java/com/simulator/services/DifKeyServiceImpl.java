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
    public void saveOrUpdate(Dificulty diff, List<KeybArea> keyzone)
    {
        List<DiffKey> diffKey = new ArrayList<>();
        diffKeyRepository.findAll().forEach(diffKey::add);
        int c = 0;
        Long h = 0L;
        boolean flag = false;
        while (c < diffKey.size()) {
           for (int i =0; i<keyzone.size(); i++)
           {
               if((diffKey.get(c).getDiff_id() ==diff.getId()) && (diffKey.get(c).getKeybArea_id() == keyzone.get(i).getId())){
                   flag = true;
                   break;
               }

           }
            if(flag!=true){
                diffKeyRepository.delete(diffKey.get(c));
            }
            flag = false;
            c++;
        }
        c=0;
        while (h < keyzone.size()) {
            for (int i =0; i<diffKey.size(); i++)
            {
                if((diffKey.get(i).getDiff_id() ==diff.getId()) && (diffKey.get(i).getKeybArea_id() == keyzone.get(c).getId())){
                    flag = true;
                    break;
                }

            }
            if(flag!=true){
                DiffKey newD = new DiffKey();
                newD.setDiff_id(DificultyServiceImpl.getD(diff.getId()));
                newD.setKeybArea_id(keyzone.get(c));
                diffKeyRepository.save(newD);
            }
            flag = false;
            c++;
            h++;
        }
        DificultyServiceImpl.createD(diff);
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
