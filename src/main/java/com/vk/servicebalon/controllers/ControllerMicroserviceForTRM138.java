package com.vk.servicebalon.controllers;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.json.JsonBodyFloat;
import com.vk.servicebalon.service.ServiceTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/trm138")
public class ControllerMicroserviceForTRM138 {

    private final ServiceTRM202 serviceTRM202;

//    public ControllerDatabase() {
//    }

    @Autowired
    public ControllerMicroserviceForTRM138(final ServiceTRM202 serviceTRM202) {
        this.serviceTRM202 = serviceTRM202;
    }

    @RequestMapping(value = "/read-all",method = RequestMethod.GET)
    public DeviceModelTRM202 readRegisterAll(){
        return serviceTRM202.readDataFromRegisterAll();
    }

    @RequestMapping(value = "/read-register0",method = RequestMethod.GET)
    public DeviceModelTRM202 readRegister0(){
        return serviceTRM202.readDataFromRegister0();
    }

    @RequestMapping(value = "/read-register1",method = RequestMethod.GET)
    public DeviceModelTRM202 readRegister1(){
        return serviceTRM202.readDataFromRegister1();
    }

    @RequestMapping(value = "write-register1", method = RequestMethod.POST)
    public void writeRegister0(final JsonBodyFloat jsonBodyFloat){
        serviceTRM202.writeDataToRegister0(jsonBodyFloat.getValue());

    }

    @RequestMapping(value = "write-register2", method = RequestMethod.POST)
    public void writeRegister2(final JsonBodyFloat jsonBodyFloat){
        serviceTRM202.writeDataToRegister1(jsonBodyFloat.getValue());
    }
}
