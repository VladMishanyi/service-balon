package com.vk.servicebalon.chain;

import com.vk.servicebalon.tasks.TaskTRM202;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = {"com.vk.servicebalon.tasks"})
public class ChainDatabase extends Thread{

    private final Logger LOGGER = Logger.getLogger(this.getClass());

    private final TaskTRM202 taskTRM202;

    @Autowired
    public ChainDatabase(final TaskTRM202 taskTRM202){
        this.taskTRM202 = taskTRM202;
        this.start();
    }

    @Override
    public void run(){
        while (!this.isInterrupted()){
            try {

                taskTRM202.syncDatabase();

                this.sleep(10000);
            }catch (InterruptedException e){
                String message = e.getMessage();
                LOGGER.error("Interrupted ChainDatabase thread --"+message);
                System.out.println("Interrupted ChainDatabase thread --"+message);
            }
        }
    }
}
