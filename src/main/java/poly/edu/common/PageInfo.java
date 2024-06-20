package poly.edu.common;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageInfo {
public static Map<PageType, PageInfo> pageRoute = new HashMap<PageType, PageInfo>();
	static {
		pageRoute.put(PageType.USER_MANAGEMENT_PAGE, new PageInfo("User Management","/Admin/users/CustomerManager.jsp",null));
		pageRoute.put(PageType.VIDEO_MANAGEMENT_PAGE, new PageInfo("Video Management","/Admin/videos/VideosManager.jsp",null));
		pageRoute.put(PageType.REPORT_MANAGEMENT_PAGE, new PageInfo("Report Management","/Admin/reports/Report.jsp",null));
		pageRoute.put(PageType.SITE_HOME_PAGE, new PageInfo("List Video","/site/Items.jsp",null));
		pageRoute.put(PageType.SITE_REGISTRATION_PAGE, new PageInfo("LoginAndRegister","/Admin/users/LoginAndRegister.jsp",null));
		pageRoute.put(PageType.STIE_WATCHVIDEO_PAGE, new PageInfo("WatchVideo","/video/WatchVideo.jsp",null));
		pageRoute.put(PageType.SITE_FAVORITEVIDEOS_PAGE,new PageInfo("FavoriteVideos","/video/FavoriteItems.jsp", null));
		pageRoute.put(PageType.FINDFAVORITEBYTITLE_PAGE, new PageInfo("FINDFAVORITEBYTITLE_PAGE","/Admin/reports/FindFavoriteByTitle.jsp",null));
	}
	public static void prepareAndForward(HttpServletRequest rq, HttpServletResponse rsp,PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		rq.setAttribute("page", page);
		rq.getRequestDispatcher("/Admin/layout.jsp").forward(rq, rsp);
		
	}
	public static void prepareAndForwardSite(HttpServletRequest rq, HttpServletResponse rsp,PageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		rq.setAttribute("page", page);
		rq.getRequestDispatcher("/site/layout.jsp").forward(rq, rsp);
		
	}

private String title;
private String contentUrl;
private String scriptUrl;

public PageInfo() {
	super();
}
public PageInfo(String title, String contentUrl, String scriptUrl) {
	this.title = title;
	this.contentUrl = contentUrl;
	this.scriptUrl = scriptUrl;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContentUrl() {
	return contentUrl;
}
public void setContentUrl(String contentUrl) {
	this.contentUrl = contentUrl;
}
public String getScriptUrl() {
	return scriptUrl;
}
public void setScriptUrl(String scriptUrl) {
	this.scriptUrl = scriptUrl;
}

}