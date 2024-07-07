package com.model;


import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class HBUtil {
    private static StandardServiceRegistry registry=null;
    private static SessionFactory sessionFactory=null;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				//Create registry
				registry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
				
				//Create MetadataSources
				MetadataSources sources= new MetadataSources(registry);
				
				//create Metadata
				Metadata metadata=sources.getMetadataBuilder().build();
				
				//create SessionFactory
				sessionFactory=metadata.getSessionFactoryBuilder().build();
			}
			catch(Exception e) {
				e.printStackTrace();
				if(registry!=null) {
					StandardServiceRegistryBuilder.destroy(registry);
				}
			}
		}
			return sessionFactory;
		}
	public static void shutdown() {
		if(registry!=null) {
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
