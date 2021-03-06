package com.renu.hstu_r_n_board_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.DaoMarl1s1;
import com.renu.hstu_r_n_board_backend.dto.Marl1s1;

@Repository
@Transactional
public class DaoImplMarl1s1 implements DaoMarl1s1{
@Autowired
private SessionFactory sessionFactory;

	@Override
	public boolean marL1S1Add(Marl1s1 marl1s1) {
		try {
			sessionFactory.getCurrentSession().persist(marl1s1);
			return true;
		} catch (Exception e) {
         e.printStackTrace();
         return false;
		
		}
	}

	@Override
	public List<Marl1s1> marL1S1GetAll() {
		return sessionFactory.getCurrentSession().createQuery("FROM Marl1s1", Marl1s1.class).getResultList();
		
	}

	@Override
	public boolean marL1S1Delete(int id) {
		try {
			Marl1s1 list=sessionFactory.getCurrentSession().load(Marl1s1.class, id);
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
	public boolean marL1S1Update(Marl1s1 marl1s1) {
		try {
			sessionFactory.getCurrentSession().update(marl1s1);
			return true;
		} catch (Exception e) {
      e.printStackTrace();
      return false;
		
		}
	}

	@Override
	public boolean marL1S1Truncate(Marl1s1 marl1s1) {
         try {
			sessionFactory.getCurrentSession().createQuery("TRUNCATE TABLE Marl1s1").executeUpdate();
			return true;
		} catch (Exception e) {

		e.printStackTrace();
		return false;
		}
	
	}

	@Override
	public Marl1s1 marL1S1GetById(int id) {
		List<Marl1s1>list=sessionFactory.getCurrentSession().createQuery("FROM Marl1s1 p where p.id=:id").setParameter("id", id).list();
		return list.size()>0?list.get(0):null;
	}

}
