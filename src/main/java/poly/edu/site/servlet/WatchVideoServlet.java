package poly.edu.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.common.PageInfo;
import poly.edu.common.PageType;
import poly.edu.dao.VideoDao;
import poly.edu.model.Video;

/**
 * Servlet implementation class WatchVideoServlet
 */
@WebServlet("/WatchVideoServlet")
public class WatchVideoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      VideoDao dao = new VideoDao();
      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WatchVideoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id = request.getParameter("watchvideoid");
		Video video = dao.findById(id);
		request.setAttribute("video", video);
		PageInfo.prepareAndForwardSite(request, response, PageType.STIE_WATCHVIDEO_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
