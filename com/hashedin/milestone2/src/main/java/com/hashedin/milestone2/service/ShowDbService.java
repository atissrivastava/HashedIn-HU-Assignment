package com.hashedin.milestone2.service;

import com.hashedin.milestone2.entity.Show;
import com.hashedin.milestone2.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ShowDbService {

    @Autowired(required = false)
    private ShowRepository showRepository;

    public Show saveShowToDb(Show show) {
        return showRepository.save(show);

    }

    public void saveShowsData() {
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(ResourceUtils.getFile("classpath:netflix_titles.csv")));
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
                    String director =rows.get(3) ;// new HashSet<>(Arrays.asList(rows.get(3).split(",")));
                    String cast = rows.get(4); //new HashSet<>(Arrays.asList(rows.get(4).split(",")));
                    String country =  rows.get(5); //new HashSet<>(Arrays.asList(rows.get(5).split(",")));
                    String release_year = rows.get(7);
                    String rating = rows.get(8);
                    String duration = rows.get(9);
                    String listed_in = rows.get(10); // new HashSet<>(Arrays.asList(rows.get(10).split(",")));
                    String description = rows.get(11);
                    DateFormat format = new SimpleDateFormat("MMMM d, yyyy");
                    Date date = format.parse("June 26, 1997");
                    try {
                        date = !rows.get(6).isEmpty() ? format.parse(rows.get(6).replaceAll("\"", "").trim()) : null;
                    } catch (Exception e) {
                        System.out.println("Exception occured for row number :" + show_id);
                        date = format.parse("June 26, 1997");
                    }
                    Show show = new Show(show_id, type, title, director, cast, country, date, release_year, rating, duration, listed_in, description);

                    showRepository.save(show);
                }
            }
        } catch (IOException | ParseException e) {

            System.out.println("Exception occured in class: " + e.getClass() + " Message: " + e.getMessage());
        }
    }

    public void saveJsonData(Show show) {
        showRepository.save(show);
    }
}
