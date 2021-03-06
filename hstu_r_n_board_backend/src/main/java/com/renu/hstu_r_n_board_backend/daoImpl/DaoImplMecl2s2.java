package com.renu.hstu_r_n_board_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.DaoMecl2s2;
import com.renu.hstu_r_n_board_backend.dto.Mecl2s2;

@Repository
@Transactional
public class DaoImplMecl2s2 implements DaoMecl2s2{


	@Autowired
	private SessionFactory sessionFactory;

		@Override
		public boolean mecL2S2Add(Mecl2s2 mecl2s2) {

		try {
			sessionFactory.getCurrentSession().persist(mecl2s2);
			return true;
		} catch (Exception e) {
	e.printStackTrace();
	return false;
		
		}
		}

		@Override
		public List<Mecl2s2> mecL2S2GetAll() {
			return sessionFactory.getCurrentSession().createQuery("FROM Mecl2s2", Mecl2s2.class).getResultList();
			
		}

		@Override
		public boolean mecL2S2Delete(int id) {
	try {
		Mecl2s2 list=sessionFactory.getCurrentSession().load(Mecl2s2.class, id);
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
		public boolean mecL2S2Update(Mecl2s2 mecl2s2) {
		try {
			sessionFactory.getCurrentSession().update(mecl2s2);
			return true;
		} catch (Exception e) {
	e.printStackTrace();
	return false;
		
		}
		}

		@Override
		public boolean mecL2S2Truncate(Mecl2s2 mecl2s2) {
			try {
				sessionFactory.getCurrentSession().createQuery("TRUNCATE TABLE Mecl2s2").executeUpdate();
				return true;
			} catch (Exception e) {
	e.printStackTrace();
	return false;
			}
		}

		@Override
		public Mecl2s2 mecL2S2GetById(int id) {
			List<Mecl2s2>list=sessionFactory.getCurrentSession().createQuery("FROM Mecl2s2 p where p.id=:id").setParameter("id",id).list();
			return list.size()>0?list.get(0):null;
		}

}
