package com.vk.servicebalon.service;

import com.vk.servicebalon.device.DeviceModelTRM138;
import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.table.TableModelTRM138;
import com.vk.servicebalon.table.TableModelTRM202;

import java.time.LocalDateTime;
import java.util.List;

public interface ServiceTRM138 {
    List<TableModelTRM138> findByDateBetween (final LocalDateTime start, final LocalDateTime end);
    TableModelTRM138 findLastValueByDate ();
    void addTableDevice(final TableModelTRM138 tableModel);
    void addAllTableDevice(final List<TableModelTRM138> tableModelTRM138List);

    DeviceModelTRM138 readDataFromRegisterAll();
    DeviceModelTRM138 readDataFromRegister0();
    DeviceModelTRM138 readDataFromRegister1();
    DeviceModelTRM138 readDataFromRegister2();
    DeviceModelTRM138 readDataFromRegister3();
    DeviceModelTRM138 readDataFromRegister4();
    DeviceModelTRM138 readDataFromRegister5();
    DeviceModelTRM138 readDataFromRegister6();
    DeviceModelTRM138 readDataFromRegister7();
    DeviceModelTRM138 writeDataToRegister0(final short value);
    DeviceModelTRM138 writeDataToRegister1(final short value);
    DeviceModelTRM138 writeDataToRegister2(final short value);
    DeviceModelTRM138 writeDataToRegister3(final short value);
    DeviceModelTRM138 writeDataToRegister4(final short value);
    DeviceModelTRM138 writeDataToRegister5(final short value);
    DeviceModelTRM138 writeDataToRegister6(final short value);
    DeviceModelTRM138 writeDataToRegister7(final short value);
}
