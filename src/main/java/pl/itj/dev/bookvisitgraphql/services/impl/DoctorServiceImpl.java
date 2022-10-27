package pl.itj.dev.bookvisitgraphql.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.itj.dev.bookvisitgraphql.model.ety.Doctor;
import pl.itj.dev.bookvisitgraphql.repositories.DoctorRepository;
import pl.itj.dev.bookvisitgraphql.services.DoctorService;

@Service
@Transactional(readOnly = true)
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    @Transactional
    public Doctor addDoctor(String name, String surname, String email) {
        var newDoctor = new Doctor();
        newDoctor.setName(name);
        newDoctor.setSurname(surname);
        newDoctor.setEmail(email);
        return doctorRepository.save(newDoctor);
    }
}
