package com.example.deyana.waterme_v01;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.time.temporal.ChronoUnit.DAYS;

public class Plant {
    private String userUUID;
    private String plantSpecies;
    private int daysBetweenWatering;
    private String lastDateWatered;

    Plant() {
    }

    Plant(String plantSpecies, int daysBetweenWatering, String lastDateWatered) {
        this.plantSpecies = plantSpecies;
        this.daysBetweenWatering = daysBetweenWatering;
        this.lastDateWatered = lastDateWatered;
    }

    void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    String getPlantSpecies() {
        return plantSpecies;
    }

    void setPlantSpecies(String plantSpecies) {
        this.plantSpecies = plantSpecies;
    }

    int getDaysBetweenWatering() {
        return daysBetweenWatering;
    }

    void setDaysBetweenWatering(int daysBetweenWatering) {
        this.daysBetweenWatering = daysBetweenWatering;
    }

    void setLastDateWatered(String lastDateWatered) {
        this.lastDateWatered = lastDateWatered;
    }

    String getLastDateWatered() {
        return lastDateWatered;
    }

    String whenToWater() {
        String whenToWater = "";

        LocalDate today = LocalDate.now();
        LocalDate lastWateredDate = LocalDate.parse(getLastDateWatered(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        LocalDate whenToWaterNext = lastWateredDate.plusDays(getDaysBetweenWatering());

        if(whenToWaterNext.isBefore(today) || whenToWaterNext.equals(today)) {
            whenToWater = "today";
        } else if(whenToWaterNext.isAfter(today)){
            long daysLeftUntilWatering = DAYS.between(today, whenToWaterNext);
            if(daysLeftUntilWatering == 1)
                whenToWater = "tomorrow";
            else
                whenToWater = "in " + String.valueOf(daysLeftUntilWatering) + " days";
        }

        return whenToWater;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "userUUID='" + userUUID + '\'' +
                ", plantSpecies='" + plantSpecies + '\'' +
                ", daysBetweenWatering=" + daysBetweenWatering +
                ", lastDateWatered='" + lastDateWatered + '\'' +
                '}';
    }
}
