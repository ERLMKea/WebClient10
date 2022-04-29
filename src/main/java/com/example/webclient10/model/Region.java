package com.example.webclient10.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalTime;
import java.util.Objects;

@Entity
public class Region {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;
    private String regionCode;
    private String name;
    private String href;
    private String threadName;
    private LocalTime savedTm;
    private String savedTmMilli;

    public Region() {
    }

    public Region(String regionCode, String name, String href) {
        this.regionCode = regionCode;
        this.name = name;
        this.href = href;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }

    public LocalTime getSavedTm() {
        return savedTm;
    }

    public void setSavedTm(LocalTime savedTm) {
        this.savedTm = savedTm;
    }

    public String getSavedTmMilli() {
        return savedTmMilli;
    }

    public void setSavedTmMilli(String savedTmMilli) {
        this.savedTmMilli = savedTmMilli;
    }

    @Override
    public String toString() {
        return "Region{" +
                "Id=" + Id +
                ", regionCode='" + regionCode + '\'' +
                ", name='" + name + '\'' +
                ", href='" + href + '\'' +
                ", threadName='" + threadName + '\'' +
                ", savedTm=" + savedTm +
                ", savedTmMilli='" + savedTmMilli + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Region region = (Region) o;
        return Objects.equals(Id, region.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id);
    }
}
