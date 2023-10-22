package com.example.lab5.domain;


import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "start_dieting")
    private Date startDieting;
    @Basic
    @Column(name = "end_dieting")
    private Date endDieting;
    @Basic
    @Column(name = "description")
    private String description;
    @OneToMany(mappedBy = "schedule")
    private List<Sportsman> sportsmen;
    @ManyToMany
    @JoinTable(name = "schedule_dish", catalog = "", schema = "sport_supplements", joinColumns = @JoinColumn(name = "schedule_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "dish_id", referencedColumnName = "id", nullable = false))
    private Set<Dish> dishes;
    @ManyToMany
    @JoinTable(name = "schedule_supplement", catalog = "", schema = "sport_supplements", joinColumns = @JoinColumn(name = "schedule_id", referencedColumnName = "id", nullable = false), inverseJoinColumns = @JoinColumn(name = "supplement_id", referencedColumnName = "id", nullable = false))
    private Set<Supplement> supplements;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDieting() {
        return startDieting;
    }

    public void setStartDieting(Date startDieting) {
        this.startDieting = startDieting;
    }

    public Date getEndDieting() {
        return endDieting;
    }

    public void setEndDieting(Date endDieting) {
        this.endDieting = endDieting;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(id, schedule.id) && Objects.equals(startDieting, schedule.startDieting) && Objects.equals(endDieting, schedule.endDieting) && Objects.equals(description, schedule.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startDieting, endDieting, description);
    }

    public List<Sportsman> getSportsmen() {
        return sportsmen;
    }

    public void setSportsmen(List<Sportsman> sportsmen) {
        this.sportsmen = sportsmen;
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(Set<Dish> dishes) {
        this.dishes = dishes;
    }

    public Set<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(Set<Supplement> supplements) {
        this.supplements = supplements;
    }
}
