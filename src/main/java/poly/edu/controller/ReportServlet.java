package poly.edu.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.common.PageInfo;
import poly.edu.common.PageType;
import poly.edu.dao.FavoriteDao;
import poly.edu.model.Favorite;
import poly.edu.model.User;
import poly.edu.model.Video;
import poly.edu.utils.JpaUtils;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet({"/ReportServlet","/FindFavoriteByTitle"})
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		fillTable(request, response);
	
		PageInfo.prepareAndForward(request, response, PageType.REPORT_MANAGEMENT_PAGE); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("FindFavoriteByTitle")) {
			fillTableTilte(request, response);
			PageInfo.prepareAndForward(request, response, PageType.REPORT_MANAGEMENT_PAGE);
		}
		
	}
	protected void fillTable(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			EntityManager em = (EntityManager) JpaUtils.getEntityManager();
	        String jpql = "SELECT o FROM Video o join o.favorites f join f.user u";
	        TypedQuery<Video> query = (TypedQuery<Video>) em.createQuery(jpql,Video.class);
	       
	        request.setAttribute("reports", query.getResultList()) ;
	        
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	protected void fillTableTilte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        String id = request.getParameter("title");
			EntityManager em = (EntityManager) JpaUtils.getEntityManager();
	        String jpql = "SELECT u FROM User u join u.favorites f join f.video v WHERE v.title like:title";
	        TypedQuery<User> query = (TypedQuery<User>) em.createQuery(jpql,User.class);
	       query.setParameter("title","%"+ id +"%");
	        request.setAttribute("hhh", query.getResultList()) ;
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
