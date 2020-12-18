package com.vk.servicebalon.json;

import com.vk.servicebalon.table.TableModelTRM202;

import java.util.List;

public class JsonBodyListForTableModelTRM202 {

    private List<TableModelTRM202> tableModelTRM202List;

    public JsonBodyListForTableModelTRM202() {
    }

    public JsonBodyListForTableModelTRM202(List<TableModelTRM202> tableModelTRM202List) {
        this.tableModelTRM202List = tableModelTRM202List;
    }

    public List<TableModelTRM202> getTableModelTRM202List() {
        return tableModelTRM202List;
    }

    public void setTableModelTRM202List(List<TableModelTRM202> tableModelTRM202List) {
        this.tableModelTRM202List = tableModelTRM202List;
    }
}
