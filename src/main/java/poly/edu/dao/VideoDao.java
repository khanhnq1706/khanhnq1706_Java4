package poly.edu.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.TypedQuery;

import poly.edu.utils.JpaUtils;
import poly.edu.model.Report;
import poly.edu.model.Video;
import poly.edu.model.Video;
import poly.edu.model.Video;

public class VideoDao {
	//create
		public Video insert(Video entity) {
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
			 finally {
			    	em.close();
			    }
			
			
		}
		// Find by id
		public Video findById(String id) {
		    EntityManager em = JpaUtils.getEntityManager();
		   
		    try {
		    	 TypedQuery<Video> query = em.createQuery("select u from Video u where u.id = :id", Video.class);
				    query.setParameter("id", id);
		        return query.getSingleResult();
		    } catch (Exception e) {
		    	 System.out.println("khong co du lieu cua Video");
		    	return null;
		       
		    }
		}

		// Update
		public void update(Video entity) {
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
		        Video entity = em.find(Video.class, id);
		        if (entity != null) {
		            em.remove(entity);
		        } 
		        trans.commit();
		    } catch (Exception e) {
		        trans.rollback();
		        throw e;
		    }
		    finally {
		    	em.close();
		    }
		}
		// Truy vấn và xuất tất cả các Video
		public List<Video> findAll() {
		    EntityManager em = JpaUtils.getEntityManager();
		    TypedQuery<Video> query = em.createQuery("SELECT u FROM Video u", Video.class);
		    return query.getResultList();
		}
		// Truy vấn theo từ khóa
		public List<Video> findKeyword(String keyword) {
		    EntityManager em = JpaUtils.getEntityManager();
		    TypedQuery<Video> query = em.createQuery("SELECT u FROM Video u WHERE u.title LIKE :keyword OR u.category LIKE :keyword", Video.class);
		    query.setParameter("keyword", "%" + keyword + "%");
		    return query.getResultList();
		}



		// Truy vấn một trang
		public List<Video> findPage(int page, int size) {
		    EntityManager em = JpaUtils.getEntityManager();
		    TypedQuery<Video> query = em.createQuery("SELECT u FROM Video u", Video.class);
		    query.setFirstResult((page - 1) * size);
		    query.setMaxResults(size);
		    return query.getResultList();
		}
	public List<Video>findFavoriteVideoByTitle(String keyword){
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "SELECT DISTINCT o.video FROM Favorite o WHERE o.video.title LIKE :keyword";
		TypedQuery<Video> query = em.createQuery(jpql,Video.class);
		query.setParameter("keyword", "%" + keyword + "%");
		return query.getResultList();
		
		
	}
	public List<Video> findVideoByFavorite(boolean isFavorite) {
		String jpql;
		if (isFavorite) {
			jpql ="SELECT DISTINCT v FROM Video v WHERE v.favorites IS NOT EMPTY";
		} else {
			jpql ="SELECT DISTINCT v FROM Video v WHERE v.favorites IS EMPTY";
		}
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Video> query = em.createQuery(jpql, Video.class);
		return query.getResultList();
	}
	public List<Report> report(){
		String jpql = "SELECT new poly.edu.model.Report(f.video.title, count(f), max(f.likeDate), min(f.likeDate)) FROM Favorite f GROUP BY f.video.title";
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Report>query= em.createQuery(jpql,Report.class);
		return query.getResultList();
	}
	public List<Video> findFavoriteVideosByDate(Date minDate, Date maxDate) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql="SELECT DISTINCT f.video FROM Favorite f WHERE f.likeDate BETWEEN :minDate AND :maxDate";
		TypedQuery<Video> query = em.createQuery(jpql,Video.class);
		query.setParameter("minDate", minDate);
		query.setParameter("maxDate", maxDate);
		return query.getResultList();
		
	}
	public List<Video> findFavoriteVideosInMonths(List<Integer> months) {
		EntityManager em = JpaUtils.getEntityManager();
		TypedQuery<Video> query = em.createNamedQuery("Video.findInMonths",Video.class);
		query.setParameter("months", months);
		return query.getResultList();
		
	}
	public List<Report> findFavoriteVideosByYear(Integer year) {
	    EntityManager em = JpaUtils.getEntityManager();
	    StoredProcedureQuery query = em.createNamedStoredProcedureQuery("Report.favoriteByYear");
	    query.setParameter("year", year);
	    return query.getResultList();
	}
}
