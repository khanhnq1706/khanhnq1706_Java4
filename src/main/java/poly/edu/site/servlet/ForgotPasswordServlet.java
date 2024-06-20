	package poly.edu.site.servlet;
	
	import java.io.IOException;
	import java.util.Properties;
	import java.util.Random;
	
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

import poly.edu.dao.UserDao;
import poly.edu.model.User;
	
	/**
	 * Servlet implementation class ForgotPasswordServlet
	 */
	@WebServlet({"/ForgotPasswordServlet","/SendEmailServlet"})
	public class ForgotPasswordServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	    public UserDao dao = new UserDao() ;  
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	    public ForgotPasswordServlet() {
	        super();
	        // TODO Auto-generated constructor stub
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.getRequestDispatcher("/Admin/user/LoginAndRegister.jsp");
		}
	

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String uri = request.getRequestURI();
			if (uri.contains("SendEmailServlet")) {
		    	String email = request.getParameter("email");
		    	System.out.println(email);
		    	User checkUser = dao.findbyEmail(email);
				if (checkUser != null) {
					String verificationCode = generateRandomPassword();
			        // Lưu mã xác minh vào session
			        request.getSession().setAttribute("verificationCode", verificationCode);
			        sendEmail(request, response, verificationCode);
			       
				}
				else {
					 request.setAttribute("forgotpassnotifice","Email or Username are invalid!");
					 request.getRequestDispatcher("/Admin/user/LoginAndRegister.jsp");
				}
				
			}
			else if(uri.contains("ForgotPasswordServlet")) {
				 String storedCode = (String) request.getSession().getAttribute("verificationCode");
				String userCode = request.getParameter("verifycode");
				try {
					if (storedCode.equals(userCode)) {
			            // Nếu mã xác minh khớp, tạo mật khẩu ngẫu nhiên mới
			            String newPass = generateRandomPassword();
			            // Cập nhật mật khẩu mới và gửi nó qua email
			            String id = request.getParameter("username");
			            User user  = new User();
			            	user=dao.findById(id);
			            	user.setPassword(newPass);
			            	dao.update(user);
			            sendNewPassEmail(request, response, newPass);
			            request.setAttribute("forgotpassnotifice", "Reset mật khẩu thành công!");
			            request.getRequestDispatcher("/Admin/user/LoginAndRegister.jsp");
			        }
					else {
			            request.setAttribute("forgotpassnotifice", "Reset mật khẩu thất bại!");
			            request.getRequestDispatcher("/Admin/user/LoginAndRegister.jsp").forward(request, response);
					}
				} catch (Exception e) {
				e.printStackTrace();
				}
				
				
			}
			request.getRequestDispatcher("/Admin/users/LoginAndRegister.jsp").forward(request, response);
		}
		// Hàm để tạo mật khẩu ngẫu nhiên
	    private String generateRandomPassword() {
	        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	        Random rnd = new Random();
	        StringBuilder sb = new StringBuilder(10);
	        for (int i = 0; i < 10; i++)
	            sb.append(chars.charAt(rnd.nextInt(chars.length())));
	        return sb.toString();
	    }
	    public void sendEmail(HttpServletRequest request, HttpServletResponse response, String verificationCode) throws ServletException, IOException {
			String from = "khanhnqpd07365@fpt.edu.vn";
		    String to = request.getParameter("email");
		    String subject = "Xác nhận reset mật khẩu";
		    
		    // Thiết lập thông tin cho email
		    Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.port", 587);
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true"); 
		    props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		    // Tạo một Session với thông tin đã thiết lập
		    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		        protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication("khanhnqpd07365@fpt.edu.vn", "yesq mfqp rdlw slyl");
		        }
		    });
	
		    try {
		    		 // Tạo một đối tượng Message từ Session
			        MimeMessage message = new MimeMessage(session);
			        message.setFrom(new InternetAddress(from));
			        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			        message.setSubject(subject);
			        message.setText("Mã xác nhận:"+verificationCode);
			        Transport.send(message); 
		    } catch (MessagingException e) {
		        throw new RuntimeException(e);
		    }
		}
	    public void sendNewPassEmail(HttpServletRequest request, HttpServletResponse response, String newPass) throws ServletException, IOException {
			String from = "khanhnqpd07365@fpt.edu.vn";
		    String to = request.getParameter("email");
		    String subject = "Mật khẩu mới";
		    // Thiết lập thông tin cho email
		    Properties props = new Properties();
		    props.put("mail.smtp.host", "smtp.gmail.com");
		    props.put("mail.smtp.port", 587);
		    props.put("mail.smtp.auth", "true");
		    props.put("mail.smtp.starttls.enable", "true"); 
		    props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		    // Tạo một Session với thông tin đã thiết lập
		    Session session = Session.getInstance(props, new javax.mail.Authenticator() {
		        protected PasswordAuthentication getPasswordAuthentication() {
		            return new PasswordAuthentication("khanhnqpd07365@fpt.edu.vn", "yesq mfqp rdlw slyl");
		        }
		    });
	
		    try {
		        // Tạo một đối tượng Message từ Session
		        MimeMessage message = new MimeMessage(session);
		        message.setFrom(new InternetAddress(from));
		        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		        message.setSubject(subject);
		        message.setText("Mã xác nhận:"+newPass);
	
		        // Gửi email
		        Transport.send(message);
	
		        request.setAttribute("forgotpassnotifice","new password sent successfully!");
		        
//		        request.getSession().removeAttribute("verificationCode");
		    } catch (MessagingException e) {
		        throw new RuntimeException(e);
		    }
		}
	}
