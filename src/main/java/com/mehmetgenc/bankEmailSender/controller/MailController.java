package com.mehmetgenc.bankEmailSender.controller;

import com.mehmetgenc.bankEmailSender.dto.SendMailDTO;
import com.mehmetgenc.bankEmailSender.request.SendMailRequest;
import com.mehmetgenc.bankEmailSender.response.MailInfoDTO;
import com.mehmetgenc.bankEmailSender.service.MailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/mails")
@Slf4j
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @GetMapping("/default")
    public String getDefaultMailAddress(){return "@gmail.com";}

    @GetMapping("{id}/infos")
    public MailInfoDTO getMailSendInfoDTO(@PathVariable Long id, @RequestParam String topic){
        return new MailInfoDTO("@gmail.com", getDefaultMailAddress(), LocalDateTime.now(), topic);
    }

    @PostMapping()
    public MailInfoDTO sendMail(@RequestBody SendMailRequest request){

        SendMailDTO sendMailDTO = new SendMailDTO(request.receiver(), getDefaultMailAddress(), request.topic(), request.mailBody());

        Boolean isSuccess =  mailService.sendMail(sendMailDTO);

    }


}