package pl.itj.dev.bookvisitgraphql.services;

import pl.itj.dev.bookvisitgraphql.model.dto.inputs.AddDoctorInput;
import pl.itj.dev.bookvisitgraphql.model.ety.Doctor;

public interface DoctorService {

     Doctor addDoctor(String name, String surname, String email);
}
