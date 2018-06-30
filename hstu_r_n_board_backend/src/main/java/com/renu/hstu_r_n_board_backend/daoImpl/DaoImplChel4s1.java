package com.renu.hstu_r_n_board_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.DaoChel4s1;
import com.renu.hstu_r_n_board_backend.dto.Chel4s1;

@Repository
@Transactional
public class DaoImplChel4s1 implements DaoChel4s1{

	 @Autowired
	    private SessionFactory sessionFactory;
		@Override
		public boolean cheL4S1Add(Chel4s1 chel4s1) {
			try {
				sessionFactory.getCurrentSession().persist(chel4s1);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		@Override
		public List<Chel4s1> cheL4S1GetAll() {
			return sessionFactory.getCurrentSession().createQuery("FROM Chel4s1", Chel4s1.class).getResultList();
			
		}

		@Override
		public boolean cheL4S1Delete(int id) {
			try {
				Chel4s1 list=sessionFactory.getCurrentSession().load(Chel4s1.class, id);
				if (list!=null) {
		         sessionFactory.getCurrentSession().delete(list);			
				}
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		@Override
		public boolean cheL4S1Update(Chel4s1 chel4s1) {
			try {
				sessionFactory.getCurrentSession().update(chel4s1);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		@Override
		public boolean cheL4S1Truncate(Chel4s1 chel4s1) {
			try {
				sessionFactory.getCurrentSession().createQuery("TRUNCATE TABLE Chel4s1").executeUpdate();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		@Override
		public Chel4s1 cheL4S1GetById(int id) {
			
				List<Chel4s1>list=sessionFactory.getCurrentSession().createQuery("FROM Chel4s1 p where p.id=:id").setParameter("id", id).list();
				return list.size()>0?list.get(0):null;
			
		}
}
