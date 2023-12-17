package com.esad.smartsl.domain.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalTime;

@Entity
@Table(name = "PASSENGER_TRIP")
public class PassengerTrip extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -5148221700232072083L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private Integer id;

	@Column(name = "REFERENCE")
	private String reference;

	@Column(name = "START_LOCATION")
	private String startLocation;

	@Column(name = "END_LOCATION")
	private String endLocation;

	@Column(name = "START_DATE_TIME")
	private Timestamp startDatetime;

	@Column(name = "END_DATE_TIME")
	private Timestamp endDatetime;

	@Column(name = "DISTANCE")
	private Double distance;

	@Column(name = "FARE")
	private Double fare;

	@Column(name = "DURATION")
	@JsonFormat(pattern = "HH:mm:ss")
	private LocalTime duration;

	@Column(name = "STAR")
	private Double star;

	@Column(name = "COMMENT")
	private String comment;

	@Column(name = "PAYMENT_STATUS")
	private Integer paymentStatus;

	@Column(name = "PAYMENT_REFERENCE")
	private String paymentReference;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "PASSENGER_ID", nullable = false)
	private User passenger;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "TIMETABLE_ID", nullable = false)
	private Timetable timetable;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "ROUTE_ID", nullable = false)
	private Route route;

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

	public String getStartLocation() {
		return startLocation;
	}

	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}

	public String getEndLocation() {
		return endLocation;
	}

	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public Timestamp getStartDatetime() {
		return startDatetime;
	}

	public void setStartDatetime(Timestamp startDatetime) {
		this.startDatetime = startDatetime;
	}

	public Timestamp getEndDatetime() {
		return endDatetime;
	}

	public void setEndDatetime(Timestamp endDatetime) {
		this.endDatetime = endDatetime;
	}

	public Double getDistance() {
		return distance;
	}

	public void setDistance(Double distance) {
		this.distance = distance;
	}

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}

	public Double getStar() {
		return star;
	}

	public void setStar(Double star) {
		this.star = star;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentReference() {
		return paymentReference;
	}

	public void setPaymentReference(String paymentReference) {
		this.paymentReference = paymentReference;
	}

	public User getPassenger() {
		return passenger;
	}

	public void setPassenger(User passenger) {
		this.passenger = passenger;
	}

	public Timetable getTimetable() {
		return timetable;
	}

	public void setTimetable(Timetable timetable) {
		this.timetable = timetable;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

}
