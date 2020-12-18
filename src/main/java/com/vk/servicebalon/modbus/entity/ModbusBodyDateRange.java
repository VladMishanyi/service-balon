package com.vk.servicebalon.modbus.entity;

import java.time.LocalDateTime;
import java.util.Date;

public class ModbusBodyDateRange {

    private LocalDateTime from;

    private LocalDateTime to;

    public ModbusBodyDateRange() {
    }

    public ModbusBodyDateRange(LocalDateTime from, LocalDateTime to) {
        this.from = from;
        this.to = to;
    }

    public LocalDateTime getFrom() {
        return from;
    }

    public void setFrom(LocalDateTime from) {
        this.from = from;
    }

    public LocalDateTime getTo() {
        return to;
    }

    public void setTo(LocalDateTime to) {
        this.to = to;
    }
}
