package org.capiskinserver.mailling.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.capiskinserver.mailling.dto.MailContactRequestDto;
import org.capiskinserver.mailling.dto.MailResponseDto;
import org.capiskinserver.security.request.SignUpFormDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;


@Service
public class EmailService {
	
	@Autowired
	private JavaMailSender sender;
	
	@Autowired
	private Configuration config;
	
	public MailResponseDto sendEmail(SignUpFormDto request, Map<String, Object> model) {
		MailResponseDto response = new MailResponseDto();
		MimeMessage message = sender.createMimeMessage();
		try {
			// set mediaType
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			// add attachment
			//helper.addAttachment("logo.png", new ClassPathResource("logo.png"));

			Template t = config.getTemplate("email-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

			helper.setTo(request.getTo());
			helper.setText(html, true);
			helper.setSubject(request.getSubject());
			helper.setFrom(request.getFrom());
			sender.send(message);

			response.setMessage("mail send to : " + request.getTo());
			response.setStatus(Boolean.TRUE);

		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Mail Sending failure : "+e.getMessage());
			response.setStatus(Boolean.FALSE);
		}

		return response;
	}
	
	
	
	public MailResponseDto receiveContactEmail(MailContactRequestDto request, Map<String, Object> model) {
		MailResponseDto response = new MailResponseDto();
		MimeMessage message = sender.createMimeMessage();
		try {
			// set mediaType
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			// add attachment
			//helper.addAttachment("logo.png", new ClassPathResource("logo.png"));

			Template t = config.getTemplate("email-contact-template.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

			helper.setTo("vivaniah@gmail.com");
			helper.setText(html, true);
			helper.setSubject(request.getSubject());
			//helper.setFrom(request.getFrom());
			sender.send(message);

			response.setMessage("mail send to : " + request.getTo());
			response.setStatus(Boolean.TRUE);

		} catch (MessagingException | IOException | TemplateException e) {
			response.setMessage("Mail Sending failure : "+e.getMessage());
			response.setStatus(Boolean.FALSE);
		}

		return response;
	}
	

}