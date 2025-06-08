package org.adaca.exam.adacaexamprojectmanagementtool.config;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Data
@Configuration
@ConfigurationProperties(prefix = "service.email")
public class AsyncConfig {

    private boolean enabled;
    private int corePoolSize;
    private int maxPoolSize;
    private int queueCapacity;

    @Bean(name = "emailTaskExecutor")
    @ConditionalOnProperty("service.email.enabled")
    public Executor emailTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(corePoolSize);
        executor.setMaxPoolSize(maxPoolSize);
        executor.setQueueCapacity(queueCapacity);
        executor.setThreadNamePrefix("EmailTaskExecutor-");
        executor.initialize();
        return executor;
    }
}
