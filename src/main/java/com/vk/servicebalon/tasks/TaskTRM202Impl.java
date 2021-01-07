package com.vk.servicebalon.tasks;

import com.vk.servicebalon.device.DeviceModelTRM202;
import com.vk.servicebalon.device_to_table.DeviceToTableTRM202;
import com.vk.servicebalon.json.JsonBodyListForTableModelTRM202;
import com.vk.servicebalon.service.ServiceTRM202;
import com.vk.servicebalon.table.TableModelTRM202;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;

@Component
@ComponentScan(basePackages = {"com.vk.servicebalon.service", "com.vk.servicebalon.device"})
public class TaskTRM202Impl implements TaskTRM202{

    private final ServiceTRM202 serviceTRM202;

    private final DeviceModelTRM202 deviceModelTRM202;

    private final DeviceToTableTRM202 deviceToTableTRM202;

    @Autowired
    public TaskTRM202Impl(final ServiceTRM202 serviceTRM202, final DeviceModelTRM202 deviceModelTRM202, final DeviceToTableTRM202 deviceToTableTRM202){
        this.serviceTRM202 = serviceTRM202;
        this.deviceModelTRM202 = deviceModelTRM202;
        this.deviceToTableTRM202 = deviceToTableTRM202;
    }

    @Override
    public ServiceTRM202 getServiceTRM202() {
        return serviceTRM202;
    }

    @Override
    public DeviceModelTRM202 getDeviceModelTRM202() {
        return deviceModelTRM202;
    }

    @Override
    public DeviceToTableTRM202 getDeviceToTableTRM202() {
        return deviceToTableTRM202;
    }

    @Override
    public void readModbusAndWriteToTable() {
        serviceTRM202.readDataFromRegisterAll();
        if (deviceModelTRM202.hysteresis()){
            TableModelTRM202 tableModelTRM202 = deviceToTableTRM202.convert();
            serviceTRM202.addTableDevice(tableModelTRM202);
        }
    }

    @Override
    public void syncDatabase(){
        OffsetDateTime dateTimeCurrent = startOffsetLocalDateTime();
        OffsetDateTime dateTimeEnd = endOffsetLocalDateTime();
        OffsetDateTime current = dateTimeCurrent;
        while (current.isBefore(dateTimeEnd)) {
            OffsetDateTime next = current.plusHours(1);
            serviceTRM202.addAllTableDevice(readTableModelBetweenDate(current.toLocalDateTime(), next.toLocalDateTime()));
            current = next;
        }
    }

    private LocalDateTime readStartEndpoinDate(){
        LocalDateTime localDateTime = LocalDateTime.now().minusYears(1L);
        TableModelTRM202 tableModelTRM202 = serviceTRM202.findLastValueByDate();
        if (Objects.isNull(tableModelTRM202)) return localDateTime;
        return tableModelTRM202.getDate();
    }

    private LocalDateTime readEndEndpoinDate(){
        TableModelTRM202 tableModelTRM202 = serviceTRM202.readJsonTableModelTRM202Last();
        return tableModelTRM202.getDate();
    }

    private List<TableModelTRM202> readTableModelBetweenDate(LocalDateTime readStartEndpoinDate, LocalDateTime readEndEndpoinDate){
        JsonBodyListForTableModelTRM202 jsonBodyListForTableModelTRM202 = serviceTRM202.readJsonTableModelTRM202BetweenDate(readStartEndpoinDate, readEndEndpoinDate);
        return jsonBodyListForTableModelTRM202.getTableModelList();
    }

    private OffsetDateTime localDateTomeToOffset(LocalDateTime localDateTime){
        return OffsetDateTime.of(localDateTime, OffsetDateTime.now().getOffset());
    }

    private OffsetDateTime startOffsetLocalDateTime(){
        return localDateTomeToOffset(readStartEndpoinDate());
    }

    private OffsetDateTime endOffsetLocalDateTime(){
        return localDateTomeToOffset(readEndEndpoinDate());
    }
}
