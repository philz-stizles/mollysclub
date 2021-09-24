package com.devdezyn.mollysclub.shared.cron_jobs;

import java.util.Calendar;

import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@EnableAsync // If we want to support parallel behavior in scheduled tasks, 
// we need to add the @Async annotation
public class EmailSubscriptions {
  // Now you can add @Scheduled annotations on methods which you want to schedule. 
  // Only condition is that methods should be without arguments.
  // @Scheduled(initialDelay = 1000, fixedRate = 10000)
  public void sendMail() {
    log.info("Current time is :: " + Calendar.getInstance().getTime());
  }

  // @Scheduled(cron = "0 10 10 10 * ?")
  public void run() {
    log.info("Current time is :: " + Calendar.getInstance().getTime());
  }

  // @Scheduled(cron = "0 10 10 10 * ?", zone = "Europe/Paris")
  public void someJobThatIsZoneSpecific() {
    log.info("Current time is :: " + Calendar.getInstance().getTime());
  }

  // @Scheduled(fixedDelay = 1000)
  // public void scheduleFixedDelayTask() {
  //     System.out.println(
  //       "Fixed delay task - " + System.currentTimeMillis() / 1000);
  // }

  // @Async // Now this asynchronous task will be invoked each second, even if the previous task isn't done.
  //   @Scheduled(fixedRate = 1000)
  //   public void scheduleFixedRateTaskAsync() throws InterruptedException {
  //       System.out.println(
  //         "Fixed rate task async - " + System.currentTimeMillis() / 1000);
  //       // Thread.sleep(2000);
  //   }
}