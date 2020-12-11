package com.vk.servicebalon.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/trm138")
public class ControllerMicroserviceForTRM138 {

    public ControllerMicroserviceForTRM138() {
    }

    @RequestMapping(value = "/read-all",method = RequestMethod.GET)
    public String readRegisterAll(){
        return "{status: ready}";
    }

    @RequestMapping(value = "/read-register1",method = RequestMethod.GET)
    public String readRegister1(){
        return "{status: ready1}";
    }

    @RequestMapping(value = "/read-register2",method = RequestMethod.GET)
    public String readRegister2(){
        return "{status: ready2}";
    }

    @RequestMapping(value = "write-register1", method = RequestMethod.POST)
    public void writeRegister1(){

    }

    @RequestMapping(value = "write-register2", method = RequestMethod.POST)
    public void writeRegister2(){

    }
}
