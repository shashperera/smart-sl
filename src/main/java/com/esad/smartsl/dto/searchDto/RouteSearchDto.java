package com.esad.smartsl.dto.searchDto;

import java.io.Serializable;

public class RouteSearchDto extends BaseSearchDto implements Serializable {

    private static final long serialVersionUID = 4799587110425359424L;
//
    private int id;
    private String name;
    private String code;
    private String startLocation;
    private String endLocation;
    private Integer distance;
    private Integer type;
    private Integer minimumCost;
    private Integer maximumCost;
    private Integer duration;
    private Integer fairRate;
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

    public Integer getFairRate() {
        return fairRate;
    }

    public void setFairRate(Integer fairRate) {
        this.fairRate = fairRate;
    }

    public Integer getMinimumDistance() {
        return minimumDistance;
    }

    public void setMinimumDistance(Integer minimumDistance) {
        this.minimumDistance = minimumDistance;
    }
}
