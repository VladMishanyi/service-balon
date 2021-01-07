package com.vk.servicebalon.table;

import com.serotonin.modbus4j.ModbusLocator;
import com.serotonin.modbus4j.code.DataType;
import com.serotonin.modbus4j.code.RegisterRange;
import com.vk.servicebalon.lib.HysComparator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "trm202")
public class TableModelTRM202 extends TableModel {

    private static final long serialVersionUID = 1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Column(name = "id")
//    private long id;
//
//    @Column(name = "date", columnDefinition = "TIMESTAMP")
//    private LocalDateTime date;

    @Column(name = "holdingRegister0")
    private float holdingRegister0 = 0F;

    @Column(name = "holdingRegister1")
    private float holdingRegister1 = 0F;

    public TableModelTRM202(){}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public LocalDateTime getDate() {
//        return date;
//    }
//
//    public void setDate(LocalDateTime date) {
//        this.date = date;
//    }

    public float getHoldingRegister0() {
        return holdingRegister0;
    }

    public void setHoldingRegister0(float holdingRegister0) {
        this.holdingRegister0 = holdingRegister0;
    }

    public float getHoldingRegister1() {
        return holdingRegister1;
    }

    public void setHoldingRegister1(float holdingRegister1) {
        this.holdingRegister1 = holdingRegister1;
    }

    @Override
    public boolean equals(Object object) {
        boolean result = super.equals(object);
        if (result){
            TableModelTRM202 that = (TableModelTRM202) object;
            result = Float.compare(that.holdingRegister0, holdingRegister0) == 0 &&
                    Float.compare(that.holdingRegister1, holdingRegister1) == 0;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.getId(), this.getDate(), holdingRegister0, holdingRegister1);
    }

    @Override
    public String toString() {
        return "TableModelTRM202{" +
                super.toString()+
                ", holdingRegister0=" + holdingRegister0 +
                ", holdingRegister1=" + holdingRegister1 +
                '}';
    }

    @Override
    public TableModelTRM202 clone() {
        return (TableModelTRM202) super.clone();
    }
}
