package pl.itj.dev.bookvisitgraphql.model.dto.payloads;

import pl.itj.dev.bookvisitgraphql.model.ety.Doctor;

public record AddDoctorErrorPayload(String error) implements AddDoctorPayload {
    @Override
    public Doctor doctor() {
        return null;
    }
}
