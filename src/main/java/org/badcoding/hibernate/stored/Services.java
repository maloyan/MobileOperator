package org.badcoding.hibernate.stored;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Services")
public class Services {
    private int serviceId;
    private String serviceName;
    private String description;

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    @Id
    @Column(name = "Service_ID", nullable = false)
    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    
    @Basic
    @Column(name = "service_name", nullable = false, length = 45)
    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    
    @Basic
    @Column(name = "description", nullable = true, length = 45)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Services service = (Services) o;
        return serviceId == service.serviceId &&
                Objects.equals(serviceName, service.serviceName) &&
                Objects.equals(description, service.description);
    }

    @Override
    public int hashCode() {

        return Objects.hash(serviceId, serviceName, description);
    }
}
