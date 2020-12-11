package com.vk.servicebalon.service;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.modbus.en.DigsFloat;
import com.vk.servicebalon.repository.database.RepositoryDatabaseTRM202;
import com.vk.servicebalon.repository.modbus.RepositoryModbusTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Component
@ComponentScan(basePackages = {"com.vk.servicebalon.repository.database","com.vk.servicebalon.repository.modbus"})
public class ServiceTRM202Impl implements ServiceTRM202 {

    private final RepositoryDatabaseTRM202 repositoryDatabaseTRM202;

    private final RepositoryModbusTRM202 repositoryModbusTRM202;

//    public ServiceModbusTRM202Impl(){}

    @Autowired
    public ServiceTRM202Impl(final RepositoryDatabaseTRM202 repositoryDatabaseTRM202,
                             final RepositoryModbusTRM202 repositoryModbusTRM202){
        this.repositoryDatabaseTRM202 = repositoryDatabaseTRM202;
        this.repositoryModbusTRM202 = repositoryModbusTRM202;
    }

    @Transactional(readOnly = true)
    @Override
    public List<DeviceModelTRM202> findByDateBetween(Date start, Date end) {
        return repositoryDatabaseTRM202.findByDateBetween(start, end);
    }

    @Transactional
    @Override
    public void addTabeDevice(DeviceModelTRM202 tableModel) {
        repositoryDatabaseTRM202.save(tableModel);
    }

    @Override
    public DeviceModelTRM202 readDataFromRegisterAll() {
        return repositoryModbusTRM202.readDataFromRegisterAll(true, (short) 0, (short) 500, DigsFloat.ONE_DIG, false);
    }

    @Override
    public DeviceModelTRM202 readDataFromRegister0() {
        return repositoryModbusTRM202.readDataFromRegister0(true, (short) 0, (short) 500, DigsFloat.ONE_DIG, false);
    }

    @Override
    public DeviceModelTRM202 readDataFromRegister1() {
        return repositoryModbusTRM202.readDataFromRegister1(true, (short) 0, (short) 500, DigsFloat.ONE_DIG, false);
    }

    @Override
    public DeviceModelTRM202 writeDataToRegister0(float value) {
        return repositoryModbusTRM202.writeDataToRegister0(value);
    }

    @Override
    public DeviceModelTRM202 writeDataToRegister1(float value) {
        return repositoryModbusTRM202.writeDataToRegister1(value);
    }
}
