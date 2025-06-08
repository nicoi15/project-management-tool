package org.adaca.exam.adacaexamprojectmanagementtool.email;

public interface EmailService {
    void send(String to, String subject, String description);
}
