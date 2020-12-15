package com.vk.servicebalon.modbus.entity;

import java.util.Date;

public class ModbusBodyDateRange {

    private Date from;

    private Date to;

    public ModbusBodyDateRange() {
    }

    public ModbusBodyDateRange(Date from, Date to) {
        this.from = from;
        this.to = to;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
