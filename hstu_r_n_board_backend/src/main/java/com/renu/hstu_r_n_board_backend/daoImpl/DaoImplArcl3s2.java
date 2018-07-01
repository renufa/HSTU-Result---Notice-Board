package com.renu.hstu_r_n_board_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.DaoArcl3s2;
import com.renu.hstu_r_n_board_backend.dto.Arcl3s1;
import com.renu.hstu_r_n_board_backend.dto.Arcl3s2;

@Repository
@Transactional
public class DaoImplArcl3s2 implements DaoArcl3s2{


	  @Autowired
	  private SessionFactory sessionFactory;
	  
		@Override
		public boolean arcL3S2Add(Arcl3s2 arcl3s2) {
	try {
		sessionFactory.getCurrentSession().persist(arcl3s2);
		return true;
	} catch (Exception e) {
	e.printStackTrace();
	return false;
	}
		
		}

		@Override
		public List<Arcl3s2> arcL3S2GetAll() {
			return sessionFactory.getCurrentSession().createQuery("FROM Arcl3s2", Arcl3s2.class).getResultList();
			
		}

		@Override
		public boolean arcL3S2Delete(int id) {
	try {
		Arcl3s2 list=sessionFactory.getCurrentSession().load(Arcl3s2.class, id);
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
		public boolean arcL3S2Update(Arcl3s2 arcl3s2) {
			try {
				sessionFactory.getCurrentSession().update(arcl3s2);
				return true;
			} catch (Exception e) {
	e.printStackTrace();
	return false;
			}
		}

		@Override
		public boolean arcL3S2Truncate(Arcl3s2 arcl3s2) {
			try {
				sessionFactory.getCurrentSession().createQuery("TRUNCATE TABLE Arcl3s2").executeUpdate();
				return true;
			} catch (Exception e) {
	e.printStackTrace();
	return false;
			}
		}

		@Override
		public Arcl3s2 arcL3S2GetById(int id) {
	List<Arcl3s2>list=sessionFactory.getCurrentSession().createQuery("FROM Arcl3s2 p where p.id=:id").setParameter("id", id).list();
	return list.size()>0?list.get(0):null;
		
		
		}
}
