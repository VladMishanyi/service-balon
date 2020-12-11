package com.vk.servicebalon.repository;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.modbus.en.DigsFloat;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface RepositoryTRM202 extends CrudRepository<DeviceModelTRM202, Long> {

    List<DeviceModelTRM202> findByDateBetween (Date start, Date end);

    DeviceModelTRM202 readDataFromRegisterAll(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch);

    void readDataFromRegister0(final boolean enableBatch);
    void readDataFromRegister1(final boolean enableBatch);

    void writeDataToRegister0(final float value);
    void writeDataToRegister1(final float value);
}
