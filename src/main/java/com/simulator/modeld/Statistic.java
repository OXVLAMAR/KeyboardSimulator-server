package com.simulator.modeld;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.*;

@Entity
@Table(name = "statistic")
public class Statistic {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "exercise_time")
    private String exercise_time;
    @Column(name = "num_of_mistakes")
    private int num_of_mistakes;
    @Column(name = "pressing_time")
    private int pressing_time;
    @Column(name = "speed")
    private int speed;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="e_id", nullable = false )
    private Exercise exercise;


    @JsonProperty("e_id")
    private void unpackNestedE(Long id) {
        this.exercise = new Exercise();
        exercise.setId(id);
    }

    public Long getE_id() { return exercise.getId(); }

    public void setE_id(Exercise exercise) {
        this.exercise = exercise;
    }


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="u_id", nullable = false )
    private UserKS userKS;


    @JsonProperty("u_id")
    private void unpackNestedU(Long id) {
        this.userKS = new UserKS();
        userKS.setId(id);
    }

    public Long getU_id() { return userKS.getId(); }

    public void setU_id(UserKS userKS) {
        this.userKS = userKS;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getExercise_time() {
        return exercise_time;
    }

    public void setExercise_time(String exercise_time) {
        this.exercise_time = exercise_time;
    }

    public int getNum_of_mistakes() {
        return num_of_mistakes;
    }

    public void setNum_of_mistakes(int num_of_mistakes) {
        this.num_of_mistakes = num_of_mistakes;
    }

    public int getPressing_time() {
        return pressing_time;
    }

    public void setPressing_time(int pressing_time) {
        this.pressing_time = pressing_time;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
