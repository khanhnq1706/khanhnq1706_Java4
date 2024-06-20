package poly.edu.controller;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.common.PageInfo;
import poly.edu.common.PageType;
import poly.edu.dao.FavoriteDao;
import poly.edu.dao.VideoDao;
import poly.edu.model.Favorite;
import poly.edu.model.User;
import poly.edu.model.Video;

/**
 * Servlet implementation class FavoriteVideoColtroller
 */
@WebServlet({"/FavoriteVideos","/ShareVideo"})
public class FavoriteVideoColtroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
      FavoriteDao dao = new FavoriteDao(Favorite.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FavoriteVideoColtroller() {
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		User user = (User) request.getSession().getAttribute("curentuser");
		System.out.println(user.getUsername());
		request.setAttribute("user", user);
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_FAVORITEVIDEOS_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
	}

}
