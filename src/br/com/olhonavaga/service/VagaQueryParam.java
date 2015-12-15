package br.com.olhonavaga.service;

/**
 * Created with IntelliJ IDEA.
 * User: Leonardo Neves
 * Date: 14/12/2015
 * Time: 09:58
 */
public class VagaQueryParam {

    private String description = "";
    private String location = "";
    private double lat = 0;
    private double lon = 0;
    private boolean full_time = true;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public boolean isFullTime() {
        return full_time;
    }

    public void setFullTime(boolean full_time) {
        this.full_time = full_time;
    }
}
