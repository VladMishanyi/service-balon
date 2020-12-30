package com.vk.servicebalon.repository.modbus;

import com.serotonin.modbus4j.BatchRead;
import com.vk.servicebalon.device.DeviceModelTRM138;
import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.modbus.ModbusFloat;
import com.vk.servicebalon.modbus.ModbusShort;
import com.vk.servicebalon.modbus.entity.ModbusMasterSerialModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
@ComponentScan(basePackages = {"com.vk.servicebalon.device","com.vk.servicebalon.modbus"})
public class RepositoryModbusTRM138Impl implements RepositoryModbusTRM138{

    private final ModbusMasterSerialModel modbusMasterSerialFirst;

    private final DeviceModelTRM138 deviceModelTRM138;

    private final BatchRead<Integer> batchRead;

    private final ModbusFloat modbusFloat;

    private final ModbusShort modbusShort;

    @Autowired
    public RepositoryModbusTRM138Impl(final ModbusMasterSerialModel modbusMasterSerialFirst,
                                      final DeviceModelTRM138 deviceModelTRM138,
                                      final BatchRead<Integer> batchRead,
                                      final ModbusFloat modbusFloat,
                                      final ModbusShort modbusShort) {
        this.modbusMasterSerialFirst = modbusMasterSerialFirst;
        this.deviceModelTRM138 = deviceModelTRM138;
        this.batchRead = batchRead;
        this.modbusFloat = modbusFloat;
        this.modbusShort = modbusShort;
    }

    @Override
    public DeviceModelTRM138 readDataFromRegisterAll(final boolean useBorders,
                                                     final short borderMin,
                                                     final short borderMax,
                                                     final float digsFloat,
                                                     final boolean enableBatch) {
        if (Objects.nonNull(modbusFloat)){
            modbusFloat.setUseBorders(useBorders, borderMax, borderMin);
            final List<Float> listFloat =  modbusFloat.readDataFromModBusDigs(
                    digsFloat,
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    batchRead,
                    enableBatch,
                    deviceModelTRM138.getModbusLocator0i(),
                    deviceModelTRM138.getModbusLocator1i(),
                    deviceModelTRM138.getModbusLocator2i(),
                    deviceModelTRM138.getModbusLocator3i(),
                    deviceModelTRM138.getModbusLocator4i(),
                    deviceModelTRM138.getModbusLocator5i(),
                    deviceModelTRM138.getModbusLocator6i(),
                    deviceModelTRM138.getModbusLocator7i());
            deviceModelTRM138.setInputRegister0(listFloat.get(0));
            deviceModelTRM138.setInputRegister1(listFloat.get(1));
            deviceModelTRM138.setInputRegister2(listFloat.get(2));
            deviceModelTRM138.setInputRegister3(listFloat.get(3));
            deviceModelTRM138.setInputRegister4(listFloat.get(4));
            deviceModelTRM138.setInputRegister5(listFloat.get(5));
            deviceModelTRM138.setInputRegister6(listFloat.get(6));
            deviceModelTRM138.setInputRegister7(listFloat.get(7));
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 readDataFromRegister0(final boolean useBorders,
                                                   final short borderMin,
                                                   final short borderMax,
                                                   final float digsFloat,
                                                   final boolean enableBatch) {
        if (Objects.nonNull(modbusFloat)){
            modbusFloat.setUseBorders(useBorders, borderMax, borderMin);
            final List<Float> listFloat =  modbusFloat.readDataFromModBusDigs(
                    digsFloat,
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    batchRead,
                    enableBatch,
                    deviceModelTRM138.getModbusLocator0i());
            deviceModelTRM138.setInputRegister0(listFloat.get(0));
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 readDataFromRegister1(final boolean useBorders,
                                                   final short borderMin,
                                                   final short borderMax,
                                                   final float digsFloat,
                                                   final boolean enableBatch) {
        if (Objects.nonNull(modbusFloat)){
            modbusFloat.setUseBorders(useBorders, borderMax, borderMin);
            final List<Float> listFloat =  modbusFloat.readDataFromModBusDigs(
                    digsFloat,
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    batchRead,
                    enableBatch,
                    deviceModelTRM138.getModbusLocator1i());
            deviceModelTRM138.setInputRegister1(listFloat.get(1));
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 readDataFromRegister2(final boolean useBorders,
                                                   final short borderMin,
                                                   final short borderMax,
                                                   final float digsFloat,
                                                   final boolean enableBatch) {
        if (Objects.nonNull(modbusFloat)){
            modbusFloat.setUseBorders(useBorders, borderMax, borderMin);
            final List<Float> listFloat =  modbusFloat.readDataFromModBusDigs(
                    digsFloat,
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    batchRead,
                    enableBatch,
                    deviceModelTRM138.getModbusLocator2i());
            deviceModelTRM138.setInputRegister2(listFloat.get(2));
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 readDataFromRegister3(final boolean useBorders,
                                                   final short borderMin,
                                                   final short borderMax,
                                                   final float digsFloat,
                                                   final boolean enableBatch) {
        if (Objects.nonNull(modbusFloat)){
            modbusFloat.setUseBorders(useBorders, borderMax, borderMin);
            final List<Float> listFloat =  modbusFloat.readDataFromModBusDigs(
                    digsFloat,
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    batchRead,
                    enableBatch,
                    deviceModelTRM138.getModbusLocator3i());
            deviceModelTRM138.setInputRegister3(listFloat.get(3));
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 readDataFromRegister4(final boolean useBorders,
                                                   final short borderMin,
                                                   final short borderMax,
                                                   final float digsFloat,
                                                   final boolean enableBatch) {
        if (Objects.nonNull(modbusFloat)){
            modbusFloat.setUseBorders(useBorders, borderMax, borderMin);
            final List<Float> listFloat =  modbusFloat.readDataFromModBusDigs(
                    digsFloat,
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    batchRead,
                    enableBatch,
                    deviceModelTRM138.getModbusLocator4i());
            deviceModelTRM138.setInputRegister4(listFloat.get(4));
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 readDataFromRegister5(final boolean useBorders,
                                                   final short borderMin,
                                                   final short borderMax,
                                                   final float digsFloat,
                                                   final boolean enableBatch) {
        if (Objects.nonNull(modbusFloat)){
            modbusFloat.setUseBorders(useBorders, borderMax, borderMin);
            final List<Float> listFloat =  modbusFloat.readDataFromModBusDigs(
                    digsFloat,
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    batchRead,
                    enableBatch,
                    deviceModelTRM138.getModbusLocator5i());
            deviceModelTRM138.setInputRegister5(listFloat.get(5));
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 readDataFromRegister6(final boolean useBorders,
                                                   final short borderMin,
                                                   final short borderMax,
                                                   final float digsFloat,
                                                   final boolean enableBatch) {
        if (Objects.nonNull(modbusFloat)){
            modbusFloat.setUseBorders(useBorders, borderMax, borderMin);
            final List<Float> listFloat =  modbusFloat.readDataFromModBusDigs(
                    digsFloat,
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    batchRead,
                    enableBatch,
                    deviceModelTRM138.getModbusLocator6i());
            deviceModelTRM138.setInputRegister6(listFloat.get(6));
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 readDataFromRegister7(final boolean useBorders,
                                                   final short borderMin,
                                                   final short borderMax,
                                                   final float digsFloat,
                                                   final boolean enableBatch) {
        if (Objects.nonNull(modbusFloat)){
            modbusFloat.setUseBorders(useBorders, borderMax, borderMin);
            final List<Float> listFloat =  modbusFloat.readDataFromModBusDigs(
                    digsFloat,
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    batchRead,
                    enableBatch,
                    deviceModelTRM138.getModbusLocator7i());
            deviceModelTRM138.setInputRegister7(listFloat.get(7));
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 writeDataToRegister0(final short value) {
        if (Objects.nonNull(modbusShort)){
            modbusShort.writeDataToModBus(
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    value,
                    deviceModelTRM138.getModbusLocator0h());
            deviceModelTRM138.setHoldingRegister0(value);
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 writeDataToRegister1(final short value) {
        if (Objects.nonNull(modbusShort)){
            modbusShort.writeDataToModBus(
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    value,
                    deviceModelTRM138.getModbusLocator1h());
            deviceModelTRM138.setHoldingRegister1(value);
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 writeDataToRegister2(final short value) {
        if (Objects.nonNull(modbusShort)){
            modbusShort.writeDataToModBus(
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    value,
                    deviceModelTRM138.getModbusLocator2h());
            deviceModelTRM138.setHoldingRegister2(value);
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 writeDataToRegister3(final short value) {
        if (Objects.nonNull(modbusShort)){
            modbusShort.writeDataToModBus(
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    value,
                    deviceModelTRM138.getModbusLocator3h());
            deviceModelTRM138.setHoldingRegister3(value);
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 writeDataToRegister4(final short value) {
        if (Objects.nonNull(modbusShort)){
            modbusShort.writeDataToModBus(
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    value,
                    deviceModelTRM138.getModbusLocator4h());
            deviceModelTRM138.setHoldingRegister4(value);
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 writeDataToRegister5(final short value) {
        if (Objects.nonNull(modbusShort)){
            modbusShort.writeDataToModBus(
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    value,
                    deviceModelTRM138.getModbusLocator5h());
            deviceModelTRM138.setHoldingRegister5(value);
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 writeDataToRegister6(final short value) {
        if (Objects.nonNull(modbusShort)){
            modbusShort.writeDataToModBus(
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    value,
                    deviceModelTRM138.getModbusLocator6h());
            deviceModelTRM138.setHoldingRegister6(value);
        }
        return deviceModelTRM138;
    }

    @Override
    public DeviceModelTRM138 writeDataToRegister7(final short value) {
        if (Objects.nonNull(modbusShort)){
            modbusShort.writeDataToModBus(
                    modbusMasterSerialFirst,
                    deviceModelTRM138.getDeviceAddress(),
                    value,
                    deviceModelTRM138.getModbusLocator7h());
            deviceModelTRM138.setHoldingRegister7(value);
        }
        return deviceModelTRM138;
    }
}
