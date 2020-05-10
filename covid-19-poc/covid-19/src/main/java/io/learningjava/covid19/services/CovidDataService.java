package io.learningjava.covid19.services;

import io.learningjava.covid19.models.LocationData;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
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

@Service
public class CovidDataService {

    private static String VIRUS_DATA_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    private List<LocationData> dataset = new ArrayList<>();

    /**
     * get total number of previous cases from yesterday.
     * @return newCases total number of previous cases from yesterday
     */
    public int getTotalNewCases() {
        int newCases = dataset
                .stream()
                .mapToInt(stat -> stat.getDiffFromYesterday())
                .sum();
        return newCases;
    }

    /**
     * get the global total number of cases confirmed.
     * @return confirmedCases total cases confirmed
     */
    public int getCurrentTotalCases() {
        int confirmedCases = dataset
                .stream()
                .mapToInt(stat -> stat.getCurrentTotalCases())
                .sum();

        return confirmedCases;
    }

    /**
     * get complete dataset.
     * @return dataset
     */
    public List<LocationData> getDataset() {
        return dataset;
    }

    /**
     * when service is constructed on app start, make an http GET request to fetch data every day.
     */
    @PostConstruct
    @Scheduled(cron = "* * 1 * * *")
    public void getCovidData() throws IOException, InterruptedException {

        // generate new List and then populate dataset;
        List<LocationData> newData = new ArrayList<>();
        // instantiate client
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                // Uniform Resource Identifier= define where data can be accessed
                .uri(URI.create(VIRUS_DATA_URL))
                .build();

        // send request and the convert body into a string
        HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
//        System.out.println(httpResponse.body());

        // parse strings with StringReader
        StringReader csvBodyReader = new StringReader(httpResponse.body());
        Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
        // iterate over csv dataset and get features & columns
        for (CSVRecord record : records) {
            LocationData locationData = new LocationData();
            locationData.setState(record.get("Province/State"));
            locationData.setCountry(record.get("Country/Region"));
            int currentTotalCases = Integer.parseInt(record.get(record.size() - 1));
            int yesterdayTotalCases = Integer.parseInt(record.get(record.size() - 2));
            locationData.setCurrentTotalCases(currentTotalCases);
            locationData.setDiffFromYesterday(currentTotalCases - yesterdayTotalCases);

            // append column of data to data aggregating dataset
            newData.add(locationData);
        }
        this.dataset = newData;
    }
}
