package poly.edu.site.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.edu.dao.UserDao;
import poly.edu.model.User;

/**
 * Servlet implementation class ChangeInformationServlet
 */
@WebServlet("/ChangeInformationServlet")
public class ChangeInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserDao dao = new UserDao();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeInformationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/Admin/users/ChangeInformation.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			doEditProfile(request, response);
			
			
		
	}
    private void doEditProfile(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	req.setCharacterEncoding("utf-8");
    	resp.setCharacterEncoding("utf-8");
    	User user = (User) req.getSession().getAttribute("currentuser");
        try {
            // Cập nhật thông tin người dùng
            user.setFullname(req.getParameter("fullname"));
            user.setEmail(req.getParameter("email"));
            user.setLocation(req.getParameter("location"));
            user.setPassword(req.getParameter("password"));
            user.setAdmin(false);
            dao.update(user);
            req.setAttribute("message", "Thay đổi thông tinthành công!");
            System.out.println("Thay đổi thông tin thành công!");
            req.getRequestDispatcher("/Views/Bai3/ChangeInformation.jsp").forward(req, resp);
        } catch (Exception e) {
            System.out.println("Thay đổi mật khẩu thất bại");
            e.printStackTrace();
        }
    	
    }
}
