package com.vk.servicebalon.controllers;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.json.JsonBodyListForTableModelTRM202;
import com.vk.servicebalon.modbus.entity.ModbusBodyDateRange;
import com.vk.servicebalon.service.ServiceTRM202;
import com.vk.servicebalon.table.TableModelTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
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

    @RequestMapping(value = "/range", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public JsonBodyListForTableModelTRM202 rangeOfData(@RequestBody ModbusBodyDateRange modbusBodyDateRange){
        List<TableModelTRM202> tableModelTRM202List = serviceTRM202.findByDateBetween(modbusBodyDateRange.getFrom(), modbusBodyDateRange.getTo());
        JsonBodyListForTableModelTRM202 jsonBodyListForTableModelTRM202 = new JsonBodyListForTableModelTRM202();
        jsonBodyListForTableModelTRM202.setTableModelList(tableModelTRM202List);
        return jsonBodyListForTableModelTRM202;
    }

    @RequestMapping(value = "/get-last-row", method = RequestMethod.GET)
   public TableModelTRM202 getLastRowFromTableModelTRM202(){
        return serviceTRM202.findLastValueByDate();
   }

   @RequestMapping(value = "/get-current-date-time", method = RequestMethod.GET)
   public LocalDateTime getLocalDateTime(){
        return LocalDateTime.now();
   }
}
