package com.vk.servicebalon.controllers;

import com.vk.servicebalon.chain.ChainModbus;
import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.json.JsonBodyFloat;
import com.vk.servicebalon.modbus.entity.ModbusBodyQuery;
import com.vk.servicebalon.service.ServiceTRM202;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/modbus")
public class ControllerModbusForTRM202 {

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    private final ServiceTRM202 serviceTRM202;

    private final DeviceModelTRM202 deviceModelTRM202;

    @Autowired
    public ControllerModbusForTRM202(final ServiceTRM202 serviceTRM202, final DeviceModelTRM202 deviceModelTRM202) {
        this.serviceTRM202 = serviceTRM202;
        this.deviceModelTRM202 = deviceModelTRM202;
    }

    @RequestMapping(value = "/read-all",method = RequestMethod.GET)
    public DeviceModelTRM202 readRegisterAll(){
        return deviceModelTRM202;
    }

    @RequestMapping(value = "/read-register0",method = RequestMethod.GET)
    public DeviceModelTRM202 readRegister0(){
        return deviceModelTRM202;
    }

    @RequestMapping(value = "/read-register1",method = RequestMethod.GET)
    public DeviceModelTRM202 readRegister1(){
        return deviceModelTRM202;
    }

    @RequestMapping(value = "/write-register0", method = RequestMethod.POST)
    public void writeRegister0(final JsonBodyFloat jsonBodyFloat){
        float val = jsonBodyFloat.getValue();

        if ( (val >= 0F) && (val <= 65000F) ){
            ChainModbus.modbusBodyQueryQueue.add(new ModbusBodyQuery(1, val));
        } else{
            LOGGER.error("/second_ceh_kamera_vulcan1_MPR51/write_steam_pwm  - out of bound length :"+val);
            System.out.println("/second_ceh_kamera_vulcan1_MPR51/write_steam_pwm - out of bound length :"+val);
        }
    }

    @RequestMapping(value = "/write-register1", method = RequestMethod.POST)
    public void writeRegister1(final JsonBodyFloat jsonBodyFloat){
        float val = jsonBodyFloat.getValue();

        if ( (val >= 0F) && (val <= 65000F) ){
            ChainModbus.modbusBodyQueryQueue.add(new ModbusBodyQuery(2, val));
        } else{
            LOGGER.error("/second_ceh_kamera_vulcan1_MPR51/write_steam_pwm  - out of bound length :"+val);
            System.out.println("/second_ceh_kamera_vulcan1_MPR51/write_steam_pwm - out of bound length :"+val);
        }
    }
}
