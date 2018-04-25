package com.springboot.admin.config;


import de.codecentric.boot.admin.notify.Notifier;
import de.codecentric.boot.admin.notify.RemindingNotifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * @author xiaojie.Ma
 * Created by xiaojie.Ma on 2018/3/2.
 */
@Configuration
@EnableScheduling
public class NotifierConfiguration {

    private Notifier notifier = new SlackReminder();

    @Bean
    @Primary
    public RemindingNotifier remindingNotifier() {
        RemindingNotifier remindingNotifier = new RemindingNotifier(notifier);
        return remindingNotifier;
    }
}