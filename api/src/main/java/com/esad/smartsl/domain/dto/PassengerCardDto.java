package com.esad.smartsl.domain.dto;

import java.io.Serializable;

public class PassengerCardDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = -1670542534545933566L;

	private Integer id;
	private String reference;
	private Integer paymentStatus;
	private Double totalUsage;
	private Double cardAmount;
	private CardPackageDto cardPackage;
	private UserDto user;
	private PaymentDto payment;
	private Double rechargeAmount;

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

	public Integer getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Double getTotalUsage() {
		return totalUsage;
	}

	public void setTotalUsage(Double totalUsage) {
		this.totalUsage = totalUsage;
	}

	public Double getCardAmount() {
		return cardAmount;
	}

	public void setCardAmount(Double cardAmount) {
		this.cardAmount = cardAmount;
	}

	public CardPackageDto getCardPackage() {
		return cardPackage;
	}

	public void setCardPackage(CardPackageDto cardPackage) {
		this.cardPackage = cardPackage;
	}

	public UserDto getUser() {
		return user;
	}

	public void setUser(UserDto user) {
		this.user = user;
	}

	public PaymentDto getPayment() {
		return payment;
	}

	public void setPayment(PaymentDto payment) {
		this.payment = payment;
	}

	public Double getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(Double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

}
