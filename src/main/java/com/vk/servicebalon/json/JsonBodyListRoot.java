package com.vk.servicebalon.json;

import com.vk.servicebalon.table.TableModel;

import java.util.List;

public class JsonBodyListRoot<E extends TableModel> {

    private List<E> tableModelList;

    public JsonBodyListRoot() {
    }

    public JsonBodyListRoot(List<E> tableModelList) {
        this.tableModelList = tableModelList;
    }

    public List<E> getTableModelList() {
        return tableModelList;
    }

    public void setTableModelList(List<E> tableModelList) {
        this.tableModelList = tableModelList;
    }
}
