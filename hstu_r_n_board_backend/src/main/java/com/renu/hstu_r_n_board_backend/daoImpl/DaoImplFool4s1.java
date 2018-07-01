package com.renu.hstu_r_n_board_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.DaoFool4s1;
import com.renu.hstu_r_n_board_backend.dto.Fool4s1;

@Repository
@Transactional
public class DaoImplFool4s1 implements DaoFool4s1{


    @Autowired
    private SessionFactory sessionFactory;
    
	@Override
	public boolean fooL4S1Add(Fool4s1 fool4s1) {
	try {
		sessionFactory.getCurrentSession().persist(fool4s1);
		return true;
	} catch (Exception e) {
e.printStackTrace();
return false;
	}
	}

	@Override
	public List<Fool4s1> fooL4S1GetAll() {
		return sessionFactory.getCurrentSession().createQuery("FROM Fool4s1", Fool4s1.class).getResultList();
		
	}

	@Override
	public boolean fooL4S1Delete(int id) {
		try {
			Fool4s1 list=sessionFactory.getCurrentSession().load(Fool4s1.class, id);
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
	public boolean fooL4S1Update(Fool4s1 fool4s1) {
		try {
			sessionFactory.getCurrentSession().update(fool4s1);
			return true;
		} catch (Exception e) {
e.printStackTrace();
return false;
		}
	}

	@Override
	public boolean fooL4S1Truncate(Fool4s1 fool4s1) {
	try {
		sessionFactory.getCurrentSession().createQuery("TRUNCATE TABLE Fool4s1").executeUpdate();
		return true;
	} catch (Exception e) {
e.printStackTrace();
return false;
	}
	}

	@Override
	public Fool4s1 fooL4S1GetById(int id) {
	List<Fool4s1>list=sessionFactory.getCurrentSession().createQuery("FROM Fool4s1 p where p.id=:id").setParameter("id", id).list();
	return list.size()>0?list.get(0):null;
	}
}
