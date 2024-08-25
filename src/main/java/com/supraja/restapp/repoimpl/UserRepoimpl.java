package com.supraja.restapp.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.supraja.restapp.model.Loginreg;
import com.supraja.restapp.model.User;
import com.supraja.restapp.repository.UserRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class UserRepoimpl implements UserRepo
{
  @Autowired
  private EntityManager entityManager;
  
  public List<Integer> getIDList() {
		String jpql="Select u.id from User u";
		TypedQuery<Integer> query = entityManager.createQuery(jpql,Integer.class);
		return query.getResultList();
	}

	public User save(User user) {
		return entityManager.merge(user);
	}

	public List<User> findAll() {
		String jpql="From User";
		TypedQuery<User> query = entityManager.createQuery(jpql,User.class);
		return query.getResultList();
	}

	public void deleteById(int id) {
		String jpql="delete from User where id=" +id;
		entityManager.createQuery(jpql).executeUpdate();
	}

	public User findById(int id) {
		return entityManager.find(User.class, id);
	}

//	@Override
//	public User findByEmail(String email) {
////		String jpql = "SELECT u FROM User u WHERE u.email = :email";
//		String sql = "SELECT u FROM User WHERE email = :email";
//		 return  (User) entityManager.createQuery(sql).setParameter("email", email).getSingleResult();
//	}
	
	 public User findByEmail(String email) {
	        try {
	            String jpql = "SELECT u FROM User u WHERE u.email = :email";
	            Query query = entityManager.createQuery(jpql);
	            query.setParameter("email", email);
	            return (User) query.getSingleResult();
	        } catch (NoResultException e) {
	            // Handle the case where no result is found
	            return null; // or throw a custom exception depending on your requirements
	        }
	    }
	 
	 
//	 public User userLogin(String userName, String userPassword) {
//			Query query1 = entityMan.createQuery("from User u where u.userName =?1 and u.userPassword=?2");
//			query1.setParameter(1, userName);
//			query1.setParameter(2, userPassword);
//	 
//			return (User) query1.getSingleResult();
//	 
//		}
	 
}
