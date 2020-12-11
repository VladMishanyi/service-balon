package com.vk.servicebalon.controllers;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.service.ServiceTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/database")
public class ControllerDatabase {

    private final ServiceTRM202 serviceTRM202;

//    public ControllerDatabase() {
//    }

    @Autowired
    public ControllerDatabase(final ServiceTRM202 serviceTRM202) {
        this.serviceTRM202 = serviceTRM202;
    }

    @RequestMapping(value = "/range", method = RequestMethod.POST)
    public List<DeviceModelTRM202> rangeOfData(Date from, Date to){
        return serviceTRM202.findByDateBetween(from, to);
    }
}
