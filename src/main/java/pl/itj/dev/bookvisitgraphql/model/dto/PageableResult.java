package pl.itj.dev.bookvisitgraphql.model.dto;

import java.util.List;
import org.springframework.data.domain.Page;

public class PageableResult<T> {

  private final Page<T> result;

  public PageableResult(Page<T> result) {
    this.result = result;
  }

  public PageInfo<T> getPageInfo() {
    return new PageInfo<>(result);
  }

  public List<T> getItems() {
    return result.getContent();
  }
}
