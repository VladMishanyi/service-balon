package com.vk.servicebalon.repository.database;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.modbus.en.DigsFloat;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface RepositoryDatabaseTRM202 extends CrudRepository<DeviceModelTRM202, Long> {

    List<DeviceModelTRM202> findByDateBetween (Date start, Date end);
}
