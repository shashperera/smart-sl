package com.esad.smartsl.dto.responseDto;

import java.io.Serializable;
import java.util.ArrayList;

public class BaseResponseDto implements Serializable {

    private static final long serialVersionUID = -5712943613808470793L;

    private Integer totalPages;
    private Integer currentPage;
    private Integer totalItems;

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Integer totalItems) {
        this.totalItems = totalItems;
    }

}
