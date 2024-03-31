package ma.enset.tp2_hospital_partie2.repositories;

import ma.enset.tp2_hospital_partie2.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient findByNom(String nom);
}
