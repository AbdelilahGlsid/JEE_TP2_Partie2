package ma.enset.tp2_hospital_partie2.repositories;

import ma.enset.tp2_hospital_partie2.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    Medecin findByNom(String nom);
}
