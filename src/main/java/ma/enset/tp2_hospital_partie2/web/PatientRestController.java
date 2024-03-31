package ma.enset.tp2_hospital_partie2.web;

import ma.enset.tp2_hospital_partie2.entities.Patient;
import ma.enset.tp2_hospital_partie2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> pateintList(){
        return patientRepository.findAll();
    }

}
