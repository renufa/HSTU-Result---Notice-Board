package com.renu.hstu_r_n_board_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.DaoFool4s2;
import com.renu.hstu_r_n_board_backend.dto.Fool4s2;

@Repository
@Transactional
public class DaoImplFool4s2 implements DaoFool4s2{


    @Autowired
    private SessionFactory sessionFactory;
    
	@Override
	public boolean fooL4S2Add(Fool4s2 fool4s2) {
	try {
		sessionFactory.getCurrentSession().persist(fool4s2);
		return true;
	} catch (Exception e) {
e.printStackTrace();
return false;
	}
	}

	@Override
	public List<Fool4s2> fooL4S2GetAll() {
		return sessionFactory.getCurrentSession().createQuery("FROM Fool4s2", Fool4s2.class).getResultList();
		
	}

	@Override
	public boolean fooL4S2Delete(int id) {
		try {
			Fool4s2 list=sessionFactory.getCurrentSession().load(Fool4s2.class, id);
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
	public boolean fooL4S2Update(Fool4s2 fool4s2) {
		try {
			sessionFactory.getCurrentSession().update(fool4s2);
			return true;
		} catch (Exception e) {
e.printStackTrace();
return false;
		}
	}

	@Override
	public boolean fooL4S2Truncate(Fool4s2 fool4s2) {
	try {
		sessionFactory.getCurrentSession().createQuery("TRUNCATE TABLE Fool4s2").executeUpdate();
		return true;
	} catch (Exception e) {
e.printStackTrace();
return false;
	}
	}

	@Override
	public Fool4s2 fooL4S2GetById(int id) {
	List<Fool4s2>list=sessionFactory.getCurrentSession().createQuery("FROM Fool4s2 p where p.id=:id").setParameter("id", id).list();
	return list.size()>0?list.get(0):null;
	}
}
