package pl.itj.dev.bookvisitgraphql.model.dto.payloads;

import pl.itj.dev.bookvisitgraphql.model.ety.Doctor;

public record AddDoctorSuccessPayload(Doctor doctor) implements AddDoctorPayload {
    @Override
    public String error() {
        return null;
    }
}
