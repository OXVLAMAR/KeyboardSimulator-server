package com.simulator.services;

import com.simulator.model.AllStatistic;
import com.simulator.model.Statistic;
import com.simulator.model.UserKS;
import com.simulator.repositories.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
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
    public List<AllStatistic>  listAllAdmin() {
        List<Statistic> statistics = new ArrayList<>();
        List<Long> num_ex = new ArrayList<>();
        List<AllStatistic> all_st = new ArrayList<>();
        statisticRepository.findAll().forEach(statistics::add);
       int i= 0;
       int j = 0;
       while(i < statistics.size())
       {
           if(!num_ex.contains(statistics.get(i).getExercise_id())) {
               num_ex.add(statistics.get(i).getExercise_id());
           }

           i++;
       }
         Long id = 0L;
         int exercise_time = 0;
         int num_of_mistakes = 0;
         int speed = 0;
         int count = 0;

        while(j < num_ex.size())
        {
            AllStatistic allst = new AllStatistic();
            for (int k = 0; k < statistics.size(); k++){
                if(num_ex.get(j).equals(statistics.get(k).getExercise_id())) {
                    exercise_time += statistics.get(k).getExercise_time();
                    num_of_mistakes += statistics.get(k).getNum_of_mistakes();
                    speed += statistics.get(k).getSpeed();
                    count++;
                }
            }
            double ec = exercise_time/count+0.5;
            double mc = (num_of_mistakes/count)+0.5;
            double sc = speed/count+0.5;
            allst.setId(num_ex.get(j));
            allst.setCount(count);
            allst.setExercise_time((int)ec);
            allst.setNum_of_mistakes((int)mc);
            allst.setSpeed((int)sc);
            all_st.add(allst);
            j++;
             exercise_time = 0;
             num_of_mistakes = 0;
             speed = 0;
             count = 0;
        }
        return all_st;
    }

    @Override
    public Statistic getById(Long id) {
        return statisticRepository.findById(id).orElse(null);
    }

    @Override
    public ArrayList<Statistic> getStUS(Long id, List<Statistic> st) {
        ArrayList<Statistic> result = new ArrayList<>();
        for (int i = 0; i < st.size(); i++) {
            if (id.equals(st.get(i).getUser_id())) {
                result.add(st.get(i));
            }
        }
        return result;
    }


    @Override
    public Statistic create(Statistic statistic)
    {
        java.sql.Timestamp myDate = new java.sql.Timestamp(System.currentTimeMillis());
        statistic.setDate(myDate);
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


