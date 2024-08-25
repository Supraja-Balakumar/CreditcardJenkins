package com.supraja.restapp.repoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.supraja.restapp.model.Loginreg;
import com.supraja.restapp.model.User;
import com.supraja.restapp.repository.LoginregRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class LoginregRepoimpl implements LoginregRepo {
	@Autowired
	private EntityManager entityManager;

	@Override
	public String save(Loginreg loginreg) {
		if(loginreg != null) {
			entityManager.merge(loginreg);
			return "success";
			}
			else {
				return "Fail to Add";
			}
	}

	@Override
	public Loginreg findByUsername(String username) {
		String jpql = "SELECT u FROM Loginreg u WHERE u.username = :username";
		   TypedQuery<Loginreg> query = entityManager.createQuery(jpql, Loginreg.class);
		   query.setParameter("username", username);
		return null;
	}
}
