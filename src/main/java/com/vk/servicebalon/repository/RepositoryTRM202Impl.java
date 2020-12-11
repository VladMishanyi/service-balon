package com.vk.servicebalon.repository;

import com.serotonin.modbus4j.BatchRead;
import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.modbus.ModbusFloat;
import com.vk.servicebalon.modbus.en.DigsFloat;
import com.vk.servicebalon.modbus.entity.ModbusMasterSerialModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
@ComponentScan(basePackages = {"com.vk.servicebalon.device","com.vk.servicebalon.modbus"})
public class RepositoryTRM202Impl implements RepositoryTRM202{

    private final ModbusMasterSerialModel modbusMasterSerialFirst;

    private final DeviceModelTRM202 deviceModelTRM202;

    private final BatchRead<Integer> batchRead;

    private final ModbusFloat modbusFloat;

    @Autowired
    public RepositoryTRM202Impl(final ModbusMasterSerialModel modbusMasterSerialFirst,
                                final DeviceModelTRM202 deviceModelTRM202,
                                final BatchRead<Integer> batchRead,
                                final ModbusFloat modbusFloat){

        this.modbusMasterSerialFirst = modbusMasterSerialFirst;
        this.deviceModelTRM202 = deviceModelTRM202;
        this.batchRead = batchRead;
        this.modbusFloat = modbusFloat;
    }

    @Override
    public DeviceModelTRM202 readDataFromRegisterAll(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch){
        modbusFloat.setUseBorders(useBorders, borderMax, borderMin);
        final List<Float> list =  modbusFloat.readDataFromModBusDigs(
                digsFloat,
                modbusMasterSerialFirst,
                deviceModelTRM202.getDeviceAddress(),
                batchRead,
                enableBatch,
                deviceModelTRM202.getModbusLocator0h(),
                deviceModelTRM202.getModbusLocator1h())
        deviceModelTRM202.setHoldingRegister0(list.get(0));
        deviceModelTRM202.setHoldingRegister1(list.get(1));
        return deviceModelTRM202;
    }
}
