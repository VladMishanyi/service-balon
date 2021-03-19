package com.vk.servicebalon.chain;

import com.vk.servicebalon.modbus.entity.ModbusBodyQuery;
import com.vk.servicebalon.tasks.TaskTRM138;
import com.vk.servicebalon.tasks.TaskTRM202;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.Queue;

@Component
@ComponentScan(basePackages = {"com.vk.servicebalon.tasks"})
public class ChainModbus extends Thread{

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    public static Queue<ModbusBodyQuery> modbusBodyQueryQueue = new LinkedList<>();

    private final TaskTRM202 taskTRM202;

    private final TaskTRM138 taskTRM138;

    @Autowired
    public ChainModbus(final TaskTRM202 taskTRM202, final TaskTRM138 taskTRM138){
        this.taskTRM202 = taskTRM202;
        this.taskTRM138 = taskTRM138;
        this.start();
    }

    @Override
    public void run(){
        while (!this.isInterrupted()){
            try {

//                taskTRM202.readModbusAndWriteToTable();

                taskTRM138.readModbusAndWriteToTable();

                checkQueryQueue();

                this.sleep(1000);
            }catch (InterruptedException e){
                String message = e.getMessage();
                LOGGER.error("Interrupted"+this.getClass()+"thread --"+message);
                System.out.println("Interrupted"+this.getClass()+"thread --"+message);
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
                        LOGGER.error("Wrong command in ChainModbus --"+body.getQueryNumber());
                        System.out.println("Wrong command in ChainModbus --"+body.getQueryNumber());
                        break;
                    }
                }
            }
        }
    }
}
