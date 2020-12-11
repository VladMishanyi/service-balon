package com.vk.servicebalon.repository.modbus;

import com.vk.servicebalon.device.DeviceModelTRM202;

public interface RepositoryModbusTRM202 {
    DeviceModelTRM202 readDataFromRegisterAll(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch);

    DeviceModelTRM202 readDataFromRegister0(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch);
    DeviceModelTRM202 readDataFromRegister1(
            final boolean useBorders,
            final short borderMin,
            final short borderMax,
            final float digsFloat,
            final boolean enableBatch);

    DeviceModelTRM202 writeDataToRegister0(final float value);
    DeviceModelTRM202 writeDataToRegister1(final float value);
}
