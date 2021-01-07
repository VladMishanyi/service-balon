package com.vk.servicebalon.table;

import org.apache.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * Created by User on 2018-02-27.
 */
@MappedSuperclass
public abstract class TableModel implements Serializable, Cloneable{

    private static final long serialVersionUID = 1L;

    private static final Logger LOGGER = Logger.getLogger(TableModel.class);

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private long id;

    @Column(name = "date", columnDefinition = "TIMESTAMP")
    private LocalDateTime date;

    public TableModel(){}

    public TableModel(long id, LocalDateTime date){
        this.id = id;
        this.date = date;
    }

    @Override
    public String toString() {
        return "TableModel{" +
                "id=" + id +
                ", date=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TableModel that = (TableModel) o;
        return id == that.id &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date);
    }

    @Override
    public TableModel clone(){
        TableModel tableModel = null;
        try {
            tableModel = (TableModel) super.clone();
        }catch (CloneNotSupportedException e){
            LOGGER.error(e.getMessage(), e);
        }
        return tableModel;
    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(final LocalDateTime date) {
        this.date = date;
    }
}