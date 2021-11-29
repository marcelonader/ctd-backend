package dev.nader.clinica_odontologica_checkpoint_2.persistence.repository;

import dev.nader.clinica_odontologica_checkpoint_2.persistence.entities.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPatientRepository extends JpaRepository<PatientEntity, Integer> {
}
