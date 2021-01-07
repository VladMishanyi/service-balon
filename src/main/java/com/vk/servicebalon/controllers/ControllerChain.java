package com.vk.servicebalon.controllers;

import com.vk.servicebalon.chain.ChainDatabase;
import com.vk.servicebalon.chain.ChainModbus;
import com.vk.servicebalon.service.ServiceTRM202;
import com.vk.servicebalon.tasks.TaskTRM138;
import com.vk.servicebalon.tasks.TaskTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;

@RestController
@EnableScheduling
@ComponentScan(basePackages = {"com.vk.servicebalon.chain"})
@RequestMapping(value = "/chain")
public class ControllerChain {

    private ChainModbus chainModbus;

    private ChainDatabase chainDatabase;

    private TaskTRM202 taskTRM202;

    private TaskTRM138 taskTRM138;

    @Autowired
    public ControllerChain(final ChainDatabase chainDatabase,
                           final ChainModbus chainModbus,
                           final TaskTRM202 taskTRM202,
                           final TaskTRM138 taskTRM138){
        this.chainDatabase = chainDatabase;
        this.chainModbus = chainModbus;
        this.taskTRM202 = taskTRM202;
        this.taskTRM138 = taskTRM138;
    }

    @RequestMapping(value = "/modbus", method = RequestMethod.GET)
    public boolean checkStatusModbusChain(){
        return chainModbus.isAlive();
    }

    @RequestMapping(value = "/database", method = RequestMethod.GET)
    public boolean checkStatusDatabaseChain(){
        return chainDatabase.isAlive();
    }

    @Scheduled(fixedRate = 1000*60)
    private void loopModbus(){
        if (!chainModbus.isAlive()){
            chainModbus = new ChainModbus(taskTRM202, taskTRM138);
        }
    }

//    @Scheduled(fixedRate = 1000*60)
//    private void loopDatabase(){
//        if (!chainDatabase.isAlive()){
//            chainDatabase = new ChainDatabase(taskTRM202);
//        }
//    }
}