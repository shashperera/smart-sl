package com.esad.smartsl.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "Vehicle")
public class Vehicle extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -6130993337825308724L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", updatable = false, nullable = false)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "VEHICLE_TYPE")
    private Integer vehicleType;

    @Column(name = "VEHICLE_NUMBER")
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
