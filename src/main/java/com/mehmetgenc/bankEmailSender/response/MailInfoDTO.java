package com.mehmetgenc.bankEmailSender.response;

import java.time.LocalDateTime;

public record MailInfoDTO(String receiver, String sender, LocalDateTime mailDate, String topic) {
}
