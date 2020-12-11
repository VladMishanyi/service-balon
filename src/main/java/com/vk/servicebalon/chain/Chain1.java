package com.vk.servicebalon.chain;

import com.vk.servicebalon.modbus.entity.ModbusBodyQuery;
import com.vk.servicebalon.tasks.TaskTRM202;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
public class Chain1 extends Thread{

    private Logger LOGGER = Logger.getLogger(Chain1.class);

    private final TaskTRM202 taskTRM202;

    @Autowired
    public Chain1(final TaskTRM202 taskTRM202){
        this.taskTRM202 = taskTRM202;
        this.start();
    }

        @Override
    public void run(){
        while (!this.isInterrupted()){
            try {
                taskTRM202.work();

                this.sleep(1000);
            }catch (InterruptedException e){
                String message = e.getMessage();
                LOGGER.error("Interrupted chain1 thread --"+message);
                System.out.println("Interrupted chain1 thread --"+message);
            }
        }
    }
}
