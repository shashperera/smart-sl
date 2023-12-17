package com.esad.smartsl.domain.dto;

import java.io.Serializable;

public class VehicleDto extends BaseDto implements Serializable {

    private static final long serialVersionUID = -4761556843065739375L;

    private int id;
    private String name;
    private Integer vehicleType;
    private String vehicleNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(Integer vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

}
