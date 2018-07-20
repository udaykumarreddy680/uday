package com.jspiders.hibernate.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.jpspiders.hibernate.util.HibernateUtil;
import com.jspiders.hibernate.dto.ActorDTO;

public class ActorDAO {

	private SessionFactory factory = HibernateUtil.getSessionFactory();

	public ActorDTO getActorByName(String name) {
		Session session = null;
		ActorDTO actorDTO = null;
		String hql = "SELECT actor FROM ActorDTO actor WHERE actorName=:actNme";
		try {
			session = factory.openSession();
			Query query = session.createQuery(hql);
			query.setParameter("actNme", name);
			actorDTO = (ActorDTO) query.uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}
		return actorDTO;
	}
}
