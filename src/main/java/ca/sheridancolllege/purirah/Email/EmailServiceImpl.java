package ca.sheridancolllege.purirah.Email;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import jakarta.mail.internet.MimeMessage;

@Component
public class EmailServiceImpl {

	@Autowired
 private JavaMailSender emailSender;
	@Autowired
	private TemplateEngine templateEngine;
	
	public void sendMailWithInline(String to, String subject,String name,
			Object messageBody,String footer)throws Exception {
		
		//import org.thymeleaf.context.Context;
		Context ctx = new Context();
		ctx.setVariable("name", name);
		ctx.setVariable("messages", messageBody);
		ctx.setVariable("footer", footer);
		
		//create the  body of our email using the thymeleaf page and context 
		String htmlcontent = this.templateEngine.process(name+"EmailTemplate.html",ctx); 
		
		
		//prepare our email for sending
		
		MimeMessage mimeMessage = this.emailSender.createMimeMessage();
		MimeMessageHelper message= new MimeMessageHelper(mimeMessage, true, "UTF-8");
		message.setTo(to);
		message.setSubject(subject);
	    message.setText(htmlcontent, true);
	    
	    this.emailSender.send(mimeMessage);
		
	}
	
	
}
