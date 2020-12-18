package com.vk.servicebalon.service;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.json.JsonBodyListForTableModelTRM202;
import com.vk.servicebalon.table.TableModelTRM202;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface ServiceTRM202 {

    JsonBodyListForTableModelTRM202 readJsonTableModelTRM202BetweenDate(LocalDateTime start, LocalDateTime end);
    TableModelTRM202 readJsonTableModelTRM202Last();
    DeviceModelTRM202 readJsonDeviceModelTRM202allRegisters();

    List<TableModelTRM202> findByDateBetween (LocalDateTime start, LocalDateTime end);
    TableModelTRM202 findLastValueByDate ();
    void addTabeDevice(TableModelTRM202 tableModel);

    DeviceModelTRM202 readDataFromRegisterAll();
    DeviceModelTRM202 readDataFromRegister0();
    DeviceModelTRM202 readDataFromRegister1();
    DeviceModelTRM202 writeDataToRegister0(final float value);
    DeviceModelTRM202 writeDataToRegister1(final float value);
}
