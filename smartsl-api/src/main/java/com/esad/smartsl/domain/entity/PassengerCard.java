package com.esad.smartsl.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "PASSENGER_CARD")
public class PassengerCard extends BaseEntity implements Serializable {

	private static final long serialVersionUID = 3368493152759684861L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "REFERENCE")
	private String reference;

	@Column(name = "PAYMENT_STATUS")
	private Integer paymentStatus;

	@Column(name = "TOTAL_USAGE")
	private Double totalUsage;

	@Column(name = "CARD_AMOUNT")
	private Double cardAmount;

	@Column(name = "RECHARGED_AMOUNT")
	private Double rechargeAmount;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "CARD_PACKAGE_ID", nullable = false)
	private CardPackage cardPackage;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

//    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
//    @JoinTable(
//            name = "PASSENGER_CARDS_PAYMENTS",
//            joinColumns = {@JoinColumn(name = "PASSENGER_CARD_ID")},
//            inverseJoinColumns = {@JoinColumn(name = "PAYMENT_ID")}
//    )
//    private Set<Payment> payments = new HashSet<>();

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PAYMENT_ID", nullable = false)
	private Payment payment;

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

	public CardPackage getCardPackage() {
		return cardPackage;
	}

	public void setCardPackage(CardPackage cardPackage) {
		this.cardPackage = cardPackage;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Double getRechargeAmount() {
		return rechargeAmount;
	}

	public void setRechargeAmount(Double rechargeAmount) {
		this.rechargeAmount = rechargeAmount;
	}

}
