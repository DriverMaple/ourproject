package com.mooc.entity;

public class Truck {
    private Long truckId;

    private Long userId;

    private String license;

    private Float maxVolume;

    private Float maxWeight;

    public Truck(Long truckId, Long userId, String license, Float maxVolume, Float maxWeight) {
        this.truckId = truckId;
        this.userId = userId;
        this.license = license;
        this.maxVolume = maxVolume;
        this.maxWeight = maxWeight;
    }

    public Truck() {
        super();
    }

    public Long getTruckId() {
        return truckId;
    }

    public void setTruckId(Long truckId) {
        this.truckId = truckId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license == null ? null : license.trim();
    }

    public Float getMaxVolume() {
        return maxVolume;
    }

    public void setMaxVolume(Float maxVolume) {
        this.maxVolume = maxVolume;
    }

    public Float getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Float maxWeight) {
        this.maxWeight = maxWeight;
    }
}