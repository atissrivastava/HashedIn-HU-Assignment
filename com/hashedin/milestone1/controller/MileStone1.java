package com.hashedin.milestone1.controller;

import com.hashedin.milestone1.entity.Show;
import com.hashedin.milestone1.service.ShowService;
import com.hashedin.milestone1.utils.CsvHelper;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class MileStone1 {


    public static void main(String[] args) throws IOException, ParseException {
        try {
            List<Show> shows = CsvHelper.parseCsv();
            if (shows.size() > 0) {
                try {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Please enter the number of Movies or TV Shows you want to search");
                    int n = sc.nextInt();

                    System.out.println("Please enter the start date in DD-MM-YYYY format");
                    String stDate = sc.next();
                    Date startDate = !stDate.equals("") ? new SimpleDateFormat("DD-MM-YYYY").parse(stDate) : null;
                    System.out.println("Please enter the end date in DD-MM-YYYY format");
                    String edDate = sc.next();
                    Date endDate = !stDate.equals("") ? new SimpleDateFormat("DD-MM-YYYY").parse(edDate) : null;

                    System.out.println("Please choose from below option to see the required results");
                    System.out.println("Enter 1 to Search for TV Shows");
                    System.out.println("Enter 2 to Search for Horror Movies");
                    System.out.println("Enter 3 to Search for Indian TV Shows");
                    String choice = String.valueOf(sc.nextInt());
                    switch (choice) {
                        case "1":
                            ShowService.getFirstNTvShows(shows, n, startDate, endDate);
                            break;
                        case "2":
                            ShowService.getFirstNListedHorrorMovies(shows, n, startDate, endDate);
                            break;
                        case "3":
                            ShowService.getFirstNIndianMovies(shows, n, startDate, endDate);
                            break;
                        default:
                            System.out.println("Please Enter from the above options. Exiting!");
                            System.exit(0);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Empty File passed");
            }
        } catch (IOException ioException) {
            System.out.println("File not present in the given location");
        }

    }
}

