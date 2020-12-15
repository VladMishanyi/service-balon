package com.vk.servicebalon.controllers;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.modbus.entity.ModbusBodyDateRange;
import com.vk.servicebalon.service.ServiceTRM202;
import com.vk.servicebalon.table.TableModelTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/database")
public class ControllerDatabaseForTRM202 {

    private final ServiceTRM202 serviceTRM202;

    @Autowired
    public ControllerDatabaseForTRM202(final ServiceTRM202 serviceTRM202) {
        this.serviceTRM202 = serviceTRM202;
    }

    @RequestMapping(value = "/range", method = RequestMethod.POST)
    public List<TableModelTRM202> rangeOfData(ModbusBodyDateRange modbusBodyDateRange){
        return serviceTRM202.findByDateBetween(modbusBodyDateRange.getFrom(), modbusBodyDateRange.getTo());
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public Date test(){
        return new Date();
    }
}
