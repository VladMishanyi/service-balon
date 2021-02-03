package com.vk.servicebalon.controllers;

import com.vk.servicebalon.chain.ChainModbus;
import com.vk.servicebalon.device.DeviceAirSensor;
import com.vk.servicebalon.device.DeviceModelTRM138;
import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.json.JsonBodyFloat;
import com.vk.servicebalon.modbus.entity.ModbusBodyQuery;
import com.vk.servicebalon.service.ServiceTRM138;
import com.vk.servicebalon.service.ServiceTRM202;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;

@RestController
@RequestMapping(value = "/modbus/trm138")
public class ControllerModbusForTRM138 {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    private final ServiceTRM138 service;

    private final DeviceModelTRM138 deviceModel;

    @Autowired
    public ControllerModbusForTRM138(final ServiceTRM138 service, final DeviceModelTRM138 deviceModel) {
        this.service = service;
        this.deviceModel = deviceModel;
    }

    @RequestMapping(value = "/read-all",method = RequestMethod.GET)
    public DeviceModelTRM138 readRegisterAll(){
        return deviceModel;
    }

//    @RequestMapping(value = "/sensor", method = RequestMethod.POST)
//    public void getSensorValue(@RequestBody Map<String, Object> json){
//        System.out.println(json);
//    }

    @RequestMapping(value = "/sensor", consumes = "application/json", produces = "application/json", method = RequestMethod.POST)
    public void getSensorValueJson(@RequestBody DeviceAirSensor json){
        System.out.println(json.toString());
        Arrays.stream(json.getSensordatavalues()).forEach(System.out::println);
    }
}
