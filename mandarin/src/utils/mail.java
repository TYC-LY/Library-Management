package utils;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class mail {
	public static void main(String email) throws AddressException, MessagingException {
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");// 杩炴帴鍗忚 
		properties.put("mail.smtp.host", "smtp.qq.com");// 涓绘満鍚�
		properties.put("mail.smtp.port", 465);// 绔彛鍙�
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.ssl.enable", "true");// 璁剧疆鏄惁浣跨敤ssl瀹夊叏杩炴帴
		properties.put("mail.debug", "true");// 璁剧疆鏄惁鏄剧ずdebug淇℃伅 true 浼氬湪鎺у埗鍙版樉绀虹浉鍏充俊鎭�
// 寰楀埌鍥炶瘽瀵硅薄
		Session session = Session.getInstance(properties);
// 鑾峰彇閭欢瀵硅薄
		Message message = new MimeMessage(session);
// 璁剧疆鍙戜欢浜洪偖绠卞湴鍧�
		message.setFrom(new InternetAddress("2879313030@qq.com"));
// 璁剧疆鏀朵欢浜哄湴鍧�
		message.setRecipients(RecipientType.TO, new InternetAddress[] { new InternetAddress(email) });
// 璁剧疆閭欢鏍囬
		message.setSubject("娉ㄥ唽纭");
// 璁剧疆閭欢鍐呭
		message.setText("鎮ㄧ殑閭" + "1429111498@qq.com" + "宸叉垚鍔熼噸缃瘑鐮侊紝鍒濆瀵嗙爜涓�" + "123456");
// 寰楀埌閭樊瀵硅薄
		Transport transport = session.getTransport();
// 杩炴帴鑷繁鐨勯偖绠辫处鎴�
		transport.connect("2879313030@qq.com", "adsjkqncbjzsdfcc");// 瀵嗙爜涓哄垰鎵嶅緱鍒扮殑鎺堟潈鐮�
// 鍙戦�侀偖浠�
		transport.sendMessage(message, message.getAllRecipients());
	}
}