package org.badcoding.hibernate.logic;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class Database {
	private static final SessionFactory factory;
	static {
		ServiceRegistry serviceRegistry;
		Configuration configuration = new Configuration();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.configure().getProperties()).build();
		factory = configuration.buildSessionFactory(serviceRegistry);
	}
	
    public static SessionFactory getFactory() {
        return factory;
    }
    
}


