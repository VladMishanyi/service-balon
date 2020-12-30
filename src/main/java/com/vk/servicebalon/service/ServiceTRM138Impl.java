package com.vk.servicebalon.service;

import com.vk.servicebalon.device.DeviceModelTRM138;
import com.vk.servicebalon.modbus.en.DigsFloat;
import com.vk.servicebalon.repository.database.RepositoryDatabaseTRM138;
import com.vk.servicebalon.repository.database.RepositoryDatabaseTRM202;
import com.vk.servicebalon.repository.modbus.RepositoryModbusTRM138;
import com.vk.servicebalon.repository.modbus.RepositoryModbusTRM202;
import com.vk.servicebalon.table.TableModelTRM138;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@ComponentScan(basePackages = {"com.vk.servicebalon.repository.database","com.vk.servicebalon.repository.modbus"})
public class ServiceTRM138Impl implements ServiceTRM138{


    private final RepositoryDatabaseTRM138 repositoryDatabaseTRM138;

    private final RepositoryModbusTRM138 repositoryModbusTRM138;

    @Autowired
    public ServiceTRM138Impl(RepositoryDatabaseTRM138 repositoryDatabaseTRM138, RepositoryModbusTRM138 repositoryModbusTRM138) {
        this.repositoryDatabaseTRM138 = repositoryDatabaseTRM138;
        this.repositoryModbusTRM138 = repositoryModbusTRM138;
    }

    @Transactional(readOnly = true)
    @Override
    public List<TableModelTRM138> findByDateBetween (final LocalDateTime start, final LocalDateTime end){
        return repositoryDatabaseTRM138.findByDateBetween(start, end);
    }
    @Transactional(readOnly = true)
    @Override
    public TableModelTRM138 findLastValueByDate (){
        return repositoryDatabaseTRM138.findLastValueByDate();
    }
    @Transactional
    @Override
    public void addTableDevice(final TableModelTRM138 tableModel){
        repositoryDatabaseTRM138.saveAndFlush(tableModel);
    }
    @Transactional
    @Override
    public void addAllTableDevice(final List<TableModelTRM138> tableModelTRM138List){
        repositoryDatabaseTRM138.saveAll(tableModelTRM138List);
    }

    @Override
    public DeviceModelTRM138 readDataFromRegisterAll(){
        return repositoryModbusTRM138.readDataFromRegisterAll(true, (short) 0, (short) 500, DigsFloat.ONE_DIG, false);

    }
    @Override
    public DeviceModelTRM138 readDataFromRegister0(){
        return repositoryModbusTRM138.readDataFromRegister0(true, (short) 0, (short) 500, DigsFloat.ONE_DIG, false);
    }
    @Override
    public DeviceModelTRM138 readDataFromRegister1(){
        return repositoryModbusTRM138.readDataFromRegister1(true, (short) 0, (short) 500, DigsFloat.ONE_DIG, false);
    }
    @Override
    public DeviceModelTRM138 readDataFromRegister2(){
        return repositoryModbusTRM138.readDataFromRegister2(true, (short) 0, (short) 500, DigsFloat.ONE_DIG, false);
    }
    @Override
    public DeviceModelTRM138 readDataFromRegister3(){
        return repositoryModbusTRM138.readDataFromRegister3(true, (short) 0, (short) 500, DigsFloat.ONE_DIG, false);
    }
    @Override
    public DeviceModelTRM138 readDataFromRegister4(){
        return repositoryModbusTRM138.readDataFromRegister4(true, (short) 0, (short) 500, DigsFloat.ONE_DIG, false);
    }
    @Override
    public DeviceModelTRM138 readDataFromRegister5(){
        return repositoryModbusTRM138.readDataFromRegister5(true, (short) 0, (short) 500, DigsFloat.ONE_DIG, false);
    }
    @Override
    public DeviceModelTRM138 readDataFromRegister6(){
        return repositoryModbusTRM138.readDataFromRegister6(true, (short) 0, (short) 500, DigsFloat.ONE_DIG, false);
    }
    @Override
    public DeviceModelTRM138 readDataFromRegister7(){
        return repositoryModbusTRM138.readDataFromRegister7(true, (short) 0, (short) 500, DigsFloat.ONE_DIG, false);
    }
    @Override
    public DeviceModelTRM138 writeDataToRegister0(final short value){
        return repositoryModbusTRM138.writeDataToRegister0(value);
    }
    @Override
    public DeviceModelTRM138 writeDataToRegister1(final short value){
        return repositoryModbusTRM138.writeDataToRegister1(value);
    }
    @Override
    public DeviceModelTRM138 writeDataToRegister2(final short value){
        return repositoryModbusTRM138.writeDataToRegister2(value);
    }
    @Override
    public DeviceModelTRM138 writeDataToRegister3(final short value){
        return repositoryModbusTRM138.writeDataToRegister3(value);
    }
    @Override
    public DeviceModelTRM138 writeDataToRegister4(final short value){
        return repositoryModbusTRM138.writeDataToRegister4(value);
    }
    @Override
    public DeviceModelTRM138 writeDataToRegister5(final short value){
        return repositoryModbusTRM138.writeDataToRegister5(value);
    }
    @Override
    public DeviceModelTRM138 writeDataToRegister6(final short value){
        return repositoryModbusTRM138.writeDataToRegister6(value);
    }
    @Override
    public DeviceModelTRM138 writeDataToRegister7(final short value){
        return repositoryModbusTRM138.writeDataToRegister7(value);
    }

}
