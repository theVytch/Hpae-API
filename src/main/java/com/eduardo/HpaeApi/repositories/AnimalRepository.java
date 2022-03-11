package com.eduardo.HpaeApi.repositories;

import com.eduardo.HpaeApi.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
