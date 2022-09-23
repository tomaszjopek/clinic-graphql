package pl.itj.dev.bookvisitgraphql.controller;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pl.itj.dev.bookvisitgraphql.model.ety.Patient;
import pl.itj.dev.bookvisitgraphql.repositories.PatientRepository;

import java.util.List;

@Controller
public class PatientController {

    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @QueryMapping
    public List<Patient> patients() {
        return patientRepository.findAll();
    }

}
