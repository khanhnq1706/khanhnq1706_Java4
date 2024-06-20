package poly.edu.dao;

import java.util.List;

import javax.management.RuntimeErrorException;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import poly.edu.model.User;
import poly.edu.utils.JpaUtils;

public class UserDao {
	//create
	public User insert(User entity) {
		EntityManager em = JpaUtils.getEntityManager();
		EntityTransaction trans = em.getTransaction();
		try {
			trans.begin();
			em.persist(entity);
			trans.commit();
			return entity;
		} catch (Exception e) {
			trans.rollback();
			throw e;
		}	
	}
	// Find by id
	public User findById(String id) {
	    EntityManager em = JpaUtils.getEntityManager();
	    TypedQuery<User> query = em.createQuery("select u from User u where u.username = :id", User.class);
	    query.setParameter("id", id);
	    try {
	        return query.getSingleResult();
	    } catch (NoResultException e) {
	    	 System.out.println("khong co du lieu cua user");
	    	return null;
	       
	    }
	    finally {
	    	em.close();
	    }
	}
	//Truy vấn theo id và password
	public User findOne(String username, String password) {
	 EntityManager em = JpaUtils.getEntityManager();

	 	 TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.username = :username AND u.password = :password", User.class);
	 	    query.setParameter("username", username);
	 	    query.setParameter("password", password);
	 	     return query.getSingleResult(); 	  
	}
	public User findbyEmail(String email) {
		 EntityManager em = JpaUtils.getEntityManager();

		 	 TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email", User.class);
		 	    query.setParameter("email", email);
		 	     return query.getSingleResult(); 	  
		}
	public User findbyEmailAndUsername(String email, String username) {
		 EntityManager em = JpaUtils.getEntityManager();

		 	 TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.email = :email And u.username = :username", User.class);
		 	    query.setParameter("email", email);
		 	    query.setParameter("username", username);
		 	     return query.getSingleResult(); 	  
		}
	// Update
	public void update(User entity) {
	    EntityManager em = JpaUtils.getEntityManager();
	    EntityTransaction trans = em.getTransaction();
	    try {
	        trans.begin();
	        em.merge(entity);
	        trans.commit();
	    } catch (Exception e) {
	        trans.rollback();
	        throw e;
	    }
	    finally {
	    	em.close();
	    }
	}

	// Delete
	public void delete(String id) {
	    EntityManager em = JpaUtils.getEntityManager();
	    EntityTransaction trans = em.getTransaction();
	    try {
	        trans.begin();
	        User entity = em.find(User.class, id);
	        if (entity != null) {
	            em.remove(entity);
	        } 
	        trans.commit();
	    } catch (Exception e) {
	        trans.rollback();
	        throw e;
	    }
	}
	// Truy vấn và xuất tất cả các User
	public List<User> findAll() {
	    EntityManager em = JpaUtils.getEntityManager();
	    TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
	    return query.getResultList();
	}

	// Truy vấn theo vai trò
	public List<User> findByRole(boolean role) {
	    EntityManager em = JpaUtils.getEntityManager();
	    TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.role = :role", User.class);
	    query.setParameter("role", role);
	    return query.getResultList();
	}

	// Truy vấn theo từ khóa
	public List<User> findKeyword(String keyword) {
	    EntityManager em = JpaUtils.getEntityManager();
	    TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.name LIKE :keyword OR u.email LIKE :keyword", User.class);
	    query.setParameter("keyword", "%" + keyword + "%");
	    return query.getResultList();
	}



	// Truy vấn một trang
	public List<User> findPage(int page, int size) {
	    EntityManager em = JpaUtils.getEntityManager();
	    TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
	    query.setFirstResult((page - 1) * size);
	    query.setMaxResults(size);
	    return query.getResultList();
	}
	public static void main(String[] args) {

	}
}
