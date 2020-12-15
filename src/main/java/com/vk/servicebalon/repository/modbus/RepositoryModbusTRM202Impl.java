package com.vk.servicebalon.repository.modbus;

import com.serotonin.modbus4j.BatchRead;
import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.modbus.ModbusFloat;
import com.vk.servicebalon.modbus.en.DigsFloat;
import com.vk.servicebalon.modbus.entity.ModbusMasterSerialModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@ComponentScan(basePackages = {"com.vk.servicebalon.device","com.vk.servicebalon.modbus"})
public class RepositoryModbusTRM202Impl implements RepositoryModbusTRM202{

    private final ModbusMasterSerialModel modbusMasterSerialFirst;

    private final DeviceModelTRM202 deviceModelTRM202;

    private final BatchRead<Integer> batchRead;

    private final ModbusFloat modbusFloat;

    @Autowired
    public RepositoryModbusTRM202Impl(final ModbusMasterSerialModel modbusMasterSerialFirst,
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
        if (Objects.nonNull(modbusFloat)){
            modbusFloat.setUseBorders(useBorders, borderMax, borderMin);
            final List<Float> listFloat =  modbusFloat.readDataFromModBusDigs(
                    digsFloat,
                    modbusMasterSerialFirst,
                    deviceModelTRM202.getDeviceAddress(),
                    batchRead,
                    enableBatch,
                    deviceModelTRM202.getModbusLocator0h(),
                    deviceModelTRM202.getModbusLocator1h());
            deviceModelTRM202.setHoldingRegister0(listFloat.get(0));
            deviceModelTRM202.setHoldingRegister1(listFloat.get(1));
        }
        return deviceModelTRM202;
    }

    @Override
    public DeviceModelTRM202 readDataFromRegister0(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch) {
        if (Objects.nonNull(modbusFloat)){
            modbusFloat.setUseBorders(useBorders, borderMax, borderMin);
            final List<Float> listFloat = modbusFloat.readDataFromModBusDigs(
                    digsFloat,
                    modbusMasterSerialFirst,
                    deviceModelTRM202.getDeviceAddress(),
                    batchRead,
                    enableBatch,
                    deviceModelTRM202.getModbusLocator0h());
            deviceModelTRM202.setHoldingRegister0(listFloat.get(0));
        }
        return deviceModelTRM202;
    }

    @Override
    public DeviceModelTRM202 readDataFromRegister1(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch) {
        if (Objects.nonNull(modbusFloat)){
            modbusFloat.setUseBorders(useBorders, borderMax, borderMin);
            final List<Float> listFloat = modbusFloat.readDataFromModBusDigs(
                    digsFloat,
                    modbusMasterSerialFirst,
                    deviceModelTRM202.getDeviceAddress(),
                    batchRead,
                    enableBatch,
                    deviceModelTRM202.getModbusLocator1h());
            deviceModelTRM202.setHoldingRegister1(listFloat.get(0));
        }
        return deviceModelTRM202;
    }

    @Override
    public DeviceModelTRM202 writeDataToRegister0(float value) {
        if (Objects.nonNull(modbusFloat)){
            modbusFloat.writeDataToModBus(
                    modbusMasterSerialFirst,
                    deviceModelTRM202.getDeviceAddress(),
                    value,
                    deviceModelTRM202.getModbusLocator2h());
            deviceModelTRM202.setHoldingRegister2(value);
        }
        return deviceModelTRM202;
    }

    @Override
    public DeviceModelTRM202 writeDataToRegister1(float value) {
        if (Objects.nonNull(modbusFloat)){
            modbusFloat.writeDataToModBus(
                    modbusMasterSerialFirst,
                    deviceModelTRM202.getDeviceAddress(),
                    value,
                    deviceModelTRM202.getModbusLocator3h());
            deviceModelTRM202.setHoldingRegister3(value);
        }
        return deviceModelTRM202;

    }
}
