package pl.itj.dev.bookvisitgraphql.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.itj.dev.bookvisitgraphql.model.ety.Patient;

public interface PatientRepository extends JpaRepository<Patient, UUID> {}
