package com.renu.hstu_r_n_board_backend.daoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.renu.hstu_r_n_board_backend.dao.RegistrationDao;
import com.renu.hstu_r_n_board_backend.dto.Registration;
//this will be same as in frontend controller if autowire
@Repository
@Transactional
public class RegistrationDaoImpl implements RegistrationDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public boolean addRegistration(Registration registration) {

		try {
			sessionFactory.getCurrentSession().persist(registration);
			return true;

		} catch (Exception e) {
			return false;

		}
	}

	@Override
	public Registration getByEmail(String email) {
		String getEmail="FROM Registration WHERE email=:email";
		try {
			return sessionFactory.getCurrentSession().
					createQuery(getEmail, Registration.class)
					.setParameter("email", email).getSingleResult();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}
