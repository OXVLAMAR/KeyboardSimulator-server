package com.simulator.controllers;


import com.simulator.model.Statistic;
import com.simulator.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping({"/statistic"})
@RestController
public class StatisticController {

    private StatisticService statisticService;

    @Autowired
    public void setStatisticService(StatisticService statisticService) {
        this.statisticService = statisticService;
    }


    @GetMapping
    public List<Statistic> listStatistic() {
        return statisticService.listAll();
    }

    @GetMapping(path = "/{id}")
    public Statistic getStatistic(@PathVariable("id") Long id) {
        return statisticService.getById(Long.valueOf(id));
    }


    @PutMapping
    public Statistic saveOrUpdate(@RequestBody Statistic statistic) {
        return statisticService.saveOrUpdate(statistic);
    }

    @PostMapping
    public Statistic newStatistic(@RequestBody Statistic statistic) {
        return statisticService.create(statistic);
    }

    @DeleteMapping(path = "/{id}")
    public Statistic delete(@PathVariable("id") Long id) {
        return statisticService.delete(Long.valueOf(id));
    }


}


