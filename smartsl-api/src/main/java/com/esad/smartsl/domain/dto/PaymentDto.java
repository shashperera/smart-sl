package com.esad.smartsl.domain.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class PaymentDto extends BaseDto implements Serializable{

    private static final long serialVersionUID = 8770935431645644L;

    private Integer id;
    private String reference;
    private Timestamp txnTime;
    private Double txnAmount;
    private Integer txnMedia;
    private String thirdPartyReference;
    private Integer paymentStatus;
    private Integer paymentType;
    private String requestReference;
    private UserDto user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Timestamp getTxnTime() {
        return txnTime;
    }

    public void setTxnTime(Timestamp txnTime) {
        this.txnTime = txnTime;
    }

    public Double getTxnAmount() {
        return txnAmount;
    }

    public void setTxnAmount(Double txnAmount) {
        this.txnAmount = txnAmount;
    }

    public Integer getTxnMedia() {
        return txnMedia;
    }

    public void setTxnMedia(Integer txnMedia) {
        this.txnMedia = txnMedia;
    }

    public String getThirdPartyReference() {
        return thirdPartyReference;
    }

    public void setThirdPartyReference(String thirdPartyReference) {
        this.thirdPartyReference = thirdPartyReference;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Integer getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(Integer paymentType) {
        this.paymentType = paymentType;
    }

    public String getRequestReference() {
        return requestReference;
    }

    public void setRequestReference(String requestReference) {
        this.requestReference = requestReference;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }
}
