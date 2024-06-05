package com.alibou.book.auth.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.thymeleaf.spring6.SpringTemplateEngine;

public class EmailServiceBuilder {
    private JavaMailSender mailSender;
    private SpringTemplateEngine templateEngine;

    public EmailServiceBuilder setMailSender(JavaMailSender mailSender) {
        this.mailSender = mailSender;
        return this;
    }

    public EmailServiceBuilder setTemplateEngine(SpringTemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
        return this;
    }

    public EmailService createEmailService() {
        return new EmailService(mailSender, templateEngine);
    }
}