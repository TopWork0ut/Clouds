package com.example.lab5.repository;

import com.example.lab5.domain.Sportsman;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SportsmanRepository extends JpaRepository<Sportsman, Integer> {
    List<Sportsman> findBySurname(String surname);

    @Modifying()
    @Query("DELETE FROM Sportsman sportsman WHERE sportsman.id=?1")
    void deleteById(Integer id);
}
