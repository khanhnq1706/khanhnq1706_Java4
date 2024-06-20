package poly.edu.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.common.PageInfo;
import poly.edu.common.PageType;
import poly.edu.dao.VideoDao;
import poly.edu.model.Video;
import poly.edu.utils.SessionUtils;
import poly.edu.utils.XCookie;

/**
 * Servlet implementation class LogoffServlet
 */
@WebServlet("/LogoffServlet")
public class LogoffServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 public VideoDao dao = new VideoDao();   
    /**
     * @see HttpServlet#HttpServlet()
     */

public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	XCookie.add("username", getServletInfo(), 0, resp);
	SessionUtils.invalidate(req);
	req.setAttribute("isLogin", false);
	List<Video> listVideo = dao.findAll();
	req.setAttribute("videos", listVideo);
	PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_HOME_PAGE);
	
}

}
