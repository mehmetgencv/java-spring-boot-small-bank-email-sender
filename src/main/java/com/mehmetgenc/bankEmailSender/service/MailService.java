package com.mehmetgenc.bankEmailSender.service;


import com.mehmetgenc.bankEmailSender.dto.SendMailDTO;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;

    @Value("${n11-mail-sender.default-mail-address}")
    private String DEFAULT_MAIL_ADDRESS;


    public Boolean sendMail(SendMailDTO sendMailDTO) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        try {
            mimeMessageHelper.addTo(sendMailDTO.to());
            mimeMessageHelper.setFrom(sendMailDTO.from());
            mimeMessageHelper.setSubject(sendMailDTO.topic());
            mimeMessageHelper.setText(sendMailDTO.mailBody());
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

        javaMailSender.send(mimeMessage);

        return true;
    }
}
