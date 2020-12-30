package com.vk.servicebalon.device_to_table;

import com.vk.servicebalon.device.DeviceModelTRM138;
import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.table.TableModelTRM138;
import com.vk.servicebalon.table.TableModelTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Objects;

@Component
@ComponentScan(basePackages = {"com.vk.servicebalon.device", "com.vk.servicebalon.table"})
public class DeviceToTableTRM138 {

    private final DeviceModelTRM138 deviceModelTRM138;

    @Autowired
    public DeviceToTableTRM138(final DeviceModelTRM138 deviceModelTRM138){
        this.deviceModelTRM138 = deviceModelTRM138;
    }

    public TableModelTRM138 convert(){
        final TableModelTRM138 tableModelTRM138 = new TableModelTRM138();
        if (Objects.nonNull(deviceModelTRM138)){
            tableModelTRM138.setDate(LocalDateTime.now());
            tableModelTRM138.setInputRegister0(deviceModelTRM138.getInputRegister0());
            tableModelTRM138.setInputRegister1(deviceModelTRM138.getInputRegister1());
            tableModelTRM138.setInputRegister2(deviceModelTRM138.getInputRegister2());
            tableModelTRM138.setInputRegister3(deviceModelTRM138.getInputRegister3());
            tableModelTRM138.setInputRegister4(deviceModelTRM138.getInputRegister4());
        }
        return tableModelTRM138;
    }
}
