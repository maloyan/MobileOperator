package org.badcoding.spring.form;

public class TariffForm {
    private Integer tariffId;
    private String name;
    private Integer intMb;
    private Integer intDay;
    private Integer callDayPerMinute;
    private Integer callNightPerMinute;
    private Integer callPerDay;
    private Integer sms;

    public Integer getTariffId() {
        return tariffId;
    }

    public void setTariffId(Integer tariffId) {
        this.tariffId = tariffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIntMb() {
        return intMb;
    }

    public void setIntMb(Integer intMb) {
        this.intMb = intMb;
    }

    public Integer getIntDay() {
        return intDay;
    }

    public void setIntDay(Integer intDay) {
        this.intDay = intDay;
    }

    public Integer getCallDayPerMinute() {
        return callDayPerMinute;
    }

    public void setCallDayPerMinute(Integer callDayPerMinute) {
        this.callDayPerMinute = callDayPerMinute;
    }

    public Integer getCallNightPerMinute() {
        return callNightPerMinute;
    }

    public void setCallNightPerMinute(Integer callNightPerMinute) {
        this.callNightPerMinute = callNightPerMinute;
    }

    public Integer getCallPerDay() {
        return callPerDay;
    }

    public void setCallPerDay(Integer callPerDay) {
        this.callPerDay = callPerDay;
    }

    public Integer getSms() {
        return sms;
    }

    public void setSms(Integer sms) {
        this.sms = sms;
    }

}
