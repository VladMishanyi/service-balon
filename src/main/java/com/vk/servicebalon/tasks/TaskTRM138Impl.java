package com.vk.servicebalon.tasks;

import com.vk.servicebalon.device.DeviceModelTRM138;
import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.device_to_table.DeviceToTableTRM138;
import com.vk.servicebalon.device_to_table.DeviceToTableTRM202;
import com.vk.servicebalon.service.ServiceTRM138;
import com.vk.servicebalon.service.ServiceTRM202;
import com.vk.servicebalon.table.TableModelTRM138;
import com.vk.servicebalon.table.TableModelTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan(basePackages = {"com.vk.servicebalon.service", "com.vk.servicebalon.device"})
public class TaskTRM138Impl implements TaskTRM138{

    private final ServiceTRM138 serviceTRM138;

    private final DeviceModelTRM138 deviceModelTRM138;

    private final DeviceToTableTRM138 deviceToTableTRM138;

    @Autowired
    public TaskTRM138Impl(final ServiceTRM138 serviceTRM138,
                          final DeviceModelTRM138 deviceModelTRM138,
                          final DeviceToTableTRM138 deviceToTableTRM138) {
        this.serviceTRM138 = serviceTRM138;
        this.deviceModelTRM138 = deviceModelTRM138;
        this.deviceToTableTRM138 = deviceToTableTRM138;
    }

    @Override
    public ServiceTRM138 getServiceTRM138() {
        return serviceTRM138;
    }

    @Override
    public DeviceModelTRM138 getDeviceModelTRM138() {
        return deviceModelTRM138;
    }

    @Override
    public DeviceToTableTRM138 getDeviceToTableTRM138() {
        return deviceToTableTRM138;
    }

    @Override
    public void readModbusAndWriteToTable() {
        serviceTRM138.readDataFromRegisterAll();
        if (deviceModelTRM138.hysteresis()){
            TableModelTRM138 tableModelTRM138 = deviceToTableTRM138.convert();
            serviceTRM138.addTableDevice(tableModelTRM138);
        }
    }
}
