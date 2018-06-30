package com.renu.hstu_r_n_board_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.DaoMatl2s1;
import com.renu.hstu_r_n_board_backend.dto.Matl2s1;

@Repository
@Transactional
public class DaoImplMatl2s1 implements DaoMatl2s1{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean matL2S1Add(Matl2s1 matl2s1) {
		try {
			sessionFactory.getCurrentSession().persist(matl2s1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}

	}

	@Override
	public List<Matl2s1> matL2S1GetAll() {
		return sessionFactory.getCurrentSession().createQuery("FROM Matl2s1", Matl2s1.class).getResultList();
	}

	@Override
	public boolean matL2S1Delete(int id) {
		try {
			Matl2s1 list = sessionFactory.getCurrentSession().load(Matl2s1.class, id);
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
	public boolean matL2S1Update(Matl2s1 matl2s1) {
		try {
			sessionFactory.getCurrentSession().update(matl2s1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean matL2S1Truncate(Matl2s1 matl2s1) {
		try {
			sessionFactory.getCurrentSession().createQuery("TRUNCATE TABLE Matl2s1").executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Matl2s1 matL2S1GetById(int id) {

		List<Matl2s1> list = sessionFactory.getCurrentSession().createQuery("FROM Matl2s1 p where p.id=:id")
				.setParameter("id", id).list();
		return list.size() > 0 ? list.get(0) : null;

	}

}
