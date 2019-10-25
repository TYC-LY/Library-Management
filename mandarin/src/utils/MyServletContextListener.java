package utils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.hibernate.service.ServiceRegistry;
import org.springframework.stereotype.Component;

import utils.MailUtils;

import action.RecordAction;
import dao.RecordDaoImpl;
import entity.Record;
import service.RecordService;
import service.RecordServiceImpl;

@Component
public class MyServletContextListener implements ServletContextListener {
	
	public void contextInitialized(ServletContextEvent arg0) {

		Timer timer = new Timer();
		final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String deadline = sdf.format(new Date());
		
		//借助RecordService完成查询
		RecordServiceImpl recordSer = new RecordServiceImpl();
		RecordDaoImpl recordDao = new RecordDaoImpl();
		recordDao.setSessionFactory(HibernateHelper.getSessionFactory());
		recordSer.setDao(recordDao);
		
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				
				//将所有deadline为当前日期的record取出
				List<Record> records = new ArrayList<Record>();
				records = recordSer.getRecordByDeadline(deadline);
				
				//筛选出借阅记录（即剔除预约记录）
				for (int i = 0; i < records.size(); i++) {
					if (records.get(i).getBorrowState() == false) {
						records.remove(i--);
					}
				}
				
				//为每一条记录发送邮件
				for (Record record : records) {
					String emailMsg = "Dear" + record.getReader().getUsername() + ":<br/>your book " + record.getBook().getTitle() + " is expired， please return book in time.";
					try {
						MailUtils.sendMail(record.getReader().getEmail(), "The book due notice", emailMsg);
					} catch (AddressException e) {
						e.printStackTrace();
					} catch (MessagingException e) {
						e.printStackTrace();
					}
				}
			}
		}, new Date(), 1000*60*60*24);// 测试使用1000 * 1
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

}