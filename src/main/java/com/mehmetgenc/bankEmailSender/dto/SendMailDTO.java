package com.mehmetgenc.bankEmailSender.dto;


public record SendMailDTO(String to, String from, String topic, String mailBody) {

}
