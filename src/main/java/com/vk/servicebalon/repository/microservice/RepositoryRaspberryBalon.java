package com.vk.servicebalon.repository.microservice;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.json.JsonBodyListForTableModelTRM202;
import com.vk.servicebalon.table.TableModelTRM202;

import java.time.LocalDateTime;

public interface RepositoryRaspberryBalon {

    JsonBodyListForTableModelTRM202 readJsonTableModelTRM202BetweenDate(LocalDateTime start, LocalDateTime end);

    TableModelTRM202 readJsonTableModelTRM202Last();

    DeviceModelTRM202 readJsonDeviceModelTRM202allRegisters();
}
