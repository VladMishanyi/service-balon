package com.vk.servicebalon.service;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.json.JsonBodyListForTableModelTRM202;
import com.vk.servicebalon.modbus.en.DigsFloat;
import com.vk.servicebalon.repository.database.RepositoryDatabaseTRM202;
import com.vk.servicebalon.repository.microservice.RepositoryRaspberryBalon;
import com.vk.servicebalon.repository.modbus.RepositoryModbusTRM202;
import com.vk.servicebalon.table.TableModelTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
@ComponentScan(basePackages = {"com.vk.servicebalon.repository.database","com.vk.servicebalon.repository.modbus"})
public class ServiceTRM202Impl implements ServiceTRM202 {

    private final RepositoryDatabaseTRM202 repositoryDatabaseTRM202;

    private final RepositoryModbusTRM202 repositoryModbusTRM202;

    private final RepositoryRaspberryBalon repositoryRaspberryBalon;


    @Autowired
    public ServiceTRM202Impl(final RepositoryDatabaseTRM202 repositoryDatabaseTRM202,
                             final RepositoryModbusTRM202 repositoryModbusTRM202,
                             final RepositoryRaspberryBalon repositoryRaspberryBalon){
        this.repositoryDatabaseTRM202 = repositoryDatabaseTRM202;
        this.repositoryModbusTRM202 = repositoryModbusTRM202;
        this.repositoryRaspberryBalon = repositoryRaspberryBalon;
    }
    @Override
    public JsonBodyListForTableModelTRM202 readJsonTableModelTRM202BetweenDate(LocalDateTime start, LocalDateTime end){
        return repositoryRaspberryBalon.readJsonTableModelTRM202BetweenDate(start, end);
    }
    @Override
    public TableModelTRM202 readJsonTableModelTRM202Last(){
        return repositoryRaspberryBalon.readJsonTableModelTRM202Last();
    }
    @Override
    public DeviceModelTRM202 readJsonDeviceModelTRM202allRegisters(){
        return repositoryRaspberryBalon.readJsonDeviceModelTRM202allRegisters();
    }

    @Transactional(readOnly = true)
    @Override
    public List<TableModelTRM202> findByDateBetween(LocalDateTime start, LocalDateTime end) {
        return repositoryDatabaseTRM202.findByDateBetween(start, end);
    }
    @Transactional(readOnly = true)
    @Override
    public TableModelTRM202 findLastValueByDate (){
        return repositoryDatabaseTRM202.findLastValueByDate();
    }
    @Transactional
    @Override
    public void addTableDevice(TableModelTRM202 tableModel) {
        repositoryDatabaseTRM202.saveAndFlush(tableModel);
    }
    @Transactional
    @Override
    public void addAllTableDevice(List<TableModelTRM202> tableModelTRM202List){
        repositoryDatabaseTRM202.saveAll(tableModelTRM202List);
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
