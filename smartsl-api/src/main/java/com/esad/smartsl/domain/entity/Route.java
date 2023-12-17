package com.esad.smartsl.domain.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ROUTE")
public class Route extends BaseEntity implements Serializable {

    private static final long serialVersionUID = -392142168891213574L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID", updatable = false, nullable = false)
    private int id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    @Column(name = "START_LOCATION")
    private String startLocation;

    @Column(name = "END_LOCATION")
    private String endLocation;

    @Column(name = "DISTANCE")
    private Integer distance;

    @Column(name = "TYPE")
    private Integer type;

    @Column(name = "MINIMUM_COST")
    private Integer minimumCost;

    @Column(name = "MAXIMUM_COST")
    private Integer maximumCost;

    @Column(name = "DURATION")
    private Integer duration;

    @Column(name = "FAIR_RATE")
    private Double fairRate;

    @Column(name = "MINIMUM_DISTANCE")
    private Integer minimumDistance;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMinimumCost() {
        return minimumCost;
    }

    public void setMinimumCost(Integer minimumCost) {
        this.minimumCost = minimumCost;
    }

    public Integer getMaximumCost() {
        return maximumCost;
    }

    public void setMaximumCost(Integer maximumCost) {
        this.maximumCost = maximumCost;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getFairRate() {
        return fairRate;
    }

    public void setFairRate(Double fairRate) {
        this.fairRate = fairRate;
    }

    public Integer getMinimumDistance() {
        return minimumDistance;
    }

    public void setMinimumDistance(Integer minimumDistance) {
        this.minimumDistance = minimumDistance;
    }
}