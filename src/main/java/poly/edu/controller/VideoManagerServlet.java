package poly.edu.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.text.View;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;

import poly.edu.common.PageInfo;
import poly.edu.common.PageType;
import poly.edu.dao.VideoDao;
import poly.edu.model.User;
import poly.edu.model.Video;

/**
 * Servlet implementation class VideoManagerServlet
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
@WebServlet({ "/VideoManagerServlet", "/readvideo", "/createvideo", "/updatevideo", "/deletevideo" })
public class VideoManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	VideoDao videoDao = new VideoDao();
	List<Video> listvideo = videoDao.findAll();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VideoManagerServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		fillForm(request, response);
		String uri = request.getRequestURI();
		try {
			if (uri.contains("readvideo")) {
				Video video = videoDao.findById(request.getParameter("videoid"));
				request.setAttribute("managervideos", video);
				fillForm(request, response);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String uri = request.getRequestURI();
		if (uri.contains("createvideo")) {
			Video video = new Video();
			try {
				java.io.File dir = new java.io.File(request.getServletContext().getRealPath("/Images"));
				if (!dir.exists()) {
					dir.mkdir();
				}
				DateConverter dateConverter = new DateConverter();
				dateConverter.setPattern("yyyy-MM-dd");
				// Đăng ký DateConverter với ConvertUtils
				ConvertUtils.register(dateConverter, Date.class);
				Part photoPart = request.getPart("poster");
				java.io.File  photoFile =  new java.io.File(dir,photoPart.getSubmittedFileName());
				 photoPart.write(photoFile.getAbsolutePath());
				String id = request.getParameter("id");
				System.out.println(id);
				BeanUtils.populate(video, request.getParameterMap());
				String active = request.getParameter("active");
				Boolean isActive = Boolean.parseBoolean(active);
				video.setActive(isActive);
				video.setPoster(photoFile.getName());
				videoDao.insert(video);
				fillForm(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (uri.contains("updatevideo")) {
			Video video = new Video();
			try {
				java.io.File dir = new java.io.File(request.getServletContext().getRealPath("/Images"));
				if (!dir.exists()) {
					dir.mkdir();
				}
				DateConverter dateConverter = new DateConverter();
				dateConverter.setPattern("yyyy-MM-dd");
				// Đăng ký DateConverter với ConvertUtils
				ConvertUtils.register(dateConverter, Date.class);
				Part photoPart = request.getPart("poster");
				java.io.File  photoFile =  new java.io.File(dir,photoPart.getSubmittedFileName());
				 photoPart.write(photoFile.getAbsolutePath());
				String id = request.getParameter("id");
				System.out.println(id);
				BeanUtils.populate(video, request.getParameterMap());
				String active = request.getParameter("active");
				Boolean isActive = Boolean.parseBoolean(active);
				video.setPoster(photoFile.getName());
				video.setActive(isActive);
				System.out.println(video);
				System.out.println(video.getPoster());
				videoDao.update(video);
				fillForm(request, response);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (uri.contains("delete")) {
			Video newVideo = new Video();
			try {
				BeanUtils.populate(newVideo, request.getParameterMap());

				videoDao.delete(newVideo.getId());
//				PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
				fillForm(request, response);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		fillForm(request, response);
		PageInfo.prepareAndForward(request, response, PageType.VIDEO_MANAGEMENT_PAGE);
	}

	public void fillForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		listvideo = videoDao.findAll();
		request.setAttribute("listvideo", listvideo);
	}
}
