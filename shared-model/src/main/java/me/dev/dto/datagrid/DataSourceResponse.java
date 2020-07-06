package me.dev.dto.datagrid;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

public class DataSourceResponse<E> implements Serializable {

    public final static DataSourceResponse<Object> EMPTY_RESPONSE = new DataSourceResponse<>();

    private Integer total;
    private List<E> data;

    private DataSourceResponse() {
        this.total=0;
        this.data= Collections.emptyList();
    }

    public DataSourceResponse(Integer total, List<E> data) {
        this.total = total;
        this.data = data;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<E> getData() {
        return data;
    }

    public void setData(List<E> data) {
        this.data = data;
    }

}
