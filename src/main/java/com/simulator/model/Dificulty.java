package com.simulator.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "dificulty_lvl")
public class Dificulty {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "title")
    private String title;
    @Column(name = "max_length")
    private int max_length;
    @Column(name = "min_length")
    private int min_length;
    @Column(name = "max_num_of_mistakes")
    private int max_num_of_mistakes;
    @Column(name = "pressing_time")
    private int pressing_time;

    @OneToMany(mappedBy = "dificulty_lvl", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<UserKS> users = new ArrayList<>();

    public List<UserKS> getUsers() {
        return users;
    }

    public void setUsers() {
        this.users = users;
    }

    @OneToMany(mappedBy = "dificulty_lvl", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Exercise> exercise = new ArrayList<>();


    public List<Exercise> getExercise() {
        return exercise;
    }

    public void setExercise() {
        this.exercise = exercise;
    }

    @OneToMany(mappedBy = "dificulty_lvl", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<DiffKey> diffKey = new ArrayList<>();


    public List<DiffKey> getDiffKey() {
        return diffKey;
    }

    public void setDiffKey() {
        this.diffKey = diffKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getMax_length() {
        return max_length;
    }

    public void setMax_length(int max_length) {
        this.max_length = max_length;
    }

    public int getMin_length() {
        return min_length;
    }

    public void setMin_length(int min_length) {
        this.min_length = min_length;
    }

    public int getMax_num_of_mistakes() {
        return max_num_of_mistakes;
    }

    public void setMax_num_of_mistakes(int max_num_of_mistakes) {
        this.max_num_of_mistakes = max_num_of_mistakes;
    }

    public int getPressing_time() {
        return pressing_time;
    }

    public void setPressing_time(int pressing_time) {
        this.pressing_time = pressing_time;
    }
}
