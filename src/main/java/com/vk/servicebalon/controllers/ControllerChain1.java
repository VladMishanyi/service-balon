package com.vk.servicebalon.controllers;

import com.vk.servicebalon.chain.ChainDatabase;
import com.vk.servicebalon.chain.ChainModbus;
import com.vk.servicebalon.service.ServiceTRM202;
import com.vk.servicebalon.tasks.TaskTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@EnableScheduling
@ComponentScan(basePackages = {"com.vk.servicebalon.chain"})
@RequestMapping(value = "/chain1")
public class ControllerChain1 {

    private ChainModbus chainModbus;

    private ChainDatabase chainDatabase;

    private final TaskTRM202 taskTRM202;

    private final ServiceTRM202 serviceTRM202;

    @Autowired
    public ControllerChain1(final ChainModbus chainModbus,
                            final TaskTRM202 taskTRM202,
                            final ServiceTRM202 serviceTRM202,
                            final ChainDatabase chainDatabase){
        this.chainModbus = chainModbus;
        this.taskTRM202 = taskTRM202;
        this.serviceTRM202 = serviceTRM202;
        this.chainDatabase = chainDatabase;
    }

//    @Scheduled(fixedRate = 10000)
//    private void loopModbus(){
//        if (!chainModbus.isAlive()){
//            chainModbus = new ChainModbus(taskTRM202);
//        }
//    }

    @Scheduled(fixedRate = 10000)
    private void loopDatabase(){
        if (!chainDatabase.isAlive()){
            chainDatabase = new ChainDatabase(taskTRM202);
        }
    }
}