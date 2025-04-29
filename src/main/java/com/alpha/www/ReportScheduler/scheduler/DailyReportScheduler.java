package com.alpha.www.ReportScheduler.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DailyReportScheduler {

    private static final Logger logger = LoggerFactory.getLogger(DailyReportScheduler.class);

    // Runs every day at 8:00 AM
//    @Scheduled(cron = "0 0 8 * * ?")
//    @Scheduled(cron = "*/2 * * * * ?") // Every 2 seconds
    @Scheduled(cron = "*/10 * * * * ?")
    public void sendDailyReports() {
        logger.info("Generating and sending daily patient summary reports...");
        generateReports();
        sendEmails();
    }

    private void generateReports() {
        // Simulate logic
        logger.info("Reports generated for all patients.");
    }

    private void sendEmails() {
        // Simulate logic
        logger.info("Emails sent to all doctors.");
    }
}

