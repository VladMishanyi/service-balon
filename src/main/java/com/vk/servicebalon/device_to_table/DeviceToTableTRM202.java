package com.vk.servicebalon.device_to_table;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.table.TableModelTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Component
@ComponentScan(basePackages = {"com.vk.servicebalon.device", "com.vk.servicebalon.table"})
public class DeviceToTableTRM202 {

    private final DeviceModelTRM202 deviceModelTRM202;

//    private final TableModelTRM202 tableModelTRM202;

    @Autowired
    public DeviceToTableTRM202(final DeviceModelTRM202 deviceModelTRM202/*, final TableModelTRM202 tableModelTRM202*/){
        this.deviceModelTRM202 = deviceModelTRM202;
//        this.tableModelTRM202 = tableModelTRM202;
    }

    public TableModelTRM202 convert(){
        final TableModelTRM202 tableModelTRM202 = new TableModelTRM202();
        if (Objects.nonNull(deviceModelTRM202)){
            tableModelTRM202.setDate(LocalDateTime.now());
            tableModelTRM202.setHoldingRegister0(deviceModelTRM202.getHoldingRegister0());
            tableModelTRM202.setHoldingRegister1(deviceModelTRM202.getHoldingRegister1());
        }
        return tableModelTRM202;
    }
}
