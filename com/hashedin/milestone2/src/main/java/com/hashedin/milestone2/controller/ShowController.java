package com.hashedin.milestone2.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.hashedin.milestone2.entity.JwtRequest;
import com.hashedin.milestone2.entity.JwtResponse;
import com.hashedin.milestone2.entity.Show;
import com.hashedin.milestone2.service.ShowService;
import com.hashedin.milestone2.service.UserService;
import com.hashedin.milestone2.utils.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShowController {

    @Autowired
    private ShowService showService;

    @Autowired
    private JwtUtility jwtUtility;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/tvshows", params = "count")
    public List<Show> getNTVShows(@RequestParam int count, HttpServletResponse response) throws FileNotFoundException, IOException, ParseException {
        long executionStartTime = System.currentTimeMillis();
        List<Show> shows = new ArrayList();
        shows = ShowService.getFirstNTvShows(count);
        long executionEndTime = System.currentTimeMillis();
        response.setHeader("X-TIME-TO-EXECUTE", (executionEndTime - executionStartTime) + "ms");
        return shows;
    }

    @GetMapping(value = "/tvshows", params = "movieType")
    public List<Show> getHorrorShow(@RequestParam String movieType, HttpServletResponse response) throws FileNotFoundException, IOException, ParseException {
        long executionStartTime = System.currentTimeMillis();
        List<Show> horrorMovies = new ArrayList<>();
        horrorMovies = showService.getFirstNListedHorrorMovies(movieType);
        long executionEndTime = System.currentTimeMillis();
        response.setHeader("X-TIME-TO-EXECUTE", (executionEndTime - executionStartTime) + "ms");
        return horrorMovies;
    }

    @GetMapping(value = "/tvshows", params = "country")
    public List<Show> getCountryBasedShow(@RequestParam String country, HttpServletResponse response) throws FileNotFoundException, IOException, ParseException {
        long executionStartTime = System.currentTimeMillis();
        List<Show> indianMovies = new ArrayList<>();
        indianMovies = showService.getFirstNIndianMovies(country);
        long executionEndTime = System.currentTimeMillis();
        response.setHeader("X-TIME-TO-EXECUTE", (executionEndTime - executionStartTime) + "ms");
        return indianMovies;

    }

    @GetMapping(value = "/tvshows", params = {"startDate", "endDate"})
    public List<Show> getDateBasedShow(@RequestParam Date startDate, Date endDate, HttpServletResponse response) throws FileNotFoundException, IOException, ParseException {
        long executionStartTime = System.currentTimeMillis();
        List<Show> shows = new ArrayList<>();
        shows = showService.filterShowWithDate(startDate, endDate);
        long executionEndTime = System.currentTimeMillis();
        response.setHeader("X-TIME-TO-EXECUTE", (executionEndTime - executionStartTime) + "ms");
        return shows;
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUserName(),
                            jwtRequest.getPassword()
                    )
            );
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }

        final UserDetails userDetails
                = userService.loadUserByUsername(jwtRequest.getUserName());

        final String token =
                jwtUtility.generateToken(userDetails);

        return new JwtResponse(token);
    }
}

