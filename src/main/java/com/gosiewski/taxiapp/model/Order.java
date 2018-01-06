package com.gosiewski.taxiapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "orders")
public final class Order implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String user;

    private Long orderTime;

    private double lattitude;

    private double langtitude;

    private String acceptedBy;

    private boolean finished;

    public Order() {}

    public Order(String user, Long orderTime, double lattitude, double langtitude) {
        this.user = user;
        this.orderTime = orderTime;
        this.lattitude = lattitude;
        this.langtitude = langtitude;
        this.finished = false;
        this.acceptedBy = "";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Long getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Long orderTime) {
        this.orderTime = orderTime;
    }

    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLangtitude() {
        return langtitude;
    }

    public void setLangtitude(double langtitude) {
        this.langtitude = langtitude;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public String getAcceptedBy() {
        return acceptedBy;
    }

    public void setAcceptedBy(String acceptedBy) {
        this.acceptedBy = acceptedBy;
    }
}
