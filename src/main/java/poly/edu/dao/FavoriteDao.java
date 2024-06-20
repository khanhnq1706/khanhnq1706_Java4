package poly.edu.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import javax.persistence.EntityManager;
import poly.edu.utils.JpaUtils;
import poly.edu.model.Favorite;
import poly.edu.model.User;
import poly.edu.model.Video;

public class FavoriteDao extends AbstractEntityDao<Favorite> {
	public FavoriteDao(Class<Favorite> cls) {
		super(cls);
		// TODO Auto-generated constructor stub
	}
@Override
public Favorite findById(Object id) {
	
	return super.findById(id);
}
public List<Favorite> findByUsername(String username){
    EntityManager em = JpaUtils.getEntityManager();
    String jpql = "SELECT f FROM Favorite f WHERE f.user.username = :username";
    TypedQuery<Favorite> query = em.createQuery(jpql,Favorite.class);
    query.setParameter("username", username);
    return query.getResultList();
}
	public List<Favorite> findFavoritesByVideoTitle(String keyword){
        EntityManager em = (EntityManager) JpaUtils.getEntityManager();
        String jpql = "SELECT o FROM Favorite o WHERE o.video.title LIKE :keyword";
        TypedQuery<Favorite> query = (TypedQuery<Favorite>) em.createQuery(jpql,Favorite.class);
        query.setParameter("keyword", "%" + keyword + "%");
        return query.getResultList();
    }
	public List<Video> findAllFavoriteVideo(){
        EntityManager em = (EntityManager) JpaUtils.getEntityManager();
        String jpql = "SELECT o FROM Video o join o.favorites f join f.user";
        TypedQuery<Video> query = (TypedQuery<Video>) em.createQuery(jpql,Video.class);
       
        return query.getResultList();
    }
	public List<User> findAllFavoriteUser(){
        EntityManager em = (EntityManager) JpaUtils.getEntityManager();
        String jpql = "SELECT o FROM User o join o.favorites f join f.video";
        TypedQuery<User> query = (TypedQuery<User>) em.createQuery(jpql,User.class);
        return query.getResultList();
    }
}