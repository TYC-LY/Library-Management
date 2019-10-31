package service;

import java.util.List;
import entity.Announcement;

public interface AnnouncementService {
	
	public List<Announcement> getAnnouncement();
	
//	public Announcement viewContentById(long id);
	
	public void deleteAnnouncementById(long id);
	
	// 问题：写的太复杂，没必要将title和content传过来
//	public void editAnnouncementTitleAndContent(long id, String title, String content);
	
	public void editAnnouncement(Announcement announcement);
	
	public void addAnnouncement(Announcement announcement);
	
	public Announcement getAnnouncementById(long id);
	
}
