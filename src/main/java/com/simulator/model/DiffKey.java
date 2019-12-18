package com.simulator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;


@Entity
@Table(name = "diff_key")
public class DiffKey {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "keyb_area_id", nullable = false)

    private KeybArea keyboard_area;

    @JsonProperty("keyb_area_id")
    private void unpackNestedKeybArea(Long id) {
        this.keyboard_area = new KeybArea();
        keyboard_area.setId(id);
     }

    public Long getKeybArea_id() {
        return keyboard_area.getId();
    }

    public void setKeybArea_id(KeybArea keyboard_area) {
        this.keyboard_area = keyboard_area;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
