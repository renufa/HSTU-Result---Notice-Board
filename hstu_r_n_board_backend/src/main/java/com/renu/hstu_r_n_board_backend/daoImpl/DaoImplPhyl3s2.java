package com.renu.hstu_r_n_board_backend.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.DaoPhyl3s2;
import com.renu.hstu_r_n_board_backend.dto.Phyl3s2;

@Repository
@Transactional
public class DaoImplPhyl3s2 implements DaoPhyl3s2{

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean phyL3S2Add(Phyl3s2 phyl3s2) {
		try {
			sessionFactory.getCurrentSession().persist(phyl3s2);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Phyl3s2> phyL3S2GetAll() {
		return sessionFactory.getCurrentSession().createQuery("FROM Phyl3s2", Phyl3s2.class).getResultList();

	}

	@Override
	public boolean phyL3S2Delete(int id) {
		try {
			Phyl3s2 list = sessionFactory.getCurrentSession().load(Phyl3s2.class, id);
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
	public boolean phyL3S2Update(Phyl3s2 phyl3s2) {
		try {
			sessionFactory.getCurrentSession().update(phyl3s2);
			return true;
		} catch (Exception e) {

			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean phyL3S2Truncate(Phyl3s2 phyl3s2) {
		try {
			sessionFactory.getCurrentSession().createQuery("TRUNCATE TABLE Phyl3s2").executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Phyl3s2 phyL3S2GetById(int id) {
		List<Phyl3s2> list = sessionFactory.getCurrentSession().createQuery("FROM Phyl3s2 p where p.id=:id")
				.setParameter("id", id).list();
		return list.size() > 0 ? list.get(0) : null;
	}

}
