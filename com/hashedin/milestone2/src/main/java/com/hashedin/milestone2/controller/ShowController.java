package com.hashedin.milestone2.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.hashedin.milestone2.entity.Show;
import com.hashedin.milestone2.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowController {

    @Autowired
    private static ShowService showService;

    @GetMapping(value = "/tvshows", params = "count")
    public static List<Show> getNTVShows(@RequestParam int count, HttpServletResponse response) throws FileNotFoundException, IOException, ParseException {
        long executionStartTime = System.currentTimeMillis();
        List<Show> shows = new ArrayList();
        shows = ShowService.getFirstNTvShows(count);
        long executionEndTime = System.currentTimeMillis();
        response.setHeader("X-TIME-TO-EXECUTE", (executionEndTime - executionStartTime) + "ms");
        return shows;
    }

    @GetMapping(value = "/tvshows", params = "ShowType")
    public static List<Show> getHorrorShow(@RequestParam String ShowType, HttpServletResponse response) throws FileNotFoundException, IOException, ParseException {
        long executionStartTime = System.currentTimeMillis();
        List<Show> horrorMovies = new ArrayList<>();
        horrorMovies = showService.getFirstNIndianMovies(ShowType);
        long executionEndTime = System.currentTimeMillis();
        response.setHeader("X-TIME-TO-EXECUTE", (executionEndTime - executionStartTime) + "ms");
        return horrorMovies;
    }

    @GetMapping(value = "/tvshows", params = "country")
    public static List<Show> getCountryBasedShow(@RequestParam String country, HttpServletResponse response) throws FileNotFoundException, IOException, ParseException {
        long executionStartTime = System.currentTimeMillis();
        List<Show> indianMovies = new ArrayList<>();
        indianMovies = showService.getFirstNIndianMovies(country);
        long executionEndTime = System.currentTimeMillis();
        response.setHeader("X-TIME-TO-EXECUTE", (executionEndTime - executionStartTime) + "ms");
        return indianMovies;

    }

    @GetMapping(value = "/tvshows", params = {"startDate", "endDate"})
    public static List<Show> getDateBasedShow(@RequestParam Date startDate, Date endDate, HttpServletResponse response) throws FileNotFoundException, IOException, ParseException {
        long executionStartTime = System.currentTimeMillis();
        List<Show> shows = new ArrayList<>();
        shows = showService.filterShow(startDate, endDate);
        long executionEndTime = System.currentTimeMillis();
        response.setHeader("X-TIME-TO-EXECUTE", (executionEndTime - executionStartTime) + "ms");
        return shows;
    }
}

