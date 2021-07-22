package com.rieyan.coronavaccinetracker.models;

public class Records {

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVaccines() {
        return vaccines;
    }

    public void setVaccines(String vaccines) {
        this.vaccines = vaccines;
    }

    public String getLast_observation_date() {
        return last_observation_date;
    }

    public void setLast_observation_date(String last_observation_date) {
        this.last_observation_date = last_observation_date;
    }

    private String location;
    private String vaccines;
    private String last_observation_date;
    String test;
    @Override
    public String toString() {
        return "Records{" +
                "location='" + location + '\'' +
                ", vaccines='" + vaccines + '\'' +
                ", last_observation_date='" + last_observation_date + '\'' +
                '}';
    }
}
