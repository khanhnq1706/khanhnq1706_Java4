package poly.edu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.common.PageInfo;
import poly.edu.common.PageType;
import poly.edu.dao.VideoDao;
import poly.edu.model.User;
import poly.edu.model.Video;

/**
 * Servlet implementation class HomeServLet
 */
@WebServlet({"/HomeServLet"})
public class HomeServLet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public VideoDao dao = new VideoDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServLet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Video> listVideo = dao.findAll();
		request.setAttribute("videos", listVideo);
		 request.getSession().getAttribute("curentuser");
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_HOME_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
