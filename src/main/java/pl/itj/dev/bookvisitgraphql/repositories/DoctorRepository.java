package pl.itj.dev.bookvisitgraphql.repositories;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.itj.dev.bookvisitgraphql.model.ety.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {}
