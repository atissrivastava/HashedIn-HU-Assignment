package com.hashedin.milestone2.service;

import java.util.List;

import com.hashedin.milestone2.entity.Show;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVWriter;

@Service
public class CsvWriter {

    public void writeToCSV(Show show) throws IOException {
        File file = ResourceUtils.getFile("classpath:netflix_titles.csv");
        CSVWriter writer = new CSVWriter(new FileWriter(file, true));
        String[] values = new String[11];
        values[0] = show.getShow_id();
        values[1] = show.getType();
        values[2] = show.getTitle();
        values[3] = show.getDirector().toString();
        values[4] = show.getCast().toString();
        values[5] = show.getCountry().toString();
        values[6] = show.getDateAdded().toString();
        values[7] = show.getRelease_year();
        values[8] = show.getRating();
        values[9] = show.getListedIn().toString();
        values[10] = show.getDuration();

        writer.writeNext(values);
        writer.flush();
        System.out.println("Success");


    }
}
