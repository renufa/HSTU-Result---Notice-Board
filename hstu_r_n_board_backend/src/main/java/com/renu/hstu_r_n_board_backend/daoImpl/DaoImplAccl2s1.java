package com.renu.hstu_r_n_board_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.DaoAccl2s1;
import com.renu.hstu_r_n_board_backend.dto.Accl2s1;

@Repository
@Transactional
public class DaoImplAccl2s1 implements DaoAccl2s1{

	@Autowired
	private SessionFactory sessionFactory;
		@Override
		public boolean accL2S1Add(Accl2s1 accl2s1) {
			try {
				sessionFactory.getCurrentSession().persist(accl2s1);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		@Override
		public List<Accl2s1> accL2S1GetAll() {
			return sessionFactory.getCurrentSession().createQuery("FROM Accl2s1", Accl2s1.class).getResultList();
		}

		@Override
		public boolean accL2S1Delete(int id) {
			try {
				Accl2s1 list=sessionFactory.getCurrentSession().load(Accl2s1.class, id);
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
		public boolean accL2S1Update(Accl2s1 accl2s1) {
			try {
				sessionFactory.getCurrentSession().update(accl2s1);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		@Override
		public boolean accL2S1Truncate(Accl2s1 accl2s1) {
			try {
				sessionFactory.getCurrentSession().createQuery("TRUNCATE TABLE Accl2s1").executeUpdate();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		@Override
		public Accl2s1 accL2S1GetById(int id) {
			List<Accl2s1>list=sessionFactory.getCurrentSession().createQuery("FROM Accl2s1 p where p.id=:id").setParameter("id",id).list();
			return list.size()>0?list.get(0):null;
		}


}
