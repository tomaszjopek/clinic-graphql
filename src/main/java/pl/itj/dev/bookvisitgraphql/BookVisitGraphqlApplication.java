package pl.itj.dev.bookvisitgraphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"pl.itj.dev.bookvisitgraphql.repositories"})
@EnableJpaAuditing
public class BookVisitGraphqlApplication {

  public static void main(String[] args) {
    SpringApplication.run(BookVisitGraphqlApplication.class, args);
  }
}
