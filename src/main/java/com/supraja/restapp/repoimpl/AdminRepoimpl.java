package com.supraja.restapp.repoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.supraja.restapp.model.Admin;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class AdminRepoimpl 
{
	@Autowired
	EntityManager entityManager;
	
	public List<Integer> getIDList() {
		String jpql="Select a.adminid from Admin a";
		TypedQuery<Integer> query = entityManager.createQuery(jpql,Integer.class);
		return query.getResultList();
	}

	public void save(Admin admin) {
		
		entityManager.merge(admin);
	}

	public List<Admin> findAll() {
		String jpql="From Admin";
		TypedQuery<Admin> query = entityManager.createQuery(jpql,Admin.class);
		return query.getResultList();
	}

	public void deleteById(int adminid) {
		String jpql="delete from Admin where adminid=" +adminid;
		entityManager.createQuery(jpql).executeUpdate();
	}

	public Admin findById(int adminid) {
		return entityManager.find(Admin.class, adminid);
	}

}
