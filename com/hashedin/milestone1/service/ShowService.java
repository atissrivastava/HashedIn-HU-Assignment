package com.hashedin.milestone1.service;

import com.hashedin.milestone1.entity.Show;

import java.io.BufferedReader;
import java.util.*;
import java.util.stream.Collectors;

public class ShowService {
    private final static String DELIMITTER = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

    public static void getFirstNTvShows(List<Show> show, int n, Date startDate, Date endDate) {
        long executionStartTime = System.currentTimeMillis();
        show.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getType().equals("TV Show")).limit(n)
                .filter(m -> m.getDate_added().after(startDate) && m.getDate_added().before(endDate))
                .forEach(System.out::println);
        long executionFinishTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (executionFinishTime - executionStartTime) + " ms");
    }


    public static void getFirstNListedHorrorMovies(List<Show> show, int n, Date startDate, Date endDate) {
        long executionStartTime = System.currentTimeMillis();
        show.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getListed_in().contains("Horror Movies")).limit(n)
                .filter(m -> m.getDate_added().after(startDate) && m.getDate_added().before(endDate))
                .forEach(System.out::println);
        long executionFinishTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (executionFinishTime - executionStartTime) + " ms");
    }

    public static void getFirstNIndianMovies(List<Show> show, int n, Date startDate, Date endDate) {
        long executionStartTime = System.currentTimeMillis();
        show.stream().filter(m -> m.getDate_added() != null)
                .filter(m -> m.getType().equals("Movie") && m.getCountry().contains("India"))
                .limit(n)
                .filter(m -> m.getDate_added().after(startDate) && m.getDate_added().before(endDate))
                .forEach(System.out::println);
        long executionFinishTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (executionFinishTime - executionStartTime) + " ms");
    }

    public static void display(List<List<String>> list) {
        for (List<String> rows : list) {

            System.out.println("Show Id='" + rows.get(0) + '\'' + ", Type='" + rows.get(1) + '\'' + ", Title='"
                    + rows.get(2) + '\'' + ", Director=" + rows.get(3) + ", " +
                    "Cast=" + rows.get(4) + ", Country=" + rows.get(5) + ", Date Added=" + rows.get(6) + ", Release Year='"
                    + rows.get(7) + '\'' + ", Rating='" + rows.get(8) + '\'' + ", Duration='" + rows.get(9) + '\'' + ", " +
                    "Listed In=" + rows.get(10) + ", Description='" + rows.get(11) + '\'');
        }
    }
}