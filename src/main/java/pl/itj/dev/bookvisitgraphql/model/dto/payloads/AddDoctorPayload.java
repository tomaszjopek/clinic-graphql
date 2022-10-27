package pl.itj.dev.bookvisitgraphql.model.dto.payloads;

import pl.itj.dev.bookvisitgraphql.model.ety.Doctor;

public interface AddDoctorPayload {
    String error();
    Doctor doctor();
}
