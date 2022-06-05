package com.nuchange.urltrackerwithpagination.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "urlmapping")
public class UrlCount {
    @Id
    private String url;
    @Column(name = "count")
    private int count;

    public UrlCount() {
    }

    public UrlCount(String url, int count) {
        this.url = url;
        this.count = count;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
