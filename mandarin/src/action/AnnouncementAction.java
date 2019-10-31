package action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import entity.Announcement;
import entity.Librarian;
import service.AnnouncementService;

public class AnnouncementAction extends BaseAction<Announcement, AnnouncementService>{
	
	private static final long serialVersionUID = 1L;
	private long announcementId;
	private Announcement announcement;
	private List<Announcement> announcements;
	private String state;
	

	public String viewAnnouncement() {
		announcement = this.getService().getAnnouncementById(announcementId);
		return SUCCESS;
	}

	public String viewAnnouncements_Edit() {

		this.setAnnouncements(this.getService().getAnnouncement());
		return SUCCESS;		
	}
	
	public String viewAnnouncements_Delete() {

		this.setAnnouncements(this.getService().getAnnouncement());
		return SUCCESS;		
	}

	
	public String viewAnnouncements() {

		this.setAnnouncements(this.getService().getAnnouncement());
		return SUCCESS;		
	}
	
	public String viewContent() throws Exception{
		
		// 将viewContentById方法统一换为getAnnouncementById
		// 两个方法都是通过id查找数据库中的announcement并返回该announcment
		// 当初在帮助冯憬天解决问题时，未仔细查看AnnouncementServiceImpl中的方法实现
		// 在已有viewContentById方法时，又创建了getAnnouncementById方法，属于交流失误
//		this.getService().viewContentById(this.getModel().getId());
		this.getService().getAnnouncementById(this.getModel().getId());
		return SUCCESS;
		
	}
	
	public String deleteAnnouncement() throws Exception{
		
		this.getService().deleteAnnouncementById(this.getModel().getId());
		this.errorMessage = "success";
		return SUCCESS;
		
	}
	
	public String editAnnouncement() throws Exception{
		
//		String title = this.getModel().getTitle();
//		String content = this.getModel().getContent();
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		Librarian librarian = (Librarian)session.get("librarian");
		if(librarian == null) {
			this.errorMessage = "Fail to edit Announcement! You need to login the librarian account";
			return INPUT;
		}
		this.getModel().setAuthor(librarian.getUsername());
		
		try {
//			this.getService().editAnnouncementTitleAndContent((this.getModel().getId(), title, content);
			this.getService().editAnnouncement(this.getModel());
		}
		catch(Exception ex) {
			this.addActionError(ex.getMessage());
			this.errorMessage="failure";
			return INPUT;
		}
		this.errorMessage = "success";
		return SUCCESS;
	}
	
	public String createAnnouncement() throws Exception{
		
		Map<String, Object> session = ActionContext.getContext().getSession();
		Librarian librarian = (Librarian)session.get("librarian");
		if(librarian == null) {
			this.errorMessage = "Fail to add Announcement! You need to login the librarian account";
			return INPUT;
		}
		this.getModel().setAuthor(librarian.getUsername());
		try {
			this.getService().addAnnouncement(this.getModel());
		}
		catch(Exception ex) {
			this.addActionError(ex.getMessage());
			this.errorMessage="failure";
			System.out.println(this.errorMessage);
			return INPUT;
		}
		this.errorMessage = "Succeed in adding an announcement!";
		System.out.println(this.errorMessage);
		return SUCCESS;
		
	}

	public List<Announcement> getAnnouncements() {
		return announcements;
	}

	public void setAnnouncements(List<Announcement> announcements) {
		this.announcements = announcements;
	}

	public Announcement getAnnouncement() {
		return announcement;
	}

	public void setAnnouncement(Announcement announcement) {
		this.announcement = announcement;
	}

	public long getAnnouncementId() {
		return announcementId;
	}

	public void setAnnouncementId(long announcementId) {
		this.announcementId = announcementId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
