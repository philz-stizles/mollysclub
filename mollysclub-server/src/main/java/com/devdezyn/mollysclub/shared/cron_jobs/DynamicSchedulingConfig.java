package com.devdezyn.mollysclub.shared.cron_jobs;

import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

// Normally, all the properties of the @Scheduled annotation are resolved and initialized only once at Spring context startup.

// Therefore, changing the fixedDelay or fixedRate values at runtime isn't possible when we use @Scheduled annotation in Spring.

// However, there is a workaround. Using Spring's SchedulingConfigurer provides a more customizable way to give us the opportunity of setting the delay or rate dynamically.

// Let's create a Spring configuration, DynamicSchedulingConfig, and implement the SchedulingConfigurer interface
// @Configuration
// @EnableScheduling
// public class DynamicSchedulingConfig implements SchedulingConfigurer {

    // @Autowired
    // private TickService tickService;

    // @Bean
    // public Executor taskExecutor() {
    //     return Executors.newSingleThreadScheduledExecutor();
    // }

    // @Override
    // public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    //     taskRegistrar.setScheduler(taskExecutor());
    //     taskRegistrar.addTriggerTask(
    //       new Runnable() {
    //           @Override
    //           public void run() {
    //               tickService.tick();
    //           }
    //       },
    //       new Trigger() {
    //           @Override
    //           public Date nextExecutionTime(TriggerContext context) {
    //               Optional<Date> lastCompletionTime =
    //                 Optional.ofNullable(context.lastCompletionTime());
    //               Instant nextExecutionTime =
    //                 lastCompletionTime.orElseGet(Date::new).toInstant()
    //                   .plusMillis(tickService.getDelay());
    //               return Date.from(nextExecutionTime);
    //           }
    //       }
    //     );
    // }

// }
