package com.simulator.modeld;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "exercise")
public class Exercise {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
    private List<Statistic> statistics = new ArrayList<>();

    @Column(name = "text")
    private String text;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }


    public List<Statistic> getStatistic() {
        return statistics;
    }

    public void setStatistic()
    {
        this.statistics = statistics;
    }

    }




