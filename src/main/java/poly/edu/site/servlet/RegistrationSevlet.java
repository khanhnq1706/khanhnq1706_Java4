package poly.edu.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import poly.edu.common.PageInfo;
import poly.edu.common.PageType;
import poly.edu.dao.UserDao;
import poly.edu.dao.VideoDao;
import poly.edu.domain.LoginForm;
import poly.edu.model.User;
import poly.edu.model.Video;
import poly.edu.utils.RRShare;
import poly.edu.utils.SessionUtils;
import poly.edu.utils.XCookie;

/**
 * Servlet implementation class RegistrationSevlet
 */
@WebServlet({"/RegistrationSevlet","/Login","/LoginAndRegister"})
public class RegistrationSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UserDao dao = new UserDao();   
    public VideoDao videodao = new VideoDao();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationSevlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RRShare.add(request, response);
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
//		String username = XCookie.get("username", request);
//		if (username==null) {
//			PageInfo.prepareAndForwardSite(request, response, PageType.SITE_REGISTRATION_PAGE);
//		}
//		SessionUtils.add(request, "username", username);
		PageInfo.prepareAndForwardSite(request, response, PageType.SITE_HOME_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
	if (uri.contains("RegistrationSevlet")) {
		try {
			User user = new User();
			user.setAdmin(false);
			BeanUtils.populate(user, request.getParameterMap());
				dao.insert(user);
			request.getRequestDispatcher("/Admin/users/LoginAndRegister.jsp").forward(request, response);
			request.setAttribute("singupmessage", "Đăng kí thành công!");
			
		} catch (Exception e) {
			request.getRequestDispatcher("/Admin/users/LoginAndRegister.jsp").forward(request, response);
			e.printStackTrace();
			request.setAttribute("singupmessage","Đăng kí thất bại");
		}	
	}
	else if (uri.contains("Login")) {
		doLogin(request, response);
        request.getRequestDispatcher("/Admin/users/LoginAndRegister.jsp").forward(request, response);
	}
		

	}
	private void doLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			LoginForm form = new LoginForm();
			User users = new  User();
			BeanUtils.populate(users, req.getParameterMap());
			BeanUtils.populate(form, req.getParameterMap());
			User user = dao.findOne(users.getUsername(),users.getPassword());
			if (user != null ) {
		        // Lưu trữ thông tin người dùng vào session
				SessionUtils.add(req, "curentuser", user);
		        SessionUtils.add(req, "username", user.getUsername());
		        if (form.isRemember()) {
					XCookie.add("username", form.getUsername(), 12, resp);
				}
		        else {
		        	XCookie.add("username", form.getUsername(), 0, resp);
				}
		        req.setAttribute("isLogin", true);
		        req.setAttribute("name", user.getFullname());
		        System.out.println(user.getUsername());
		        String successMessage = "Đăng nhập thành công!";
		        req.setAttribute("message", successMessage);
		        List<Video> listVideo = videodao.findAll();
		        req.setAttribute("videos", listVideo);
		        PageInfo.prepareAndForwardSite(req, resp, PageType.SITE_HOME_PAGE);
		        
		       		    } else {
		        String errorMessage = "Đăng nhập thất bại!";
		        req.setAttribute("message", errorMessage);
				req.getRequestDispatcher("/Admin/users/LoginAndRegister.jsp").forward(req, resp);
		        
		    }
		} catch (Exception e) {
			String errorMessage = "Đăng nhập thất bại!";
	        req.setAttribute("message", errorMessage);
			e.printStackTrace();
		}
		
			
		}

}
