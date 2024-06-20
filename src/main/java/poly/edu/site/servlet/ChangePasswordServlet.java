package poly.edu.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.common.PageInfo;
import poly.edu.common.PageType;
import poly.edu.dao.UserDao;
import poly.edu.model.User;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserDao dao = new UserDao();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doChangePassword(request, response);

}
	private void doChangePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user = (User) req.getSession().getAttribute("curentuser");
	    try {
	        user.setPassword(req.getParameter("newpass"));
	        dao.update(user);
	        req.setAttribute("message", "Thay đổi mật khẩu thành công!");
	        System.out.println("Thay đổi mật khẩu thành công!");
	        PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_HOME_PAGE);
	    } catch (Exception e) {
	        System.out.println("Thay đổi mật khẩu thất bại");
	        e.printStackTrace();
	    }
		
	}
	}

