package com.vk.servicebalon.chain;

import com.vk.servicebalon.modbus.entity.ModbusBodyQuery;
import com.vk.servicebalon.tasks.TaskTRM202;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
@ComponentScan(basePackages = {"com.vk.servicebalon.tasks"})
public class Chain1 extends Thread{

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    public static Queue<ModbusBodyQuery> modbusBodyQueryQueue = new LinkedList<>();

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

                checkQueryQueue();

                this.sleep(1000);
            }catch (InterruptedException e){
                String message = e.getMessage();
                LOGGER.error("Interrupted chain1 thread --"+message);
                System.out.println("Interrupted chain1 thread --"+message);
            }
        }
    }

    public void checkQueryQueue(){
        if (modbusBodyQueryQueue.size() > 0){
            while (!modbusBodyQueryQueue.isEmpty()){
                ModbusBodyQuery body = modbusBodyQueryQueue.poll();
                switch (body.getQueryNumber()){
                    case 1 : taskTRM202.getServiceTRM202().writeDataToRegister0(body.getValueFloat()); break;
                    case 2 : taskTRM202.getServiceTRM202().writeDataToRegister1(body.getValueFloat()); break;
                    default: {
                        LOGGER.error("Wrong command in Chain1 --"+body.getQueryNumber());
                        System.out.println("Wrong command in Chain1 --"+body.getQueryNumber());
                        break;
                    }
                }
            }
        }
    }
}
