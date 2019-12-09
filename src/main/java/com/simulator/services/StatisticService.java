package com.simulator.services;

import com.simulator.model.Statistic;

import java.util.List;

public interface StatisticService {

    List<Statistic> listAll();

    Statistic getById(Long id);

    Statistic create(Statistic statistic);

    Statistic delete(Long id);

    Statistic saveOrUpdate(Statistic statistic);

}


