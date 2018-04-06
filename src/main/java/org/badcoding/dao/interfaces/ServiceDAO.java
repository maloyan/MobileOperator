package org.badcoding.dao.interfaces;

import org.badcoding.hibernate.stored.Services;

import java.util.List;

public interface ServiceDAO {
    void addService(Services Service);

    void updateService(Services Service);

    void removeService(Services Service);

    Services getServiceById(int id);

    List<Services> listServices();
}
