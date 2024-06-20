package poly.edu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureParameter;
@NamedStoredProcedureQueries({
@NamedStoredProcedureQuery(name = "Report.favoriteByYear",
procedureName = "spFavoriteByYear",
parameters = {
@StoredProcedureParameter(name="year", type = Integer.class)},
resultClasses = {Report.class})
})

@Entity
public class Report implements Serializable {
	
	@Id
String title;
Long likeCount;
Date newest;
Date oldest;
public Report() {
	
}
public Report(String title, Long likeCount, Date newest, Date oldest) {
	
	this.title = title;
	this.likeCount = likeCount;
	this.newest = newest;
	this.oldest = oldest;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public Long getLikeCount() {
	return likeCount;
}
public void setLikeCount(Long likeCount) {
	this.likeCount = likeCount;
}
public Date getNewest() {
	return newest;
}
public void setNewest(Date newest) {
	this.newest = newest;
}
public Date getOldest() {
	return oldest;
}
public void setOldest(Date oldest) {
	this.oldest = oldest;
}

}
