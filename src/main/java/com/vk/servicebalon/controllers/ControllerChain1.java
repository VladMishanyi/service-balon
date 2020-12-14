package com.vk.servicebalon.controllers;

import com.vk.servicebalon.chain.Chain1;
import com.vk.servicebalon.modbus.entity.ModbusBodyQuery;
import com.vk.servicebalon.tasks.TaskTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Queue;

@Controller
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

    @Scheduled(fixedRate = 1000)
    private void loop(){
//        if (!chain1.isAlive()){
//            chain1 = new Chain1(taskTRM202);
//        }
        chain1.run();
    }
}
