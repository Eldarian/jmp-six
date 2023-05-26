package com.eldarian.jmpsix;

public class Messenger {
    TemplateProcessor templateProcessor = new TemplateProcessor();
    EmailService emailService;

    public Messenger(EmailService emailService) {
        this.emailService = emailService;
    }

    public String sendMessage(String topic, String recipient, Template template) {
        String message = "";
        try {
            message = templateProcessor.processMessage(template);
        } catch (NullValueException e) {
            e.printStackTrace();
        }
        if (emailService.sendEmail(topic, recipient, message)) {
            return message;
        } else {
            return "error";
        }
    }

    public String consumeMessage() {
        return emailService.getEmail();
    }
}
