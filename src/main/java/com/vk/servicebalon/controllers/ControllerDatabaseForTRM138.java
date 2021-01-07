package com.vk.servicebalon.controllers;

import com.vk.servicebalon.json.JsonBodyListForTableModelTRM138;
import com.vk.servicebalon.json.JsonBodyListForTableModelTRM202;
import com.vk.servicebalon.modbus.entity.ModbusBodyDateRange;
import com.vk.servicebalon.service.ServiceTRM138;
import com.vk.servicebalon.service.ServiceTRM202;
import com.vk.servicebalon.table.TableModelTRM138;
import com.vk.servicebalon.table.TableModelTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/database/trm138")
public class ControllerDatabaseForTRM138 {

    private final ServiceTRM138 service;

    @Autowired
    public ControllerDatabaseForTRM138(final ServiceTRM138 service) {
        this.service = service;
    }

    @RequestMapping(value = "/range", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public JsonBodyListForTableModelTRM138 rangeOfData(@RequestBody ModbusBodyDateRange modbusBodyDateRange){
        List<TableModelTRM138> tableModelList = service.findByDateBetween(modbusBodyDateRange.getFrom(), modbusBodyDateRange.getTo());
        JsonBodyListForTableModelTRM138 jsonBodyListForTableModel = new JsonBodyListForTableModelTRM138();
        jsonBodyListForTableModel.setTableModelList(tableModelList);
        return jsonBodyListForTableModel;
    }

    @RequestMapping(value = "/get-last-row", method = RequestMethod.GET)
    public TableModelTRM138 getLastRowFromTableModel(){
        return service.findLastValueByDate();
    }

    @RequestMapping(value = "/get-current-date-time", method = RequestMethod.GET)
    public LocalDateTime getLocalDateTime(){
        return LocalDateTime.now();
    }
}
