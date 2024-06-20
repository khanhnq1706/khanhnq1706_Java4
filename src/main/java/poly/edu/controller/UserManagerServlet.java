package poly.edu.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.edu.common.PageInfo;
import poly.edu.common.PageType;
import poly.edu.dao.UserDao;
import poly.edu.dao.UserDao;
import poly.edu.model.User;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet({"/UserManagerServlet","/readuser","/createuser","/updateuser","/deleteuser"})
public class UserManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDao userDao = new UserDao();
	List<User> listuser = new ArrayList<User>();   
    public UserManagerServlet() {
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		fillForm(request, response);
		String uri = request.getRequestURI();
		try {
			if (uri.contains("readuser")) {
				User user = userDao.findById(request.getParameter("id"));
				request.setAttribute("userediting", user);
				fillForm(request, response);
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		
		 if (uri.contains("createuser")) {
			User newuser = new User();
			try {
				BeanUtils.populate(newuser, request.getParameterMap());
				boolean isAdmin = newuser.getAdmin();
				newuser.setAdmin(isAdmin);
				userDao.insert(newuser);
				fillForm(request, response);
				
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if (uri.contains("updateuser")) {
			User newuser = new User();
			try {
				BeanUtils.populate(newuser, request.getParameterMap());
				boolean isAdmin = newuser.getAdmin();
				newuser.setAdmin(isAdmin);
				userDao.update(newuser);
				fillForm(request, response);
//				PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if (uri.contains("deleteuser")) {
			User newuser = new User();
			try {
				BeanUtils.populate(newuser, request.getParameterMap());
				String id = request.getParameter("id");
				userDao.delete(newuser.getUsername());
				fillForm(request, response);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		 userDao.findAll();
		 PageInfo.prepareAndForward(request, response, PageType.USER_MANAGEMENT_PAGE);
		}

	public void fillForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		listuser = userDao.findAll();
		request.setAttribute("listuser", listuser);
	} 

}
