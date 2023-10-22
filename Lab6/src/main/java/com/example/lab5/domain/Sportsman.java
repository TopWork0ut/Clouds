package com.example.lab5.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Sportsman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "surname")
    private String surname;
    @Basic
    @Column(name = "kind_of_sport")
    private String kindOfSport;
    @Basic
    @Column(name = "height")
    private Integer height;
    @Basic
    @Column(name = "weight")
    private Integer weight;

    @Basic
    @Column(name = "doctor_id")
    private Integer doctor_id;
    @ManyToOne
    @JoinColumn(name = "schedule_id", referencedColumnName = "id", nullable = false)
    private Schedule schedule;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(Integer doctor_id) {
        this.doctor_id = doctor_id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getKindOfSport() {
        return kindOfSport;
    }

    public void setKindOfSport(String kindOfSport) {
        this.kindOfSport = kindOfSport;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }


//    @Override

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sportsman sportsman = (Sportsman) o;
        return Objects.equals(id, sportsman.id) && Objects.equals(name, sportsman.name) && Objects.equals(surname, sportsman.surname) && Objects.equals(kindOfSport, sportsman.kindOfSport) && Objects.equals(height, sportsman.height) && Objects.equals(weight, sportsman.weight) && Objects.equals(doctor_id, sportsman.doctor_id) && Objects.equals(schedule, sportsman.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, kindOfSport, height, weight, doctor_id, schedule);
    }
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Sportsman sportsman = (Sportsman) o;
//        return Objects.equals(id, sportsman.id) && Objects.equals(name, sportsman.name) && Objects.equals(surname, sportsman.surname) && Objects.equals(kindOfSport, sportsman.kindOfSport) && Objects.equals(height, sportsman.height) && Objects.equals(weight, sportsman.weight);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, surname, kindOfSport, height, weight);
//    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}
