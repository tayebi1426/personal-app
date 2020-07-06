package me.dev.dto.datagrid;

import java.util.List;

public class DataSourceRequest {

    private Integer skip;
    private Integer take;
    private List<DataGridFilter> filter;

    public Integer getSkip() {
        return skip;
    }

    public void setSkip(Integer skip) {
        this.skip = skip;
    }

    public Integer getTake() {
        return take;
    }

    public void setTake(Integer take) {
        this.take = take;
    }

    public List<DataGridFilter> getFilter() {
        return filter;
    }

    public void setFilter(List<DataGridFilter> filter) {
        this.filter = filter;
    }
}
