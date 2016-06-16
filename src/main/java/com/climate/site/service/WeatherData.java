package com.climate.site.service;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by g01083595 on 16/06/2016.
 */
public class WeatherData {
    private Date date;
    private String city;
    private BigDecimal tempc;
    private BigDecimal tempf;
    private String outlook;
    private Date sunrise;
    private Date sunset;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public BigDecimal getTempc() {
        return tempc;
    }

    public void setTempc(BigDecimal temp) {
        this.tempc = temp;
    }

    public BigDecimal getTempf() {
        return tempf;
    }

    public void setTempf(BigDecimal temp) {
        this.tempf = temp;
    }

    public String getOutlook() {
        return outlook;
    }

    public void setOutlook(String outlook) {
        this.outlook = outlook;
    }

    public Date getSunrise() {
        return sunrise;
    }

    public void setSunrise(Date sunrise) {
        this.sunrise = sunrise;
    }

    public Date getSunset() {
        return sunset;
    }

    public void setSunset(Date sunset) {
        this.sunset = sunset;
    }
}
