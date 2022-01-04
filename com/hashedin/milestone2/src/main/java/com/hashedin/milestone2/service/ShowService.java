package com.hashedin.milestone2.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.ParseException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.hashedin.milestone2.entity.Show;
import  com.hashedin.milestone2.utils.CsvHelper ;
import org.springframework.stereotype.Service;

@Service
public class ShowService {

    public static List<Show> getFirstNTvShows(int count) throws FileNotFoundException, IOException, ParseException {
        List<Show> shows = new ArrayList<>();
        shows = CsvHelper.parseCsv();
        List<Show> resultSet = new ArrayList<>();
        resultSet = shows.stream().filter(row -> row.getDateAdded() != null).filter(row -> row.getType().equals("TV Show")).limit(count).collect(Collectors.toList());
        return resultSet;
    }

    public static List<Show> getFirstNListedHorrorMovies(String movieType) throws FileNotFoundException, IOException, ParseException {
        List<Show> shows = new ArrayList<>();
        shows = CsvHelper.parseCsv();
        List<Show> resultSet = new ArrayList<>();
        resultSet = shows.stream().filter(row -> row.getDateAdded() != null).filter(row -> row.getListedIn().contains(movieType)).collect(Collectors.toList());
        return resultSet;
    }

    public static List<Show> getFirstNIndianMovies(String country) throws FileNotFoundException, IOException, ParseException {
        List<Show> shows = new ArrayList<>();
        shows = CsvHelper.parseCsv();
        List<Show> resultSet = new ArrayList<>();
        resultSet = shows.stream().filter(row -> row.getDateAdded() != null).filter(row -> row.getCountry().contains(country)).collect(Collectors.toList());
        return resultSet;
    }

    public static List<Show> filterShowWithDate(Date startDate, Date endDate) throws FileNotFoundException, IOException, ParseException {
        List<Show> shows = new ArrayList<>();
        shows = CsvHelper.parseCsv();
        List<Show> resultSet = new ArrayList<>();
        resultSet = shows.stream().filter(row -> row.getDateAdded() != null).filter(row -> row.getDateAdded().after(startDate) && row.getDateAdded().before(endDate)).collect(Collectors.toList());
        return resultSet;
    }
}

