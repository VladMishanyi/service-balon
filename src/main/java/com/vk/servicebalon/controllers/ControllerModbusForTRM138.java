package com.vk.servicebalon.controllers;

import com.vk.servicebalon.chain.ChainModbus;
import com.vk.servicebalon.device.DeviceModelTRM138;
import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.json.JsonBodyFloat;
import com.vk.servicebalon.modbus.entity.ModbusBodyQuery;
import com.vk.servicebalon.service.ServiceTRM138;
import com.vk.servicebalon.service.ServiceTRM202;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
