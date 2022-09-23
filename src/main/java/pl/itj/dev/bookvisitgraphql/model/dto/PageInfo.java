package pl.itj.dev.bookvisitgraphql.model.dto;

import org.springframework.data.domain.Page;

public class PageInfo<T> {
    private final Page<T> result;

    public PageInfo(Page<T> result) {
        this.result = result;
    }

    public int getPageNumber() {
        return result.getNumber();
    }

    public int getTotalPages() {
        return result.getTotalPages();
    }

    public long getTotalCount() {
        return result.getTotalElements();
    }

    public boolean getHasNext() {
        return result.hasNext();
    }

    public boolean getHasPrev() {
        return result.hasPrevious();
    }

    public Integer getNextPage() {
        if (result.hasNext()) {
            return result.getNumber() + 1;
        }

        return null;
    }

    public Integer getPrevPage() {
        if (result.hasPrevious()) {
            return result.getNumber() - 1;
        }

        return null;
    }
}
