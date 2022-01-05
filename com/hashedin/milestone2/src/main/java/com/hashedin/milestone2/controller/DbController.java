package com.hashedin.milestone2.controller;

import com.hashedin.milestone2.entity.Show;
import com.hashedin.milestone2.service.CsvWriterService;
import com.hashedin.milestone2.service.ShowDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class DbController {

    @Autowired
    private ShowDbService showDbService;
    @Autowired
    private CsvWriterService csvWriterService;

    // API to add data from CSV to DB
    @GetMapping(value ="/csv-to-db")
    public void saveShowsFromCsvToDb()  {
        showDbService.saveShowsData();
    }

    //API to insert data to DB through json
    @PostMapping(value = "/json-to-db")
    public void saveShowFromJsonToDb(@RequestBody Show show){
        showDbService.saveJsonData(show);
    }

    // API to add new Data to CSV or DB
    @PostMapping(value = "/add-show", params = "dataDestination")
    public void addNewShow(@RequestParam String dataDestination, @RequestBody Show show, HttpServletResponse response) throws IOException {

        if (dataDestination.equals("db")) showDbService.saveShowToDb(show);
        else if (dataDestination.equals("csv")) {
            csvWriterService.writeToCSV(show);
        }
    }
}
