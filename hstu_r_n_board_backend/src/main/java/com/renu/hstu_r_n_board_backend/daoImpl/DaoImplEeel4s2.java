package com.renu.hstu_r_n_board_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.DaoEeel4s2;
import com.renu.hstu_r_n_board_backend.dto.Eeel4s1;
import com.renu.hstu_r_n_board_backend.dto.Eeel4s2;

@Repository
@Transactional
public class DaoImplEeel4s2 implements DaoEeel4s2{
	@Autowired
	private SessionFactory sessionFactory;

		@Override
		public boolean eeeL4S1Add(Eeel4s1 eeel4s1) {
	try {
		sessionFactory.getCurrentSession().persist(eeel4s1);
		return true;
	} catch (Exception e) {
	e.printStackTrace();
	return false;

	}
		
		}

		@Override
		public List<Eeel4s1> creatQuer() {
			return sessionFactory.getCurrentSession().createQuery("FROM Eeel4s2", Eeel4s1.class).getResultList();
			
		}

		@Override
		public boolean eeeL4S1Delete(int i@) {
	try {
		Eeel4s1 list=sessionFactory.getCurrentSession().load(Eeel4s1.class, id);
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
		public boolean eeeL4S1(Eeel4s1 eeel4s1) {
		try {
			sessionFactory.getCurrentSession().update(eeel4s1);
			return true;
		} catch (Exception e) {
	e.printStackTrace();
	return false;
		}
		}

		@Override
		public boolean eeeL4S1Truncate(Eeel4s1 eeel4s1) {
			try {
				sessionFactory.getCurrentSession().createQuery("TRUNCATE TABLE Eeel4s1").executeUpdate();
				return true;
			} catch (Exception e) {
	e.printStackTrace();
	return false;
			
			}
		}

		@Override
		public Eeel4s2 GetById(int id) {
		List<Eeel4s4>list=sessionFactory.getCurrentSession().createQuery("FROM Eeel3s4 p where p.id=:id").setParameter("id", id).list();
		return list.size()>0?list.get(0):null;
		}
}
