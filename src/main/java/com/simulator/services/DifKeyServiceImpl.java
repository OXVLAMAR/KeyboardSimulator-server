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
    public Dificulty saveOrUpdate(Long diff_id, String title, int max_length,int min_length, int mistakes, int pressing_time,List<KeybArea> keyzone)
    {
        List<DiffKey> diffKey = new ArrayList<>();
        diffKeyRepository.findAll().forEach(diffKey::add);
        int c = 1;
        Long h = 1L;
        boolean flag = false;
        while (c < diffKey.size()) {
           for (int i =0; i<keyzone.size(); i++)
           {
               if((diffKey.get(c).getDiff_id() ==diff_id) && (diffKey.get(c).getKeybArea_id() == keyzone.get(i).getId())){
                   flag = true;
               }

           }
            if((diffKey.get(c).getDiff_id() ==diff_id)&& (flag!=true)){
                diffKeyRepository.delete(diffKey.get(c));
            }
            flag = false;
            c++;
        }
        c=0;
        while (h <= keyzone.size()) {
            for (int i =0; i<diffKey.size(); i++)
            {
                if((diffKey.get(i).getDiff_id() ==diff_id) && (diffKey.get(i).getKeybArea_id() == keyzone.get(c).getId())){
                    flag = true;
                }

            }
            if(flag!=true){
                DiffKey newD = new DiffKey();
                newD.setDiff_id(DificultyServiceImpl.getD(diff_id));
                newD.setKeybArea_id(keyzone.get(c));
                diffKeyRepository.save(newD);
            }
            flag = false;
            c++;
            h++;
        }
        DificultyServiceImpl.getD(diff_id).setMin_length(min_length);
        DificultyServiceImpl.getD(diff_id).setMax_length(max_length);
        DificultyServiceImpl.getD(diff_id).setMax_num_of_mistakes(mistakes);
        DificultyServiceImpl.getD(diff_id).setPressing_time(pressing_time);
        DificultyServiceImpl.getD(diff_id).setTitle(title);
       return DificultyServiceImpl.createD(DificultyServiceImpl.getD(diff_id));
    }


    @Override
    public List<KeybArea> getKeyboardZone(Long diff_id) {

        int c = 0;
        List<KeybArea> keyb_area = new ArrayList<>();
        List<DiffKey> diffKey = new ArrayList<>();
        diffKeyRepository.findAll().forEach(diffKey::add);
        while (c < diffKey.size()) {
            if (diffKey.get(c).getDiff_id() == diff_id) {
                keyb_area.add(KeybAreaServiceImpl.getK(diffKey.get(c).getKeybArea_id()));
            }

            c++;
        }

        return keyb_area;
    }


}
