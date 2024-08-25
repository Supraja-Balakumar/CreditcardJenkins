package com.supraja.restapp.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.supraja.restapp.model.Creditcard;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
@Transactional
public class CreditcardRepoimpl 
{
	 @Autowired
	  private EntityManager entityManager;
	 
//	 @Autowired
//		private JavaMailSender mailSender;
	 
	 
	 public List<Integer> getIDList() {
			String jpql="Select c.cardid from Creditcard c";
			TypedQuery<Integer> query = entityManager.createQuery(jpql,Integer.class);
			return query.getResultList();
		}

		public Creditcard save(Creditcard creditcard) {
			
			return entityManager.merge(creditcard);
		}

		public List<Creditcard> findAll() {
			String jpql="From Creditcard";
			TypedQuery<Creditcard> query = entityManager.createQuery(jpql,Creditcard.class);
			return query.getResultList();
		}

		public void deleteById(int cardid) {
			String jpql="delete from Creditcard where cardid=" +cardid;
			entityManager.createQuery(jpql).executeUpdate();
		}

		public Creditcard findById(int cardid) {
			return entityManager.find(Creditcard.class, cardid);
		}
		
		    public Creditcard findByUserId(int userId) {
		        Creditcard creditcard = null;

		        try {
		            String jpql = "SELECT c FROM Creditcard c WHERE c.user.id = :userId";
		            TypedQuery<Creditcard> query = entityManager.createQuery(jpql, Creditcard.class);
		            query.setParameter("userId", userId);
		            creditcard = query.getSingleResult();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }

		        return creditcard;
		    }

		
//		@SuppressWarnings("unchecked")
//		public List<Creditcard> getPendingTaxReturns() {
//			return entityManager.createQuery("from Creditcard t where t.formStatus = 'Pending'").getResultList();
//		}
//	 
//		@SuppressWarnings("unchecked")
//		public List<Creditcard> getApprovedTaxReturns() {
//			return entityManager.createQuery("from TaxReturn t where t.formStatus = 'Approved'").getResultList();
//		}
//	 
//		@SuppressWarnings("unchecked")
//		public List<Creditcard> getRejectedTaxReturns() {
//			return entityManager.createQuery("from TaxReturn t where t.formStatus = 'Rejected'").getResultList();
//		}
//		
//		public Object getApprovedCount() {
//			Query query = entityManager.createQuery("select count(*) from TaxReturn t where t.formStatus = 'Approved'");
//			return query.getSingleResult();
//		}
//	 
//		public Object getRejectedCount() {
//			Query query = entityManager.createQuery("select count(*) from TaxReturn t where t.formStatus = 'Rejected'");
//			return query.getSingleResult();
//		}
//	 
//		public Object getPendingCount() {
//			Query query = entityManager.createQuery("select count(*) from TaxReturn t where t.formStatus = 'Pending'");
//			return query.getSingleResult();
//		}
//		
//		public boolean updateEmailApproved(int id) {
//			Creditcard creditCard = findTaxReturnById(id);
//	 
//			creditCard.setFormStatus("Approved");
//	 
//			try {
//				if (creditCard != null) {
//					entityManager.persist(creditCard);
//	 
//					String userEmail = creditCard.getUser().getUserEmail();
//					String userName = creditCard.getUser().getUserName();
//	 
//					SimpleMailMessage message = new SimpleMailMessage();
//					message.setFrom("your-email@example.com");
//					message.setTo(userEmail);
//					message.setSubject("Credit card is Approved");
//					message.setText("Dear " + userName + ",\n\n"
//							+ "We are pleased to inform you that your  Credit card has been approved.\n"
//							+ "Please proceed to pay the tax.\n\n" + "Thank you for your attention.\n\n"
//							+ "Best regards,\nYour Company");
//	 
//					mailSender.send(message);
//					return true;
//				}
//	 
//			} catch (Exception e) {
//				System.err.println(e);
//			}
//			return false;
//		}
//	 
//		
//		public boolean updateEmailRejected(int id) {
//			Creditcard creditCard = findTaxReturnById(id);
//			creditCard.setFormStatus("Rejected");
//			
//			try {
//				if (creditCard != null) {
//					String userEmail = creditCard.getUser().getUserEmail();
//					String userName = creditCard.getUser().getUserName();
//	 
//					SimpleMailMessage message = new SimpleMailMessage();
//					message.setFrom("your-email@example.com");
//					message.setTo(userEmail);
//					message.setSubject("Tax Return Rejected");
//					message.setText(
//							"Dear " + userName + ",\n\n" + "We regret to inform you that your credit card has been rejected.\n"
//									+ "Invalidation of  files \n\n" + "If you have any questions, please contact us.\n\n"
//									+ "Best regards,\nYour Company");
//	 
//					mailSender.send(message);
//					return true;
//				}
//			} catch (MailException e) {
//				e.printStackTrace();
//			}
//			return false;
//		}
//	  
	  
}
