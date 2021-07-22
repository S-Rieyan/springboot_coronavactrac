package com.rieyan.coronavaccinetracker.services;

import com.rieyan.coronavaccinetracker.models.Records;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
@Service
public class coronavaccineservice {

    private static String vaccine_url = "https://raw.githubusercontent.com/owid/covid-19-data/master/public/data/vaccinations/locations.csv";

    public List<Records> getRecords() {
        return records;
    }


    private List<Records> records = new ArrayList<>();
    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void fetchVaccineData() throws IOException, InterruptedException {
        List<Records> temp = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(vaccine_url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        StringReader csvBodyReader = new StringReader(response.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        for (CSVRecord record : records) {
            Records rec = new Records();
            rec.setLocation(record.get("location"));
            rec.setVaccines(record.get("vaccines"));
            rec.setLast_observation_date(record.get("last_observation_date"));
            temp.add(rec);
        }
        this.records = temp;
    }

}
