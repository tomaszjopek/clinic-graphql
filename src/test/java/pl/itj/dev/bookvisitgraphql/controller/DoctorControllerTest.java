package pl.itj.dev.bookvisitgraphql.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureHttpGraphQlTester;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.WebGraphQlTester;
import org.springframework.test.context.ActiveProfiles;
import pl.itj.dev.bookvisitgraphql.model.ety.Doctor;


@SpringBootTest
@ActiveProfiles(profiles = {"test"})
@AutoConfigureMockMvc
@AutoConfigureHttpGraphQlTester
class DoctorControllerTest {
    private WebGraphQlTester graphQlTester;

    @BeforeEach
    public void beforeEach(@Autowired WebGraphQlTester webGraphQlTester) {
        this.graphQlTester = webGraphQlTester;
    }

    @Test
    @DisplayName("should return all doctors paginated")
    public void shouldReturnAllDoctors() {
        String query = """
                query {
                  doctors(page: 0, size: 20) {
                    pageInfo {
                      pageNumber
                      totalCount
                      totalPages
                    }
                    items {
                      name
                      surname
                    }
                  }
                }
                """;
        graphQlTester.document(query)
                .execute()
                .path("doctors.pageInfo.pageNumber").entity(int.class).isEqualTo(0)
                .path("doctors.pageInfo.totalCount").entity(int.class).isEqualTo(2)
                .path("doctors.pageInfo.totalPages").entity(int.class).isEqualTo(1)
                .path("doctors.items").entityList(Doctor.class).hasSize(2)
                .path("doctors.items[0].name").entity(String.class).isEqualTo("doc");
    }
}