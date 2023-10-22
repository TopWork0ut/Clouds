package com.example.lab5.repository;

import com.example.lab5.domain.Supplement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplementRepository extends JpaRepository<Supplement, Integer> {
    List<Supplement> findByName(String surname);

    @Modifying()
    @Query("DELETE FROM Supplement supplement WHERE supplement.id=?1")
    void deleteById(Integer id);
}
