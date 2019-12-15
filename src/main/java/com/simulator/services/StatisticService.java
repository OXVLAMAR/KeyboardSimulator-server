package com.simulator.services;

import com.simulator.model.Statistic;

import java.util.ArrayList;
import java.util.List;

public interface StatisticService {

    List<Statistic> listAll();

    ArrayList<Statistic> getStUS(Long id, List<Statistic> st);

    Statistic getById(Long id);

    Statistic create(Statistic statistic);

    Statistic delete(Long id);

    Statistic saveOrUpdate(Statistic statistic);


}


