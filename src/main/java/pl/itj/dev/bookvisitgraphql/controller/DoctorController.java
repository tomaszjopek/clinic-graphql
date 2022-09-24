package pl.itj.dev.bookvisitgraphql.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import pl.itj.dev.bookvisitgraphql.controller.base.BaseController;
import pl.itj.dev.bookvisitgraphql.model.dto.PageableResult;
import pl.itj.dev.bookvisitgraphql.model.ety.Doctor;
import pl.itj.dev.bookvisitgraphql.repositories.DoctorRepository;

@Controller
@AllArgsConstructor
public class DoctorController extends BaseController {
  private final DoctorRepository doctorRepository;

  @QueryMapping
  public PageableResult<Doctor> doctors(@Argument Integer page, @Argument Integer size) {
    final PageRequest pageRequest = preparePageRequest(page, size);
    Page<Doctor> doctorPage = doctorRepository.findAll(pageRequest);
    return new PageableResult<>(doctorPage);
  }
}
