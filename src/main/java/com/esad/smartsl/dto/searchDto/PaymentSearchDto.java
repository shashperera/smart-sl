package com.esad.smartsl.dto.searchDto;

import java.io.Serializable;

public class PaymentSearchDto extends BaseSearchDto implements Serializable {

    private static final long serialVersionUID = 2841384117169815308L;

    private int id;
    private String reference;
    private Integer paymentType;
    private Integer userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
