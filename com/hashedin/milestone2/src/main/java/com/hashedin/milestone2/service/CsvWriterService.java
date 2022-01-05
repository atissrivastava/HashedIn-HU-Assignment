package com.hashedin.milestone2.service;

import com.hashedin.milestone2.entity.Show;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

@Service
public class CsvWriterService {

    public void writeToCSV(Show show) throws IOException {
        File file = ResourceUtils.getFile("classpath:temp.csv");
        CSVWriter writer = new CSVWriter(new FileWriter(file, true));
        System.out.println(show.toString());
        String[] values = new String[11];
        values[0] = show.getShow_id();
        values[1] = show.getType();
        values[2] = show.getTitle();
        values[3] = show.getDirector();
        values[4] = show.getCast();
        values[5] = show.getCountry();
        values[6] = show.getDateAdded()==null ? "" : show.getDateAdded().toString();
        values[7] = show.getRelease_year();
        values[8] = show.getRating();
        values[9] = show.getListedIn();
        values[10] = show.getDuration();

        writer.writeNext(values);
        writer.close();
        System.out.println("Successfully inserted one row into the provided file");

    }
}
