package com.mehmetgenc.bankEmailSender.request;

public record SendMailRequest(String receiver, String topic, String mailBody) {
}
