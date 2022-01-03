package com.hashedin.milestone1.service;

import java.io.BufferedReader;
import java.util.*;
import java.util.stream.Collectors;

public class ShowService {
    private final static String DELIMITTER = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

    public static void getFirstNTvShows(BufferedReader br, int n, Date startDate, Date endDate) {
        long executionStartTime = System.currentTimeMillis();
        List<String> columns = br.lines().findFirst().map(line -> Arrays.asList(line.split(","))).get();
        int indexOfColumnType = columns.indexOf("type");
        List<List<String>> rows = br.lines().map(line -> Arrays.asList(line.split(DELIMITTER))).filter(list -> list.get(indexOfColumnType).equalsIgnoreCase("tv show")).limit(n).collect(Collectors.toList());
        display(rows);
        long executionFinishTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (executionFinishTime - executionStartTime) + " ms");
    }


    public static void getFirstNListedHorrorMovies(BufferedReader br, int n, Date startDate, Date endDate) {
        long executionStartTime = System.currentTimeMillis();
        List<String> columns = br.lines().findFirst().map(line -> Arrays.asList(line.split(","))).get();
        int indexOfColumnType = columns.indexOf("listed_in");
        List<List<String>> rows = br.lines().map(line -> Arrays.asList(line.split(DELIMITTER))).filter(list -> list.size() >= indexOfColumnType && list.get(indexOfColumnType).contains("Horror Movies")).limit(n).collect(Collectors.toList());
        display(rows);
        long executionFinishTime = System.currentTimeMillis();
        System.out.println("Execution Time: " + (executionFinishTime - executionStartTime) + " ms");
    }

    public static void getFirstNIndianMovies(BufferedReader br, int n, Date startDate, Date endDate) {
        long executionStartTime = System.currentTimeMillis();
        List<String> columns = br.lines().findFirst().map(line -> Arrays.asList(line.split(DELIMITTER))).get();
        int indexOfColumnType = columns.indexOf("type");
        int indexOfColumnCountry = columns.indexOf("country");

        List<List<String>> rows = br.lines().map(line -> Arrays.asList(line.split(DELIMITTER, -1))).filter(list -> list.size() > 1 && list.get(indexOfColumnType).trim().equalsIgnoreCase("MOVIE") && list.get(indexOfColumnCountry).trim().equalsIgnoreCase("INDIA")).limit(n).collect(Collectors.toList());
        display(rows);
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