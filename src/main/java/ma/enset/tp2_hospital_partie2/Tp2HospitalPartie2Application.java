package ma.enset.tp2_hospital_partie2;

import ma.enset.tp2_hospital_partie2.entities.*;
import ma.enset.tp2_hospital_partie2.repositories.ConsultationRepository;
import ma.enset.tp2_hospital_partie2.repositories.MedecinRepository;
import ma.enset.tp2_hospital_partie2.repositories.PatientRepository;
import ma.enset.tp2_hospital_partie2.repositories.RendezVousRepository;
import ma.enset.tp2_hospital_partie2.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class Tp2HospitalPartie2Application {

	public static void main(String[] args) {
		SpringApplication.run(Tp2HospitalPartie2Application.class, args);
	}

	@Bean
	CommandLineRunner start(
			IHospitalService hospitalService,
			PatientRepository patientRepository,
			MedecinRepository medecinRepository
	){
		return args -> {
			Stream.of("Mohamed","Hassan","Najat")
					.forEach(name->{
						Patient patient=new Patient();
						patient.setNom(name);
						patient.setDateNaissance(new Date());
						patient.setMalade(false);
						hospitalService.savePatient(patient);
					});
			Stream.of("Ayman","Ahmed","Yasmine")
					.forEach(name->{
						Medecin medecin=new Medecin();
						medecin.setNom(name);
						medecin.setEmail(name+"@gmail.com");
						medecin.setSpecialite(Math.random()>0.5?"Cardio":"Dentist");
						hospitalService.saveMedecin(medecin);
					});

			Patient patient = patientRepository.findById(1L).orElse(null);
			Patient patient1 = patientRepository.findByNom("Mohamed");

			Medecin medecin = medecinRepository.findByNom("Yasmine");

			RendezVous rendezVous = new RendezVous();
			rendezVous.setDate(new Date());
			rendezVous.setStatus(StatusRDV.PENDING);
			rendezVous.setMedecin(medecin);
			rendezVous.setPatient(patient);
			RendezVous rendezVous1 = hospitalService.saveRDV(rendezVous);

			Consultation consultation = new Consultation();
			consultation.setDateConsultation(new Date());
			consultation.setRendezVous(rendezVous1);
			consultation.setRapport("Rapport ..............");
			hospitalService.saveConsultation(consultation);

		};
	}

}
