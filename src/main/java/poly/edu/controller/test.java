package poly.edu.controller;

import java.util.Date;

import poly.edu.dao.VideoDao;
import poly.edu.model.Video;

public class test {
public static void main(String[] args) {
	VideoDao dao =  new  VideoDao();
	Date date =  new Date();
	Video vd  =  new Video();
	vd.setId("0IRXszL56G8");
	vd.setTitle("gg");
	vd.setCategory("g");
	vd.setDateup(date);
	vd.setDuration(12);
	vd.setPoster("ds");
	vd.setDescription("ds");
	dao.update(vd);
	System.out.println(vd);
			
}

}
