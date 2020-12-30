package com.vk.servicebalon.repository.modbus;

import com.vk.servicebalon.device.DeviceModelTRM138;

public interface RepositoryModbusTRM138 {
    DeviceModelTRM138 readDataFromRegisterAll(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch);

    DeviceModelTRM138 readDataFromRegister0(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch);
    DeviceModelTRM138 readDataFromRegister1(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch);
    DeviceModelTRM138 readDataFromRegister2(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch);
    DeviceModelTRM138 readDataFromRegister3(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch);
    DeviceModelTRM138 readDataFromRegister4(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch);
    DeviceModelTRM138 readDataFromRegister5(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch);
    DeviceModelTRM138 readDataFromRegister6(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch);
    DeviceModelTRM138 readDataFromRegister7(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch);

    DeviceModelTRM138 writeDataToRegister0(final short value);
    DeviceModelTRM138 writeDataToRegister1(final short value);
    DeviceModelTRM138 writeDataToRegister2(final short value);
    DeviceModelTRM138 writeDataToRegister3(final short value);
    DeviceModelTRM138 writeDataToRegister4(final short value);
    DeviceModelTRM138 writeDataToRegister5(final short value);
    DeviceModelTRM138 writeDataToRegister6(final short value);
    DeviceModelTRM138 writeDataToRegister7(final short value);
}
