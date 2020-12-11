package com.vk.servicebalon.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/database")
public class ControllerDatabase {

    public ControllerDatabase() {
    }

    @RequestMapping(value = "/range", method = RequestMethod.POST)
    public void rangeOfData(Date from, Date to){

    }
}
