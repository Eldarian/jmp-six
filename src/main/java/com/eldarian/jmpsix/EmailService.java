package com.eldarian.jmpsix;

public interface EmailService {
    boolean sendEmail(String topic, String recipient, String message);
    String getEmail();
}
