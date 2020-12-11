package com.vk.servicebalon.modbus;

import com.serotonin.modbus4j.BatchRead;
import com.serotonin.modbus4j.ModbusLocator;
import com.vk.servicebalon.modbus.entity.ModbusMasterSerialModel;
import com.vk.servicebalon.modbus.entity.ModbusMasterTcpModel;

import java.util.List;

/**
 * Created by KIP-PC99 on 14.09.2018.
 */
public interface ModbusFloat extends RootModbus<Float> {

    List<Float> readDataFromModBusDigs(
            final Float pow,
            final ModbusMasterSerialModel modbusMasterSerialModel,
            final int adr,
            final BatchRead<Integer> batch,
            final boolean enableBatch,
            final ModbusLocator... modbusLocator);

    List<Float> readDataFromModBusDigs(
            final Float pow,
            final ModbusMasterTcpModel modbusMasterTcpModel,
            final int adr,
            final BatchRead<Integer> batch,
            final boolean enableBatch,
            final ModbusLocator... modbusLocator);
}
