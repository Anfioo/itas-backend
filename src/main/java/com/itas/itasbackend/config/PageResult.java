package com.itas.itasbackend.config;

import com.baomidou.mybatisplus.core.metadata.IPage;


import java.util.List;


public class PageResult<T> {
    private long total;
    private List<T> records;

    public PageResult(IPage<T> page) {
        this.total = page.getTotal();
        this.records = page.getRecords();
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}
