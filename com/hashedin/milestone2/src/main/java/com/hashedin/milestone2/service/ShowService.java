package com.hashedin.milestone2.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.hashedin.milestone2.entity.Show;
import com.hashedin.milestone2.utils.CsvHelper;
import org.springframework.stereotype.Service;

@Service
public class ShowService {


    public List<Show> showAll() throws IOException, ParseException {
        List<Show> result = new ArrayList<>();
        result = CsvHelper.parseCsv();
        return result;
    }


    public static List<Show> getFirstNTvShows(int count) throws FileNotFoundException, IOException, ParseException {
        List<Show> Show = new ArrayList<>();
        Show = CsvHelper.parseCsv();
        List<Show> result = new ArrayList<>();
        result = Show.stream().filter(m -> m.getDate_added() != null).filter(m -> m.getType().equals("TV Show")).limit(count).collect(Collectors.toList());
        return result;
    }


    public static List<Show> getFirstNListedHorrorMovies(String ShowType) throws FileNotFoundException, IOException, ParseException {
        List<Show> Show = new ArrayList<>();
        Show = CsvHelper.parseCsv();
        List<Show> result = new ArrayList<>();
        result = Show.stream().filter(m -> m.getDate_added() != null).filter(m -> m.getListed_in().contains(ShowType)).collect(Collectors.toList());
        return result;
    }

    public static List<Show> getFirstNIndianMovies(String country) throws FileNotFoundException, IOException, ParseException {
        List<Show> Show = new ArrayList<>();
        Show = CsvHelper.parseCsv();
        List<Show> result = new ArrayList<>();
        result = Show.stream().filter(m -> m.getDate_added() != null).filter(m -> m.getCountry().contains(country)).collect(Collectors.toList());
        return result;
    }

    public static List<Show> filterShow(Date startDate, Date endDate) throws FileNotFoundException, IOException, ParseException {
        List<Show> Show = new ArrayList<>();
        Show = CsvHelper.parseCsv();
        List<Show> result = new ArrayList<>();
        result = Show.stream().filter(m -> m.getDate_added() != null).filter(m -> m.getDate_added().after(startDate) && m.getDate_added().before(endDate)).collect(Collectors.toList());
        return result;
    }
}

