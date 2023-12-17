package com.esad.smartsl.dto.searchDto;

import java.io.Serializable;

import com.esad.smartsl.enums.OrderDirection;

public class BaseSearchDto implements Serializable {

    private static final long serialVersionUID = 3089150368009687953L;

    private Integer currentPage = 0;
    private Integer pageSize = 10;
    private OrderDirection orderDirection = OrderDirection.ASC;
    private String sortBy = "id";

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public OrderDirection getOrderDirection() {
        return orderDirection;
    }

    public void setOrderDirection(OrderDirection orderDirection) {
        this.orderDirection = orderDirection;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }
}
