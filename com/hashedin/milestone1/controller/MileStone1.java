package com.hashedin.milestone1.controller;

import com.hashedin.milestone1.service.ShowService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

public class MileStone1 {


    public static void main(String[] args) throws FileNotFoundException {

        Path filePath = Paths.get("com/hashedin/milestone1/netflix_titles.csv");
        Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new FileReader(String.valueOf(Paths.get("com/hashedin/milestone1/netflix_titles.csv"))));

        if (Files.exists(filePath)) {

            try {
                System.out.println("Please enter the number of Movies or TV Shows you want to list");
                int n = sc.nextInt();
                System.out.println("Please Enter the start date in dd-mm-yyyy format");
                String stDate = sc.next();
                Date startDate = !stDate.equals("") ? new SimpleDateFormat("dd-mm-yyyy").parse(stDate) : null;
                System.out.println("Please Enter the end date in dd-mm-yyyy format");
                String edDate = sc.next();
                Date endDate = !stDate.equals("") ? new SimpleDateFormat("dd-mm-yyyy").parse(edDate) : null;

                System.out.println("Please choose from below option to see the required results");
                System.out.println("Enter 1 to Search for TV Shows");
                System.out.println("Enter 2 to Search for Horror Movies");
                System.out.println("Enter 3 to Search for Indian TV Shows");
                String choice = String.valueOf(sc.nextInt());
                switch (choice) {
                    case "1":
                        ShowService.getFirstNTvShows(br, n, startDate, endDate) ;
                        break;
                    case "2":
                        ShowService.getFirstNListedHorrorMovies(br, n, startDate, endDate) ;
                        break;
                    case "3":
                        ShowService.getFirstNIndianMovies(br, n, startDate, endDate) ;
                        break;
                    default:
                        System.exit(0);
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not present");
        }

    }
}

