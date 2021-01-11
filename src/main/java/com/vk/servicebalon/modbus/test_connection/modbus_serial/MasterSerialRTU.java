package com.vk.servicebalon.modbus.test_connection.modbus_serial;

import com.serotonin.modbus4j.*;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.code.RegisterRange;
import com.vk.servicebalon.device.DeviceModelTRM138;
import com.vk.servicebalon.modbus.*;
import com.vk.servicebalon.modbus.en.DigsFloat;
import com.vk.servicebalon.modbus.entity.ModbusMasterSerialModel;

import java.util.List;

/**
 * Created by User on 2017-05-15.
 */

public class MasterSerialRTU {

    public static void main(String[] args) throws Exception {
        long startTime = 0;
        final ModbusMasterSerialModel modbusMasterSerialModel3 = new ModbusMasterSerialModel("COM26", 9600, 8, 1, 0, 200, 1);


        final ModbusInteger modbusInteger = new ModbusIntegerImpl();
        modbusInteger.setUseBorders(false);
        final ModbusFloat modbusFloat = new ModbusFloatImpl();
        modbusFloat.setUseBorders(false);

        final DeviceModelTRM138 deviceModelTRM138 = new DeviceModelTRM138();

        int i = 0;
        while (true){
            System.out.println("----"+i);
            startTime = System.currentTimeMillis();
            BatchRead<Integer> batchRead = new BatchRead<>();
            List<Float> valFloat = modbusFloat.readDataFromModBusDigs(
                    DigsFloat.ONE_DIG,
                    modbusMasterSerialModel3,
                    deviceModelTRM138.getDeviceAddress(),
                    batchRead,
                    false,
                    deviceModelTRM138.getModbusLocator0i(),
                    deviceModelTRM138.getModbusLocator1i(),
                    deviceModelTRM138.getModbusLocator2i(),
                    deviceModelTRM138.getModbusLocator3i(),
                    deviceModelTRM138.getModbusLocator4i(),
                    deviceModelTRM138.getModbusLocator5i(),
                    deviceModelTRM138.getModbusLocator6i(),
                    deviceModelTRM138.getModbusLocator7i());

            modbusInteger.writeDataToModBus(modbusMasterSerialModel3,
                    deviceModelTRM138.getDeviceAddress(),
                    101,
                    deviceModelTRM138.getModbusLocator0h());

            modbusInteger.writeDataToModBus(modbusMasterSerialModel3,
                    deviceModelTRM138.getDeviceAddress(),
                    201,
                    deviceModelTRM138.getModbusLocator1h());

            modbusInteger.writeDataToModBus(modbusMasterSerialModel3,
                    deviceModelTRM138.getDeviceAddress(),
                    301,
                    deviceModelTRM138.getModbusLocator2h());

            modbusInteger.writeDataToModBus(modbusMasterSerialModel3,
                    deviceModelTRM138.getDeviceAddress(),
                    401,
                    deviceModelTRM138.getModbusLocator3h());

            modbusInteger.writeDataToModBus(modbusMasterSerialModel3,
                    deviceModelTRM138.getDeviceAddress(),
                    501,
                    deviceModelTRM138.getModbusLocator4h());

            modbusInteger.writeDataToModBus(modbusMasterSerialModel3,
                    deviceModelTRM138.getDeviceAddress(),
                    601,
                    deviceModelTRM138.getModbusLocator5h());

            modbusInteger.writeDataToModBus(modbusMasterSerialModel3,
                    deviceModelTRM138.getDeviceAddress(),
                    701,
                    deviceModelTRM138.getModbusLocator6h());

            modbusInteger.writeDataToModBus(modbusMasterSerialModel3,
                    deviceModelTRM138.getDeviceAddress(),
                    801,
                    deviceModelTRM138.getModbusLocator7h());

            System.out.println("Time elapsed: " + (System.currentTimeMillis() - startTime) + "ms");
            valFloat.forEach(System.out::println);
            System.out.println("----------------------------------------------------------------------------------------");
            Thread.sleep(1000);
            i++;
        }
    }
}
