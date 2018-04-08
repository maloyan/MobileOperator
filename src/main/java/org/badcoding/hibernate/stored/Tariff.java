package org.badcoding.hibernate.stored;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Tariff")
public class Tariff {
    private int tariffId;
    private String name;
    private Integer intMb;
    private Integer intDay;
    private Integer callDayPerMinute;
    private Integer callNightPerMinute;
    private Integer callPerDay;
    private Integer sms;

    public void setTariffId(Integer tariffId) {
        this.tariffId = tariffId;
    }

    @Id
    @Column(name = "Tariff_ID", nullable = false)
    public int getTariffId() {
        return tariffId;
    }

    public void setTariffId(int tariffId) {
        this.tariffId = tariffId;
    }

    
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    @Basic
    @Column(name = "int_mb", nullable = true)
    public Integer getIntMb() {
        return intMb;
    }

    public void setIntMb(Integer intMb) {
        this.intMb = intMb;
    }

    
    @Basic
    @Column(name = "int_day", nullable = true)
    public Integer getIntDay() {
        return intDay;
    }

    public void setIntDay(Integer intDay) {
        this.intDay = intDay;
    }

    
    @Basic
    @Column(name = "call_day_per_minute", nullable = true)
    public Integer getCallDayPerMinute() {
        return callDayPerMinute;
    }

    public void setCallDayPerMinute(Integer callDayPerMinute) {
        this.callDayPerMinute = callDayPerMinute;
    }

    
    @Basic
    @Column(name = "call_night_per_minute", nullable = true)
    public Integer getCallNightPerMinute() {
        return callNightPerMinute;
    }

    public void setCallNightPerMinute(Integer callNightPerMinute) {
        this.callNightPerMinute = callNightPerMinute;
    }

    
    @Basic
    @Column(name = "call_per_day", nullable = true)
    public Integer getCallPerDay() {
        return callPerDay;
    }

    public void setCallPerDay(Integer callPerDay) {
        this.callPerDay = callPerDay;
    }

    
    @Basic
    @Column(name = "sms", nullable = true)
    public Integer getSms() {
        return sms;
    }

    public void setSms(Integer sms) {
        this.sms = sms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tariff tariff = (Tariff) o;
        return tariffId == tariff.tariffId &&
                Objects.equals(name, tariff.name) &&
                Objects.equals(intMb, tariff.intMb) &&
                Objects.equals(intDay, tariff.intDay) &&
                Objects.equals(callDayPerMinute, tariff.callDayPerMinute) &&
                Objects.equals(callNightPerMinute, tariff.callNightPerMinute) &&
                Objects.equals(callPerDay, tariff.callPerDay) &&
                Objects.equals(sms, tariff.sms);
    }

    @Override
    public int hashCode() {

        return Objects.hash(tariffId, name, intMb, intDay, callDayPerMinute, callNightPerMinute, callPerDay, sms);
    }
}
