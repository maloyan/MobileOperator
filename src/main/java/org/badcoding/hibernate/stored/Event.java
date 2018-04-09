package org.badcoding.hibernate.stored;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Event")
public class Event {
    private int eventId;
    private Date startDate;
    private Date endDate;
    private int amount;
    private Contract contract;
    private Services service;

    @Id
    @Column(name = "Event_ID", nullable = false)
    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Basic
    @Column(name = "start_date", nullable = false)
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "amount", nullable = false)
    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @ManyToOne
    @JoinColumn(name = "Contract_ID", referencedColumnName = "Contract_ID", nullable = false)
    public Contract getContractId() {
        return contract;
    }

    public void setContractId(Contract contractByContractId) { this.contract = contractByContractId; }

    @ManyToOne
    @JoinColumn(name = "Service_ID", referencedColumnName = "Service_ID", nullable = false)
    public Services getService() { return service; }

    public void setService(Services service) { this.service = service; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return eventId == event.eventId &&
                amount == event.amount &&
                Objects.equals(startDate, event.startDate) &&
                Objects.equals(endDate, event.endDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(eventId, startDate, endDate, amount);
    }

}
