package com.esad.smartsl.domain.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalTime;

public class PassengerTripDto extends BaseDto implements Serializable {

	private static final long serialVersionUID = -5132185242973145110L;

	private Integer id;
	private String reference;
	private String startLocation;
	private String endLocation;
	private Timestamp startDatetime;
	private Timestamp endDatetime;
	private Double distance;
	private Double fare;
	private LocalTime duration;
	private Double star;
	private String comment;
	private Integer paymentStatus;
	private String paymentReference;
	private UserDto passenger;
	private TimetableDto timetable;
	private RouteDto route;

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

	public UserDto getPassenger() {
		return passenger;
	}

	public void setPassenger(UserDto passenger) {
		this.passenger = passenger;
	}

	public TimetableDto getTimetable() {
		return timetable;
	}

	public void setTimetable(TimetableDto timetable) {
		this.timetable = timetable;
	}

	public RouteDto getRoute() {
		return route;
	}

	public void setRoute(RouteDto route) {
		this.route = route;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

}
