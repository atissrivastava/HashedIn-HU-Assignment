package com.hashedin.milestone2.utils;

import com.hashedin.milestone2.entity.Show;
import com.hashedin.milestone2.entity.Show;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;


public class CsvHelper {

    public static List<Show> parseCsv() throws FileNotFoundException, IOException, ParseException {
        BufferedReader fileReader = new BufferedReader(new FileReader(String.valueOf(Paths.get(
                "/Users/atissrivastava/HashedIn-HU-Assignment/com/hashedin/milestone1/netflix_titles.csv"))));
        final String DELIMITTER = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
        List<List<String>> allShows = fileReader.lines().skip(1).map(line -> Arrays.asList(line.split(DELIMITTER, -1)))
                .collect(Collectors.toList());
        List<Show> showList = new ArrayList<Show>();
        for (List<String> rows : allShows) {
            //12 is the total number of columns. Can be replaced by a function to find column dynamically.
            if (rows.size() == 12) {
                String show_id = rows.get(0);
                String type = rows.get(1);
                String title = rows.get(2);
                Set<String> director = new HashSet<>(Arrays.asList(rows.get(3).split(",")));
                Set<String> cast = new HashSet<>(Arrays.asList(rows.get(4).split(",")));
                Set<String> country = new HashSet<>(Arrays.asList(rows.get(5).split(",")));
                String release_year = rows.get(7);
                String rating = rows.get(8);
                String duration = rows.get(9);
                Set<String> listed_in = new HashSet<>(Arrays.asList(rows.get(10).split(",")));
                String description = rows.get(11);
                DateFormat format = new SimpleDateFormat("MMMM d, yyyy");
                Date date = format.parse("June 26, 1997");
                try {
                    date = !rows.get(6).isEmpty() ? format.parse(rows.get(6).replaceAll("\"","").trim()) : null;
                } catch (Exception e) {
                    System.out.println("Exception occured for row number :" + show_id);
                date = format.parse("June 26, 1997");
                }
                Show Show = new Show(show_id, type, title, director, cast, country, date, release_year, rating, duration, listed_in, description);
                showList.add(Show);
            }
        }
        return showList;
    }
}

