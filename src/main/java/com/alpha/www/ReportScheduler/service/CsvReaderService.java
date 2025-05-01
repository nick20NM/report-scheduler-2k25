package com.alpha.www.ReportScheduler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alpha.www.ReportScheduler.model.Patient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvReaderService {

    private static final Logger logger = LoggerFactory.getLogger(CsvReaderService.class);

    public List<Patient> readPatientsFromCsv(String fileName) {
        List<Patient> patients = new ArrayList<>();

        try (InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
             BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {

            String line;
            boolean isFirstLine = true;

            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false; // Skip header
                    continue;
                }

                String[] tokens = line.split(",");
                int id = Integer.parseInt(tokens[0].trim());
                String name = tokens[1].trim();
                LocalDate lastVisit = LocalDate.parse(tokens[2].trim());

//                patients.add(new Patient(id, name, lastVisit));
                Patient patient = new Patient(id, name, lastVisit);
                logger.info("" + patient);
                patients.add(patient);
            }

        } catch (Exception e) {
            logger.error("❌ Failed to read or parse the CSV file '{}'", fileName, e);
        }

        return patients;
    }
}

