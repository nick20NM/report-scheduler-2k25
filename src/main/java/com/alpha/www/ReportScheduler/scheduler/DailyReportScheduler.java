package com.alpha.www.ReportScheduler.scheduler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alpha.www.ReportScheduler.model.Patient;
import com.alpha.www.ReportScheduler.service.CsvReaderService;
import com.alpha.www.ReportScheduler.service.EmailService;

@Component
public class DailyReportScheduler {

    private static final Logger logger = LoggerFactory.getLogger(DailyReportScheduler.class);
    
    private final CsvReaderService csvReaderService;
    
    private final EmailService emailService;
    
    List<Patient> patientsGlobal;

    public DailyReportScheduler(CsvReaderService csvReaderService, EmailService emailService) {
        this.csvReaderService = csvReaderService;
        this.emailService = emailService;
    }

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
//        logger.info("Reports generated for all patients.");
        logger.info("📥 Reading patient data from CSV...");

        List<Patient> patients = csvReaderService.readPatientsFromCsv("patients.csv");
        patientsGlobal = patients;
        
        System.out.println("patientsGlobal = " + patientsGlobal);

        logger.info("✅ Total Patients Processed: {}", patients.size());
        for (Patient patient : patients) {
            logger.debug("📋 Patient[ID: {}, Name: {}, Last Visit: {}]",
                    patient.getId(), patient.getName(), patient.getLastVisit());
        }

        logger.info("📄 Report generation complete.");
    }

    private void sendEmails() {
        // Simulate logic
//        logger.info("Emails sent to all doctors.");
    	
    	logger.info("📧 Sending email summaries to recipients...");

    	
        // Example
        emailService.sendEmail(
//            "masihnishit@gmail.com",
            "recipient@example.com",
            "Daily Patient Report",
            "The daily patient report has been generated successfully." + patientsGlobal
        );
    }
}

