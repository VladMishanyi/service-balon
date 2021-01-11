package com.vk.servicebalon.device;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.serotonin.modbus4j.ModbusLocator;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.code.RegisterRange;
import com.vk.servicebalon.lib.HysComparator;
import org.springframework.stereotype.Component;

/**
 * Created by KIP-PC99 on 20.09.2018.
 */
@Component
public class DeviceModelTRM138{

    @JsonIgnore
    private transient final int deviceAddress = 16;//16-24 reserved for this device
    @JsonIgnore
    private transient final float hysteresisFloat = 1.0F;
    @JsonIgnore
    private transient final int hysteresisInt = 1;

    private float inputRegister0 = 0F;
    @JsonIgnore
    private transient float oldInputRegister0 = 0F;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator0i = new ModbusLocator(deviceAddress, RegisterRange.INPUT_REGISTER, 3, DataType.FOUR_BYTE_FLOAT);

    private float inputRegister1 = 0F;
    @JsonIgnore
    private transient float oldInputRegister1 = 0F;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator1i = new ModbusLocator(deviceAddress, RegisterRange.INPUT_REGISTER, 8, DataType.FOUR_BYTE_FLOAT);

    private float inputRegister2 = 0F;
    @JsonIgnore
    private transient float oldInputRegister2 = 0F;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator2i = new ModbusLocator(deviceAddress, RegisterRange.INPUT_REGISTER, 13, DataType.FOUR_BYTE_FLOAT);

    private float inputRegister3 = 0F;
    @JsonIgnore
    private transient float oldInputRegister3 = 0F;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator3i = new ModbusLocator(deviceAddress, RegisterRange.INPUT_REGISTER, 18, DataType.FOUR_BYTE_FLOAT);

    private float inputRegister4 = 0F;
    @JsonIgnore
    private transient float oldInputRegister4 = 0F;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator4i = new ModbusLocator(deviceAddress, RegisterRange.INPUT_REGISTER, 23, DataType.FOUR_BYTE_FLOAT);

    private float inputRegister5 = 0F;
    @JsonIgnore
    private transient float oldInputRegister5 = 0F;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator5i = new ModbusLocator(deviceAddress, RegisterRange.INPUT_REGISTER, 28, DataType.FOUR_BYTE_FLOAT);

    private float inputRegister6 = 0F;
    @JsonIgnore
    private transient float oldInputRegister6 = 0F;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator6i = new ModbusLocator(deviceAddress, RegisterRange.INPUT_REGISTER, 33, DataType.FOUR_BYTE_FLOAT);

    private float inputRegister7 = 0F;
    @JsonIgnore
    private transient float oldInputRegister7 = 0F;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator7i = new ModbusLocator(deviceAddress, RegisterRange.INPUT_REGISTER, 38, DataType.FOUR_BYTE_FLOAT);

    private int holdingRegister0 = 0;
    @JsonIgnore
    private transient int oldHoldingRegister0 = 0;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator0h = new ModbusLocator(deviceAddress, RegisterRange.HOLDING_REGISTER, 17, DataType.TWO_BYTE_INT_SIGNED);

    private int holdingRegister1 = 0;
    @JsonIgnore
    private transient int oldHoldingRegister1 = 0;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator1h = new ModbusLocator(deviceAddress, RegisterRange.HOLDING_REGISTER, 21, DataType.TWO_BYTE_INT_SIGNED);

    private int holdingRegister2 = 0;
    @JsonIgnore
    private transient int oldHoldingRegister2 = 0;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator2h = new ModbusLocator(deviceAddress, RegisterRange.HOLDING_REGISTER, 25, DataType.TWO_BYTE_INT_SIGNED);

    private int holdingRegister3 = 0;
    @JsonIgnore
    private transient int oldHoldingRegister3 = 0;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator3h = new ModbusLocator(deviceAddress, RegisterRange.HOLDING_REGISTER, 29, DataType.TWO_BYTE_INT_SIGNED);

    private int holdingRegister4 = 0;
    @JsonIgnore
    private transient int oldHoldingRegister4 = 0;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator4h = new ModbusLocator(deviceAddress, RegisterRange.HOLDING_REGISTER, 33, DataType.TWO_BYTE_INT_SIGNED);

    private int holdingRegister5 = 0;
    @JsonIgnore
    private transient int oldHoldingRegister5 = 0;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator5h = new ModbusLocator(deviceAddress, RegisterRange.HOLDING_REGISTER, 37, DataType.TWO_BYTE_INT_SIGNED);

    private int holdingRegister6 = 0;
    @JsonIgnore
    private transient int oldHoldingRegister6 = 0;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator6h = new ModbusLocator(deviceAddress, RegisterRange.HOLDING_REGISTER, 41, DataType.TWO_BYTE_INT_SIGNED);

    private int holdingRegister7 = 0;
    @JsonIgnore
    private transient int oldHoldingRegister7 = 0;
    @JsonIgnore
    private transient final ModbusLocator modbusLocator7h = new ModbusLocator(deviceAddress, RegisterRange.HOLDING_REGISTER, 45, DataType.TWO_BYTE_INT_SIGNED);

    public DeviceModelTRM138(){}

    public int getDeviceAddress() {
        return deviceAddress;
    }

    public float getHysteresisFloat() {
        return hysteresisFloat;
    }

    public int getHysteresisInt() {
        return hysteresisInt;
    }

    public float getInputRegister0() {
        return inputRegister0;
    }

    public void setInputRegister0(float inputRegister0) {
        this.inputRegister0 = inputRegister0;
    }

    public float getOldInputRegister0() {
        return oldInputRegister0;
    }

    public void setOldInputRegister0(float oldInputRegister0) {
        this.oldInputRegister0 = oldInputRegister0;
    }

    public ModbusLocator getModbusLocator0i() {
        return modbusLocator0i;
    }

    public float getInputRegister1() {
        return inputRegister1;
    }

    public void setInputRegister1(float inputRegister1) {
        this.inputRegister1 = inputRegister1;
    }

    public float getOldInputRegister1() {
        return oldInputRegister1;
    }

    public void setOldInputRegister1(float oldInputRegister1) {
        this.oldInputRegister1 = oldInputRegister1;
    }

    public ModbusLocator getModbusLocator1i() {
        return modbusLocator1i;
    }

    public float getInputRegister2() {
        return inputRegister2;
    }

    public void setInputRegister2(float inputRegister2) {
        this.inputRegister2 = inputRegister2;
    }

    public float getOldInputRegister2() {
        return oldInputRegister2;
    }

    public void setOldInputRegister2(float oldInputRegister2) {
        this.oldInputRegister2 = oldInputRegister2;
    }

    public ModbusLocator getModbusLocator2i() {
        return modbusLocator2i;
    }

    public float getInputRegister3() {
        return inputRegister3;
    }

    public void setInputRegister3(float inputRegister3) {
        this.inputRegister3 = inputRegister3;
    }

    public float getOldInputRegister3() {
        return oldInputRegister3;
    }

    public void setOldInputRegister3(float oldInputRegister3) {
        this.oldInputRegister3 = oldInputRegister3;
    }

    public ModbusLocator getModbusLocator3i() {
        return modbusLocator3i;
    }

    public float getInputRegister4() {
        return inputRegister4;
    }

    public void setInputRegister4(float inputRegister4) {
        this.inputRegister4 = inputRegister4;
    }

    public float getOldInputRegister4() {
        return oldInputRegister4;
    }

    public void setOldInputRegister4(float oldInputRegister4) {
        this.oldInputRegister4 = oldInputRegister4;
    }

    public ModbusLocator getModbusLocator4i() {
        return modbusLocator4i;
    }

    public float getInputRegister5() {
        return inputRegister5;
    }

    public void setInputRegister5(float inputRegister5) {
        this.inputRegister5 = inputRegister5;
    }

    public float getOldInputRegister5() {
        return oldInputRegister5;
    }

    public void setOldInputRegister5(float oldInputRegister5) {
        this.oldInputRegister5 = oldInputRegister5;
    }

    public ModbusLocator getModbusLocator5i() {
        return modbusLocator5i;
    }

    public float getInputRegister6() {
        return inputRegister6;
    }

    public void setInputRegister6(float inputRegister6) {
        this.inputRegister6 = inputRegister6;
    }

    public float getOldInputRegister6() {
        return oldInputRegister6;
    }

    public void setOldInputRegister6(float oldInputRegister6) {
        this.oldInputRegister6 = oldInputRegister6;
    }

    public ModbusLocator getModbusLocator6i() {
        return modbusLocator6i;
    }

    public float getInputRegister7() {
        return inputRegister7;
    }

    public void setInputRegister7(float inputRegister7) {
        this.inputRegister7 = inputRegister7;
    }

    public float getOldInputRegister7() {
        return oldInputRegister7;
    }

    public void setOldInputRegister7(float oldInputRegister7) {
        this.oldInputRegister7 = oldInputRegister7;
    }

    public ModbusLocator getModbusLocator7i() {
        return modbusLocator7i;
    }

    public int getHoldingRegister0() {
        return holdingRegister0;
    }

    public void setHoldingRegister0(int holdingRegister0) {
        this.holdingRegister0 = holdingRegister0;
    }

    public int getOldHoldingRegister0() {
        return oldHoldingRegister0;
    }

    public void setOldHoldingRegister0(int oldHoldingRegister0) {
        this.oldHoldingRegister0 = oldHoldingRegister0;
    }

    public ModbusLocator getModbusLocator0h() {
        return modbusLocator0h;
    }

    public int getHoldingRegister1() {
        return holdingRegister1;
    }

    public void setHoldingRegister1(int holdingRegister1) {
        this.holdingRegister1 = holdingRegister1;
    }

    public int getOldHoldingRegister1() {
        return oldHoldingRegister1;
    }

    public void setOldHoldingRegister1(int oldHoldingRegister1) {
        this.oldHoldingRegister1 = oldHoldingRegister1;
    }

    public ModbusLocator getModbusLocator1h() {
        return modbusLocator1h;
    }

    public int getHoldingRegister2() {
        return holdingRegister2;
    }

    public void setHoldingRegister2(int holdingRegister2) {
        this.holdingRegister2 = holdingRegister2;
    }

    public int getOldHoldingRegister2() {
        return oldHoldingRegister2;
    }

    public void setOldHoldingRegister2(int oldHoldingRegister2) {
        this.oldHoldingRegister2 = oldHoldingRegister2;
    }

    public ModbusLocator getModbusLocator2h() {
        return modbusLocator2h;
    }

    public int getHoldingRegister3() {
        return holdingRegister3;
    }

    public void setHoldingRegister3(int holdingRegister3) {
        this.holdingRegister3 = holdingRegister3;
    }

    public int getOldHoldingRegister3() {
        return oldHoldingRegister3;
    }

    public void setOldHoldingRegister3(int oldHoldingRegister3) {
        this.oldHoldingRegister3 = oldHoldingRegister3;
    }

    public ModbusLocator getModbusLocator3h() {
        return modbusLocator3h;
    }

    public int getHoldingRegister4() {
        return holdingRegister4;
    }

    public void setHoldingRegister4(int holdingRegister4) {
        this.holdingRegister4 = holdingRegister4;
    }

    public int getOldHoldingRegister4() {
        return oldHoldingRegister4;
    }

    public void setOldHoldingRegister4(int oldHoldingRegister4) {
        this.oldHoldingRegister4 = oldHoldingRegister4;
    }

    public ModbusLocator getModbusLocator4h() {
        return modbusLocator4h;
    }

    public int getHoldingRegister5() {
        return holdingRegister5;
    }

    public void setHoldingRegister5(int holdingRegister5) {
        this.holdingRegister5 = holdingRegister5;
    }

    public int getOldHoldingRegister5() {
        return oldHoldingRegister5;
    }

    public void setOldHoldingRegister5(int oldHoldingRegister5) {
        this.oldHoldingRegister5 = oldHoldingRegister5;
    }

    public ModbusLocator getModbusLocator5h() {
        return modbusLocator5h;
    }

    public int getHoldingRegister6() {
        return holdingRegister6;
    }

    public void setHoldingRegister6(int holdingRegister6) {
        this.holdingRegister6 = holdingRegister6;
    }

    public int getOldHoldingRegister6() {
        return oldHoldingRegister6;
    }

    public void setOldHoldingRegister6(int oldHoldingRegister6) {
        this.oldHoldingRegister6 = oldHoldingRegister6;
    }

    public ModbusLocator getModbusLocator6h() {
        return modbusLocator6h;
    }

    public int getHoldingRegister7() {
        return holdingRegister7;
    }

    public void setHoldingRegister7(int holdingRegister7) {
        this.holdingRegister7 = holdingRegister7;
    }

    public int getOldHoldingRegister7() {
        return oldHoldingRegister7;
    }

    public void setOldHoldingRegister7(int oldHoldingRegister7) {
        this.oldHoldingRegister7 = oldHoldingRegister7;
    }

    public ModbusLocator getModbusLocator7h() {
        return modbusLocator7h;
    }

    public boolean hysteresis(){
        boolean inner = HysComparator.compare(oldInputRegister0,
                inputRegister0,
                hysteresisFloat);
        inner |= HysComparator.compare(oldInputRegister1,
                inputRegister1,
                hysteresisFloat);
        inner |= HysComparator.compare(oldInputRegister2,
                inputRegister2,
                hysteresisFloat);
        inner |= HysComparator.compare(oldInputRegister3,
                inputRegister3,
                hysteresisFloat);
        inner |= HysComparator.compare(oldInputRegister4,
                inputRegister4,
                hysteresisFloat);
        inner |= HysComparator.compare(oldInputRegister5,
                inputRegister5,
                hysteresisFloat);
        inner |= HysComparator.compare(oldInputRegister6,
                inputRegister6,
                hysteresisFloat);
        inner |= HysComparator.compare(oldInputRegister7,
                inputRegister7,
                hysteresisFloat);
        if (inner){
            oldInputRegister0 = inputRegister0;
            oldInputRegister1 = inputRegister1;
            oldInputRegister2 = inputRegister2;
            oldInputRegister3 = inputRegister3;
            oldInputRegister4 = inputRegister4;
            oldInputRegister5 = inputRegister5;
            oldInputRegister6 = inputRegister6;
            oldInputRegister7 = inputRegister7;
        }
        return inner;
    }
}
