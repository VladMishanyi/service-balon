package com.vk.servicebalon.tasks;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.service.ServiceTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = {"com.vk.servicebalon.service", "com.vk.servicebalon.device"})
public class TaskTRM202Impl implements TaskTRM202{

    private final ServiceTRM202 serviceTRM202;

    private final DeviceModelTRM202 deviceModelTRM202;

    @Autowired
    public TaskTRM202Impl(final ServiceTRM202 serviceTRM202, final DeviceModelTRM202 deviceModelTRM202){
        this.serviceTRM202 = serviceTRM202;
        this.deviceModelTRM202 = deviceModelTRM202;
    }

    @Override
    public void work() {
        serviceTRM202.readDataFromRegisterAll();
        if (deviceModelTRM202.hysteresis()){
            serviceTRM202.addTabeDevice(deviceModelTRM202);
        }
    }
}
