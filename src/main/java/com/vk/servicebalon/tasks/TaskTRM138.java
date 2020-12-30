package com.vk.servicebalon.tasks;

import com.vk.servicebalon.device.DeviceModelTRM138;
import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.device_to_table.DeviceToTableTRM138;
import com.vk.servicebalon.device_to_table.DeviceToTableTRM202;
import com.vk.servicebalon.service.ServiceTRM138;
import com.vk.servicebalon.service.ServiceTRM202;

public interface TaskTRM138 {

    public ServiceTRM138 getServiceTRM138();

    public DeviceModelTRM138 getDeviceModelTRM138();

    public DeviceToTableTRM138 getDeviceToTableTRM138();

    void readModbusAndWriteToTable();

}
