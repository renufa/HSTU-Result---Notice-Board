package com.renu.hstu_r_n_board_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.DaoMarl3s1;
import com.renu.hstu_r_n_board_backend.dto.Marl3s1;

@Repository
@Transactional
public class DaoImplMarl3s1 implements DaoMarl3s1{

	@Autowired
	private SessionFactory sessionFactory;

		@Override
		public boolean marL3S1Add(Marl3s1 marl3s1) {
			try {
				sessionFactory.getCurrentSession().persist(marl3s1);
				return true;
			} catch (Exception e) {
	         e.printStackTrace();
	         return false;
			
			}
		}

		@Override
		public List<Marl3s1> marL3S1GetAll() {
			return sessionFactory.getCurrentSession().createQuery("FROM Marl3s1", Marl3s1.class).getResultList();
			
		}

		@Override
		public boolean marL3S1Delete(int id) {
			try {
				Marl3s1 list=sessionFactory.getCurrentSession().load(Marl3s1.class, id);
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
		public boolean marL3S1Update(Marl3s1 marl3s1) {
			try {
				sessionFactory.getCurrentSession().update(marl3s1);
				return true;
			} catch (Exception e) {
	      e.printStackTrace();
	      return false;
			
			}
		}

		@Override
		public boolean marL3S1Truncate(Marl3s1 marl3s1) {
	         try {
				sessionFactory.getCurrentSession().createQuery("TRUNCATE TABLE Marl3s1").executeUpdate();
				return true;
			} catch (Exception e) {

			e.printStackTrace();
			return false;
			}
		
		}

		@Override
		public Marl3s1 marL3S1GetById(int id) {
			List<Marl3s1>list=sessionFactory.getCurrentSession().createQuery("FROM Marl3s1 p where p.id=:id").setParameter("id", id).list();
			return list.size()>0?list.get(0):null;
		}
		

}
