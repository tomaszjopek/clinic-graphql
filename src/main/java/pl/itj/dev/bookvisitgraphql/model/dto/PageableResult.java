package pl.itj.dev.bookvisitgraphql.model.dto;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageableResult<T> {

    private final Page<T> result;

    public PageableResult(Page<T> result) {
        this.result = result;
    }

    public PageInfo<T> getPageInfo() {
        return new PageInfo<T>(result);
    }

    public List<T> getItems() {
        return result.getContent();
    }
}
