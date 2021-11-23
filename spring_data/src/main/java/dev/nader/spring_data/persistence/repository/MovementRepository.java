package dev.nader.spring_data.persistence.repository;

import dev.nader.spring_data.persistence.entities.MovementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<MovementEntity, Integer> {
}
