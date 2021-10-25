package dao;

import javax.management.loading.PrivateClassLoader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.dialect.MySQLStorageEngine;

import entity.Thuoc;

public class ThuocDao{
	private SessionFactory sessionFactory;

	public ThuocDao(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	public boolean delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		Transaction tr = session.getTransaction();
		
		try {
			tr.begin();
			session.delete(session.find(Thuoc.class, id));
			tr.commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			tr.rollback();
		}
		return false;
		
	}
}
