package com.vk.servicebalon.tasks;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.device_to_table.DeviceToTableTRM202;
import com.vk.servicebalon.service.ServiceTRM202;

public interface TaskTRM202{

    public ServiceTRM202 getServiceTRM202();

    public DeviceModelTRM202 getDeviceModelTRM202();

    public DeviceToTableTRM202 getDeviceToTableTRM202();

    void work();
}
