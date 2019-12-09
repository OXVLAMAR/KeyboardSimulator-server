package com.simulator.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "keyboard_area")
public class KeybArea {


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "description")
    private String description;


    @OneToMany(mappedBy = "keyboard_area", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
