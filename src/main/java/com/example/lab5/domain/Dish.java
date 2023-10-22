package com.example.lab5.domain;


import jakarta.persistence.*;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "components")
    private String components;
    @Basic
    @Column(name = "calories")
    private Integer calories;
    @Basic
    @Column(name = "manufacturer")
    private String manufacturer;
    @Basic
    @Column(name = "production_date")
    private Date productionDate;
    @Basic
    @Column(name = "consumption_date")
    private Date consumptionDate;
    @ManyToMany(mappedBy = "dishes")
    private Set<Schedule> schedules;

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

    public String getComponents() {
        return components;
    }

    public void setComponents(String components) {
        this.components = components;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(Date productionDate) {
        this.productionDate = productionDate;
    }

    public Date getConsumptionDate() {
        return consumptionDate;
    }

    public void setConsumptionDate(Date consumptionDate) {
        this.consumptionDate = consumptionDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(id, dish.id) && Objects.equals(name, dish.name) && Objects.equals(components, dish.components) && Objects.equals(calories, dish.calories) && Objects.equals(manufacturer, dish.manufacturer) && Objects.equals(productionDate, dish.productionDate) && Objects.equals(consumptionDate, dish.consumptionDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, components, calories, manufacturer, productionDate, consumptionDate);
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }
}
