package poly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;


import poly.edu.utils.JpaUtils;

public abstract class AbstractEntityDao<T> {
private Class<T> entityClass;
public AbstractEntityDao(Class<T> cls) {
	
	this.entityClass=cls;
	
}
public void insert(T entity) {
	EntityManager em = JpaUtils.getEntityManager();
	EntityTransaction trans = em.getTransaction();
	try {
		trans.begin();
		em.persist(entity);
		trans.commit();
	} catch (Exception e) {
		e.printStackTrace();
		trans.rollback();
		throw e;
	} finally {
		em.close();
	}	
}
public void update(T entity) {
	EntityManager em = JpaUtils.getEntityManager();
	EntityTransaction trans = em.getTransaction();
	try {
		trans.begin();
		em.merge(entity);
		trans.commit();
	} catch (Exception e) {
		e.printStackTrace();
		trans.rollback();
		throw e;
	} finally {
		em.close();
	}	
}
public void delete(Object id) {
	EntityManager em = JpaUtils.getEntityManager();
	EntityTransaction trans = em.getTransaction();
	try {
		trans.begin();
		T entity = em.find(entityClass, id);
		em.remove(entity);
		trans.commit();
	} catch (Exception e) {
		e.printStackTrace();
		trans.rollback();
		throw e;
	} finally {
		em.close();
	}	
}
public T findById(Object id) {
	EntityManager em = JpaUtils.getEntityManager();
		try {
			T entity = em.find(entityClass, id);
			return entity;
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;	
}
public Long count() {
	
	EntityManager em = (EntityManager) JpaUtils.getEntityManager();
    try {
    	CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
    	Root<T> rt = cq.from(entityClass);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq); // Use createQuery(CriteriaQuery)
        return (Long) q.getSingleResult();
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		em.close();
	}
	return null;
	
	
}
public List<T> findAll(boolean all, int firstResult, int maxResult){
	EntityManager em = (EntityManager) JpaUtils.getEntityManager();
	try {
		CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
		Root<T> rt = cq.from(entityClass);
	    cq.select(em.getCriteriaBuilder().count(rt));
	    Query q = em.createQuery(cq); // Use createQuery(CriteriaQuery)
	    if (!all) {
			q.setFirstResult(firstResult);
			q.setMaxResults(maxResult);
		}
	    return q.getResultList();
	} catch (Exception e) {
		// TODO: handle exception
	}finally {
		em.close();
	}
	return null;
}

}
