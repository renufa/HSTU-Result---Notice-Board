package com.renu.hstu_r_n_board_backend.daoImpl;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.DaoAccl1s1;
import com.renu.hstu_r_n_board_backend.dto.Accl1s1;

@Repository
@Transactional
public class DaoImplAccl1s1 implements DaoAccl1s1{

	@Autowired
private SessionFactory sessionFactory;
	@Override
	public boolean accL1S1Add(Accl1s1 accl1s1) {
		try {
			sessionFactory.getCurrentSession().persist(accl1s1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Accl1s1> accL1S1GetAll() {
		return sessionFactory.getCurrentSession().createQuery("FROM Accl1s1", Accl1s1.class).getResultList();
	}

	@Override
	public boolean accL1S1Delete(int id) {
		try {
			Accl1s1 list=sessionFactory.getCurrentSession().load(Accl1s1.class, id);
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
	public boolean accL1S1Update(Accl1s1 accl1s1) {
		try {
			sessionFactory.getCurrentSession().update(accl1s1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean accL1S1Truncate(Accl1s1 accl1s1) {
		try {
			sessionFactory.getCurrentSession().createQuery("TRUNCATE TABLE Accl1s1").executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Accl1s1 accL1S1GetById(int id) {
		List<Accl1s1>list=sessionFactory.getCurrentSession().createQuery("FROM Accl1s1 p where p.id=:id").setParameter("id",id).list();
		return list.size()>0?list.get(0):null;
	}

}
