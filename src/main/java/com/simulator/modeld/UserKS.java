package com.simulator.modeld;

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

        @OneToMany(mappedBy = "userKS", cascade = CascadeType.ALL, fetch = FetchType.LAZY,orphanRemoval = true)
        private List<Statistic> statistics = new ArrayList<>();

        @Column(name = "login")
        private String login;
        @Column(name = "password")
        private String password;
        @Column(name = "type_of_access")
        private String type_of_access;


        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public List<Statistic> getStatistic() {
            return statistics;
        }

        public void setStatistic()
        {
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


