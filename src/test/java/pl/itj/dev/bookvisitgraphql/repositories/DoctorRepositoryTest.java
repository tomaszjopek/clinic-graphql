package pl.itj.dev.bookvisitgraphql.repositories;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.itj.dev.bookvisitgraphql.model.ety.Doctor;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class DoctorRepositoryTest {

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    public void testCreateReadDelete() {
        Doctor doctor = new Doctor();
        doctor.setName("Testname");
        doctor.setSurname("Surname");
        doctor.setEmail("test@test.pl");

        doctorRepository.save(doctor);

        Iterable<Doctor> employees = doctorRepository.findAll();
        Assertions.assertThat(employees).extracting(Doctor::getName).contains("Testname");
        Assertions.assertThat(employees).extracting(Doctor::getSurname).contains("Surname");
        Assertions.assertThat(employees).extracting(Doctor::getEmail).contains("test@test.pl");
    }

}