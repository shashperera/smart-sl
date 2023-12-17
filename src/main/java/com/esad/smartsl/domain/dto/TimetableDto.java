package com.esad.smartsl.domain.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class TimetableDto extends BaseDto implements Serializable{


    private static final long serialVersionUID = -1226371812212194732L;

    private Integer id;
    private Timestamp startTime;
    private Timestamp endTime;
    private String reference;
    private RouteDto route;
    private UserDto user;
    private VehicleDto vehicle;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public RouteDto getRoute() {
        return route;
    }

    public void setRoute(RouteDto route) {
        this.route = route;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public VehicleDto getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleDto vehicle) {
        this.vehicle = vehicle;
    }
}
