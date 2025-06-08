package org.adaca.exam.adacaexamprojectmanagementtool.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Async("emailTaskExecutor")
    @Override
    public void send(String to, String subject, String description) {
        log.info("Sending email to <{}> with subject <{}> and description <{}>", to, subject, description);
    }
}
