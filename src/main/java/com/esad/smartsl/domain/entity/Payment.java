package com.esad.smartsl.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "PAYMENT")
public class Payment extends BaseEntity implements Serializable{

    private static final long serialVersionUID = -8200813818678206852L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "REFERENCE")
    private String reference;

    @Column(name = "TXN_TIME")
    private Timestamp txnTime;

    @Column(name = "TXN_AMOUNT")
    private Double txnAmount;

    @Column(name = "TXN_MEDIA")
    private Integer txnMedia;

    @Column(name = "THIRD_PARTY_REFERENCE")
    private String thirdPartyReference;

    @Column(name = "PAYMENT_STATUS")
    private Integer paymentStatus;

    @Column(name = "PAYMENT_TYPE")
    private Integer paymentType;

    @Column(name = "REQUEST_REFERENCE")
    private String requestReference;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
