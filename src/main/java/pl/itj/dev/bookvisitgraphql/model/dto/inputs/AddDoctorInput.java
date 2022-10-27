package pl.itj.dev.bookvisitgraphql.model.dto.inputs;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class AddDoctorInput {
    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    @Email
    private String email;
}
