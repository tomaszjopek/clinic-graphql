package pl.itj.dev.bookvisitgraphql.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pl.itj.dev.bookvisitgraphql.model.ety.Doctor;
import pl.itj.dev.bookvisitgraphql.repositories.DoctorRepository;

import java.util.List;

@Controller
public class DoctorController {

    private final DoctorRepository doctorRepository;

    public DoctorController(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @QueryMapping
    public List<Doctor> doctors() {
        return doctorRepository.findAll();
    }

}
