package pl.itj.dev.bookvisitgraphql;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.itj.dev.bookvisitgraphql.controller.DoctorController;
import pl.itj.dev.bookvisitgraphql.controller.PatientController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class BookVisitGraphqlApplicationTests {

    @Autowired
    private DoctorController doctorController;

    @Autowired
    private PatientController patientController;

    @Test
    public void contextLoads() {
        Assertions.assertThat(doctorController).isNotNull();
        Assertions.assertThat(patientController).isNotNull();
    }
}

