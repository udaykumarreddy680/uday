package com.jspiders.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jpspiders.hibernate.util.HibernateUtil;
import com.jspiders.hibernate.dto.MovieDTO;

public class MovieDAO {

	private SessionFactory factory = HibernateUtil.getSessionFactory();
	
	public void save(MovieDTO movieDTO) {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(movieDTO);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			if (session != null)
				session.close();
		}
	}
}
