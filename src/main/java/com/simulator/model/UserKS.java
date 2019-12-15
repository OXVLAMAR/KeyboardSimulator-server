package com.simulator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "userKS")
public class UserKS {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "userKS", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Statistic> statistics = new ArrayList<>();

    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "type_of_access")
    private String type_of_access;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "dif_id", nullable = false)
    private Dificulty dificulty_lvl;

    @JsonProperty(value="diff_id")
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

    public List<Statistic> getStatistic() {
        return statistics;
    }

    public void setStatistic() {
        this.statistics = statistics;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType_of_access() {
        return type_of_access;
    }

    public void setType_of_access(String type_of_access) {
        this.type_of_access = type_of_access;
    }

}


