package com.simulator.controllers;


import com.simulator.model.AllStatistic;
import com.simulator.model.Statistic;
import com.simulator.services.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping
    public List<Statistic> listStatistic() {
        return statisticService.listAll();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/statisticsAdmin")
    public List<AllStatistic> listAllStatistic() {
        return statisticService.listAllAdmin();
    }


    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/statistic/{id}")
    public Statistic getStatistic(@PathVariable("id") Long id) {
        return statisticService.getById(Long.valueOf(id));
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(path = "/{user_id}")
    public ArrayList<Statistic> getStatistic_UserID(@PathVariable("user_id") Long user_id)  {
        return statisticService.getStUS(user_id, statisticService.listAll());
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PutMapping
    public Statistic saveOrUpdate(@RequestBody Statistic statistic) {
        return statisticService.saveOrUpdate(statistic);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public Statistic newStatistic(@RequestBody Statistic statistic) {
        return statisticService.create(statistic);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping(path = "/{id}")
    public Statistic delete(@PathVariable("id") Long id) {
        return statisticService.delete(Long.valueOf(id));
    }


}


