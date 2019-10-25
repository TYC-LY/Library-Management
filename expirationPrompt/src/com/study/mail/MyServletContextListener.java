package com.study.mail;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.study.utils.DataSourceUtils;
import com.study.mail.Reader;

public class MyServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent arg0) {

		Timer timer = new Timer();
		final SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		// //精确到秒测试比较麻烦，所以测试时只精确到天
		//final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		final QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
		timer.schedule(new TimerTask() {
			@Override
			public void run() {

				//Calendar cal = Calendar.getInstance();
				//cal.add(Calendar.DATE, -30);
				//Date date = cal.getTime();
				//System.out.println(sdf.format(date));
				// 判断借书的日期
				String deadline = "\"%" + sdf.format(new Date()) + "%\"";
				// borrowTime 容易写成 "%"+sdf.format(new Date())+"%"
				// 导致生成的sql语句为： select * from user where birthday like %11-13%
				// 正常运行的sql语句为： select * from user where birthday like "%11-13%"，
				// 因此使用 ‘\’ 转义符把 " 转化
				String sql = "select * from Record where deadline like " + deadline;
				List<Record> recordList = null;
				try {
					System.out.println(sql);
					recordList = qr.query(sql, new BeanListHandler<Record>(Record.class));
					System.out.println(recordList);
				} catch (SQLException e) {
					e.printStackTrace();
					System.out.println("The connection fails");
				}
				if (recordList != null) {
					for (Record record : recordList) {
						String sql1 = "select * from reader where id like " + record.getReader().getId();
						String sql2 = "select * from book where id like " + record.getBook().getId();
						try {
							List<Reader> readerList = qr.query(sql1, new BeanListHandler<Reader>(Reader.class));
							List<Book> bookList = qr.query(sql2, new BeanListHandler<Book>(Book.class));
							String emailMsg = "Dear" + readerList.get(0).getUsername() + "<br/>your book "
									+ bookList.get(0).getTitle() + " is expired， please return book in time.";
							try {
								MailUtils.sendMail(readerList.get(0).getEmail(), "The book due notice", emailMsg);
							} catch (AddressException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (MessagingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
//                    for (Record record : recordList) {
//                    	String sql1="select * from Record where borrowDate like "+borrowTime;
//                    	List<Reader> readerList = qr.query(sql1, new BeanListHandler<Reader>(Reader.class));
//                        String emailMsg="Dear"+record.getReader().getUserName()+"<br/>your book "+record.getBook().getTitle()+" is expired， please return book in time.";
//                        try {
//                            MailUtils.sendMail(record.getReader().getEmail(), "The book due notice", emailMsg);
//                        } catch (AddressException e) {
//                            e.printStackTrace();
//                            System.out.println("The connection fails");
//                        } catch (MessagingException e) {
//                        	
//                        }
//                    } 
				}
			}
		}, new Date(), 1000*60*60*24);// 测试使用1000 * 1
	}

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
	}

}