package com.renu.hstu_r_n_board_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.DaoPhyl3s1;
import com.renu.hstu_r_n_board_backend.dto.Phyl3s1;

@Repository
@Transactional
public class DaoImplPhyl3s1 implements DaoPhyl3s1{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean phyL3S1Add(Phyl3s1 phyl3s1) {
		try {
			sessionFactory.getCurrentSession().persist(phyl3s1);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Phyl3s1> phyL3S1GetAll() {
		return sessionFactory.getCurrentSession().createQuery("FROM Phyl3s1", Phyl3s1.class).getResultList();

	}

	@Override
	public boolean phyL3S1Delete(int id) {
		try {
			Phyl3s1 list = sessionFactory.getCurrentSession().load(Phyl3s1.class, id);
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
	public boolean phyL3S1Update(Phyl3s1 phyl3s1) {
		try {
			sessionFactory.getCurrentSession().update(phyl3s1);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean phyL3S1Truncate(Phyl3s1 phyl3s1) {
		try {
			sessionFactory.getCurrentSession().createQuery("TRUNCATE TABLE Phyl3s1").executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Phyl3s1 phyL3S1GetById(int id) {
		List<Phyl3s1> list = sessionFactory.getCurrentSession().createQuery("FROM Phyl3s1 p where p.id=:id")
				.setParameter("id", id).list();
		return list.size() > 0 ? list.get(0) : null;
	}
}
