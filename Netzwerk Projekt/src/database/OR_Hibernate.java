package database;

import java.util.*;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import data.User;

public final class OR_Hibernate {
	Session session;
	
	public OR_Hibernate() {
		SessionFactory factory=new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.buildSessionFactory();
		this.session=factory.getCurrentSession();
	}
	
	public List sendquery(String query){
		List result=this.session.createQuery(query).list();
		return result;
	}
	public boolean insert(ArrayList<Object> tosave){
		this.session.beginTransaction();
		int length=tosave.size(), counter=0;
		for(int i=-1;i<length;){
			if (counter>(length%10+10)) {
				session.getTransaction().rollback();
				return false;
			}
			try {
			i++;
			this.session.save(tosave.get(i));
			this.session.flush();
			this.session.clear();
			} catch (HibernateException e) {
				e.printStackTrace();
				i--;
				counter++;
			}
		}
		session.getTransaction().commit();
		return true;
	}
	public boolean update(ArrayList<Object> toupdate){
		Transaction transaction=this.session.beginTransaction();
		int size=toupdate.size(), counter=0;
		for(int i=-1;i<size;){
			if(counter>(size%10+10)){
				transaction.rollback();
				return false;
			}
			try {
				i++;
				this.session.update(toupdate.get(i));
				this.session.flush();
				this.session.clear();
			} catch (HibernateException e) {
				e.printStackTrace();
				i--;
				counter++;
			}
		}
		return true;
	}
	

}
