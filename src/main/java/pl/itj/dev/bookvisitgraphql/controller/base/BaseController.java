package pl.itj.dev.bookvisitgraphql.controller.base;

import java.util.Optional;
import org.springframework.data.domain.PageRequest;

public abstract class BaseController {

  protected PageRequest preparePageRequest(Integer page, Integer size) {
    int pageNo = Optional.ofNullable(page).orElse(0);
    int sizeNo = Math.min(Optional.ofNullable(size).orElse(20), 25);
    return PageRequest.of(pageNo, sizeNo);
  }
}
