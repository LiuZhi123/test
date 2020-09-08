package com.demo.entity;

import java.io.Serializable;

public class Url implements Serializable {
    private Integer id;

    public Url(Integer id, String short_url, String long_url) {
        this.id = id;
        this.short_url = short_url;
        this.long_url = long_url;
    }

    public Url() {
    }

    private String short_url;

    private String long_url;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getShort_url() {
        return short_url;
    }

    public void setShort_url(String short_url) {
        this.short_url = short_url == null ? null : short_url.trim();
    }

    public String getLong_url() {
        return long_url;
    }

    public void setLong_url(String long_url) {
        this.long_url = long_url == null ? null : long_url.trim();
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = result*17+short_url.hashCode();
        result = result*17+long_url.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof  Url)){
            return false;
        }
        Url url = (Url) obj;
        if ( this == url){
            return true;
        }
        if (this.id.equals(url.id)&&this.short_url.equals(url.short_url)&&this.long_url.equals(url.long_url)){
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", short_url=").append(short_url);
        sb.append(", long_url=").append(long_url);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}