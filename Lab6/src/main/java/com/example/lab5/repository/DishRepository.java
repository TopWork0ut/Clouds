package com.example.lab5.repository;

import com.example.lab5.domain.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface DishRepository extends JpaRepository<Dish, Integer> {
    List<Dish> findByName(String surname);

    @Modifying()
    @Query("DELETE FROM Dish dish WHERE dish.id=?1")
    void deleteById(Integer id);

    @Procedure(procedureName = "dishInsertion")
    void dishInsertion(String name, String components, Integer calories, String manufacturer, Date production_date, Date consumption_date);


    @Procedure(procedureName = "scheduleDishInsertion")
    void scheduleDishInsertion(Integer dish_id, Integer schedule_id);

    @Procedure(procedureName = "insertionTenDishes")
    void insertionTenDishes();

    @Procedure(procedureName = "printMinCountOfCalories")
    Integer printMinCountOfCalories();

    @Procedure(procedureName = "createTables")
    void createTables();
}
