package com.esad.smartsl.dto.searchDto;

import java.io.Serializable;

public class PassengerCardSearchDto extends BaseSearchDto implements Serializable {

	private static final long serialVersionUID = 7438318201720360326L;

	private int id;
	private String reference;
	private Integer paymentStatus;
	private Integer cardPackageId;
	private Integer userId;
	private String email;

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

	public Integer getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public Integer getCardPackageId() {
		return cardPackageId;
	}

	public void setCardPackageId(Integer cardPackageId) {
		this.cardPackageId = cardPackageId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
