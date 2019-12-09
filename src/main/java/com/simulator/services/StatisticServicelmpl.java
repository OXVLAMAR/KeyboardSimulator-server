package com.simulator.services;

import com.simulator.model.Statistic;
import com.simulator.repositories.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticServicelmpl implements StatisticService {


    private StatisticRepository statisticRepository;


    @Autowired
    public StatisticServicelmpl(StatisticRepository statisticRepository) {
        this.statisticRepository = statisticRepository;

    }

    @Override
    public List<Statistic> listAll() {
        List<Statistic> statistics = new ArrayList<>();
        statisticRepository.findAll().forEach(statistics::add);
        return statistics;
    }

    @Override
    public Statistic getById(Long id) {
        return statisticRepository.findById(id).orElse(null);
    }

    @Override
    public Statistic create(Statistic statistic) {
        return statisticRepository.save(statistic);
    }

    @Override
    public Statistic delete(Long id) {

        statisticRepository.deleteById(id);
        return null;
    }

    @Override
    public Statistic saveOrUpdate(Statistic statistic) {
        return statisticRepository.save(statistic);
    }

}


