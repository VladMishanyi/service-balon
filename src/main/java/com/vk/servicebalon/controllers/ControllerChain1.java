package com.vk.servicebalon.controllers;

import com.vk.servicebalon.chain.Chain1;
import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.json.JsonBodyListForTableModelTRM202;
import com.vk.servicebalon.modbus.entity.ModbusBodyDateRange;
import com.vk.servicebalon.modbus.entity.ModbusBodyQuery;
import com.vk.servicebalon.table.TableModelTRM202;
import com.vk.servicebalon.tasks.TaskTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Queue;

@RestController
@EnableScheduling
@ComponentScan(basePackages = {"com.vk.servicebalon.chain"})
@RequestMapping(value = "/chain1")
public class ControllerChain1 {

    private Chain1 chain1;

    private final TaskTRM202 taskTRM202;

    @Autowired
    public ControllerChain1(final Chain1 chain1, final TaskTRM202 taskTRM202){
        this.chain1 = chain1;
        this.taskTRM202 = taskTRM202;
    }

    @Scheduled(fixedRate = 5000)
    private void loop(){
//        LocalDateTime to = LocalDateTime.now();
//        LocalDateTime from = to.minusDays(1);
//        Date dateTo = Date.from(to.atZone(ZoneId.systemDefault()).toInstant());
//        Date dateFrom = Date.from(from.atZone(ZoneId.systemDefault()).toInstant());
//        ModbusBodyDateRange modbusBodyDateRange = new ModbusBodyDateRange(dateFrom, dateTo);
//        RestTemplate restTemplate = new RestTemplate();
//        DeviceModelTRM202 deviceModelTRM202 = restTemplate.getForObject("http://192.168.8.149:8080/modbus/read-all", DeviceModelTRM202.class);
//        assert deviceModelTRM202 != null;
//        System.out.println(deviceModelTRM202.getHoldingRegister0());

//        JsonBodyListForTableModelTRM202 jsonBodyListForTableModelTRM202 = restTemplate.postForObject("http://192.168.8.149:8080/database/range", modbusBodyDateRange, JsonBodyListForTableModelTRM202.class);

        if (!chain1.isAlive()){
            chain1 = new Chain1(taskTRM202);
        }
    }
}
