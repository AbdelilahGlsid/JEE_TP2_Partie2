package ma.enset.tp2_hospital_partie2.repositories;

import ma.enset.tp2_hospital_partie2.entities.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepository extends JpaRepository<Consultation,Long> {
}
