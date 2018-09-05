package com.neobank.project.configuration;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.ReturningWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBSession {
	@Autowired
	SessionFactory sessionFactory;

	public Session getSession() {
		Session session = null;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	
	public Connection getConnection() {
		Connection conn = getSession().doReturningWork(new ReturningWork<Connection>() {
			@Override
			public Connection execute(Connection connection) throws SQLException {
				return connection;
			}
		
		});
		return conn;
	}
	
}