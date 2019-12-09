package com.simulator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

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

    @OneToMany(mappedBy = "exercise", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Statistic> statistics = new ArrayList<>();

    @Column(name = "textFirst")
    private String textF;

    @Column(name = "textEnd")
    private String textE;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dif_id", nullable = false)
    private Dificulty dificulty_lvl;


    @JsonProperty("dif_id")
    private void unpackNestedDiff(Long id) {
        this.dificulty_lvl = new Dificulty();
        dificulty_lvl.setId(id);
    }

    public Long getDiff_id() {
        return dificulty_lvl.getId();
    }

    public void setDiff_id(Dificulty dificulty) {
        this.dificulty_lvl = dificulty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextF() {
        return textF;
    }

    public void setTextF(String textF) {
        this.textF = textF;
    }
    public String getTextE() {
        return textE;
    }

    public void setTextE(String textE) {
        this.textE = textE;
    }


    public List<Statistic> getStatistic() {
        return statistics;
    }

    public void setStatistic() {
        this.statistics = statistics;
    }

}




