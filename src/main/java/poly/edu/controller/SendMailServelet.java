package poly.edu.controller;

import java.io.IOException;
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

/**
 * Servlet implementation class SendMailServelet
 */
@WebServlet("/SendMailServelet")
public class SendMailServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SendMailServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	request.getRequestDispatcher("Views/SendMail/SendMail.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String from = request.getParameter("from");
	    String to = request.getParameter("to");
	    String subject = request.getParameter("subject");
	    String body = request.getParameter("body");

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
	        message.setText(body);

	        // Gửi email
	        Transport.send(message);

	        response.getWriter().append("Email sent successfully");
	    } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    }
	   
	}

}
