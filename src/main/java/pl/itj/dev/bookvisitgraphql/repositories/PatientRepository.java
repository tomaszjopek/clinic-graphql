package pl.itj.dev.bookvisitgraphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itj.dev.bookvisitgraphql.model.ety.Patient;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {



}