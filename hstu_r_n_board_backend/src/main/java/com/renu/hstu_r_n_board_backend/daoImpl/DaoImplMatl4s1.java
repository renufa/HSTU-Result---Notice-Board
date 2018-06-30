package com.renu.hstu_r_n_board_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.DaoMatl4s1;
import com.renu.hstu_r_n_board_backend.dto.Matl3s1;
import com.renu.hstu_r_n_board_backend.dto.Matl4s1;

@Repository
@Transactional
public class DaoImplMatl4s1 implements DaoMatl4s1 {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean matL4S1Add(Matl4s1 matl4s1) {
		try {
			sessionFactory.getCurrentSession().persist(matl4s1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	@Override
	public List<Matl4s1> matL4S1GetAll() {
		return sessionFactory.getCurrentSession().createQuery("FROM Matl4s1", Matl4s1.class).getResultList();
	}

	@Override
	public boolean matL4S1Delete(int id) {
		try {
			Matl4s1 list = sessionFactory.getCurrentSession().load(Matl4s1.class, id);
			if (list != null) {
				sessionFactory.getCurrentSession().delete(list);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean matL4S1Update(Matl4s1 matl4s1) {
		try {
			sessionFactory.getCurrentSession().update(matl4s1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean matL4S1Truncate(Matl4s1 matl4s1) {
		try {
			sessionFactory.getCurrentSession().createQuery("TRUNCATE TABLE Matl4s1").executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Matl4s1 matL4S1GetById(int id) {

		List<Matl4s1> list = sessionFactory.getCurrentSession().createQuery("FROM Matl4s1 p where p.id=:id")
				.setParameter("id", id).list();
		return list.size() > 0 ? list.get(0) : null;

	}
}
