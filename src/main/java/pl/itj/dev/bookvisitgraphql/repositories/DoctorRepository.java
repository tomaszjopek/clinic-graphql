package pl.itj.dev.bookvisitgraphql.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.itj.dev.bookvisitgraphql.model.ety.Doctor;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
}