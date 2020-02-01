package com.simplenotes.mail;

import com.simplenotes.cache.CacheProvider;
import com.simplenotes.common.ActiveCodeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Component
public class MailService {
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private CacheProvider cacheProvider;


	@Value("${spring.mail.username}")
	private String from;

	public void sendEmail(String to) {
		String code = ActiveCodeUtils.getActiveCode();
		cacheProvider.set("register-mail", to, code, 60 * 10);
		sendMail(to,"激活账号","简单记账号注册码：" + code);
	}

	private void sendMail(String to, String subject, String content){
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true);
			messageHelper.setFrom(from);
			messageHelper.setTo(to);
			messageHelper.setText(content, true);
			mimeMessage.setSubject(subject);
			mailSender.send(mimeMessage);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
