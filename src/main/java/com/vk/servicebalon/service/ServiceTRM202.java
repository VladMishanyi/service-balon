package com.vk.servicebalon.service;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.table.TableModelTRM202;

import java.util.Date;
import java.util.List;

public interface ServiceTRM202 {

    List<TableModelTRM202> findByDateBetween (Date start, Date end);

    void addTabeDevice(TableModelTRM202 tableModel);

    DeviceModelTRM202 readDataFromRegisterAll();
    DeviceModelTRM202 readDataFromRegister0();
    DeviceModelTRM202 readDataFromRegister1();

    DeviceModelTRM202 writeDataToRegister0(final float value);
    DeviceModelTRM202 writeDataToRegister1(final float value);
}
