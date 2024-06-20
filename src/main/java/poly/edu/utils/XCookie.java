																																																													package poly.edu.utils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.utils.RRShare;

public class XCookie {
	/**
	 * Tạo và gửi cookie về client
	 * 
	 * @param name  tên cookie
	 * @param value giá trị cookie
	 * @param hours thời hạn cookie (giờ)
	 * @return Cookie đã gửi về client
	 */
	public static void add(String name, String value, int hours, HttpServletResponse resp) {
		Cookie cookie = new Cookie(name, value);
		cookie.setMaxAge(hours * 60 * 60);
		cookie.setPath("/");
		
	}

	/**
	 * Đọc giá trị cookie
	 * 
	 * @param name   tên cookie cần đọc
	 * @param defval giá trị mặc định
	 * @return Giá trị cookie hoặc defval nếu cookie không tồn tại
	 */
	public static String get(String name, HttpServletRequest req) {
		Cookie[] cookies = RRShare.request().getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equalsIgnoreCase(name)) {
					return cookie.getValue();
				}
			}
		}
		return null;
	}
}
