package service;

import java.util.List;
import java.util.TimeZone;

import entity.Announcement;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AnnouncementServiceImpl extends BaseService<Announcement> implements AnnouncementService{
	
	
	public List<Announcement> getAnnouncement(){
		List<Announcement> announcements = this.getDao().findAll();
		return  announcements;
	}
//	
//	public Announcement viewContentById(long id) {
//		Announcement announcement = this.getDao().get(id);
//		return announcement;
//	}
	
	public void deleteAnnouncementById(long id) {
		this.getDao().delete(id);
	}
	
	// 问题：写的太复杂，没必要将title和content传过来
//	public void editAnnouncementTitleAndContent(long id, String title, String content) {
//		Announcement announcement = this.getDao().get(id);
//		announcement.setTitle(title);
//		announcement.setContent(content);
//		this.getDao().merge(announcement);
//	}
	
	public void editAnnouncement(Announcement announcement) {
		this.getDao().merge(announcement);
	}
	
	public void addAnnouncement(Announcement announcement) {
//		SimpleDateFormat bjsdf =   new SimpleDateFormat( "yyyy/MM/dd  HH:mm:ss" ); 
//		bjsdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
//		announcement.setCreateDate(bjsdf.format(new Date()));
//		announcement.setAuthor("pzy");
		this.getDao().save(announcement);
	}
	
	public Announcement getAnnouncementById(long id) {
		Announcement announcement = this.getDao().getSingle("id", id);
		return announcement;
	}

}
