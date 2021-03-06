package com.renu.hstu_r_n_board_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.DaoPhyl4s1;
import com.renu.hstu_r_n_board_backend.dto.Phyl4s1;

@Repository
@Transactional
public class DaoImplPhyl4s1 implements DaoPhyl4s1{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean phyL4S1Add(Phyl4s1 phyl4s1) {
		try {
			sessionFactory.getCurrentSession().persist(phyl4s1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Phyl4s1> phyL4S1GetAll() {
		return sessionFactory.getCurrentSession().createQuery("FROM Phyl4s1", Phyl4s1.class).getResultList();

	}

	@Override
	public boolean phyL4S1Delete(int id) {
		try {
			Phyl4s1 list = sessionFactory.getCurrentSession().load(Phyl4s1.class, id);
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
	public boolean phyL4S1Update(Phyl4s1 phyl4s1) {
		try {
			sessionFactory.getCurrentSession().update(phyl4s1);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean phyL4S1Truncate(Phyl4s1 phyl4s1) {
		try {
			sessionFactory.getCurrentSession().createQuery("TRUNCATE TABLE Phyl4s1").executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Phyl4s1 phyL4S1GetById(int id) {
		List<Phyl4s1> list = sessionFactory.getCurrentSession().createQuery("FROM Phyl4s1 p where p.id=:id")
				.setParameter("id", id).list();
		return list.size() > 0 ? list.get(0) : null;
	}
}
