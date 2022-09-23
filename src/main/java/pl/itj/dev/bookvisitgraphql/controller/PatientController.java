package pl.itj.dev.bookvisitgraphql.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pl.itj.dev.bookvisitgraphql.controller.base.BaseController;
import pl.itj.dev.bookvisitgraphql.model.dto.PageableResult;
import pl.itj.dev.bookvisitgraphql.model.ety.Patient;
import pl.itj.dev.bookvisitgraphql.repositories.PatientRepository;

@Controller
public class PatientController extends BaseController {

    private final PatientRepository patientRepository;

    public PatientController(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @QueryMapping
    public PageableResult<Patient> patients(@Argument Integer page, @Argument Integer size) {
        final PageRequest pageRequest = preparePageRequest(page, size);
        Page<Patient> patientPage = patientRepository.findAll(pageRequest);
        return new PageableResult<>(patientPage);
    }

}
