package com.shop.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ooo on 25.05.2017.
 */
@Entity
public class Guarantee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate startTime;
    private LocalDate endTime;
    private String guaranteeTime;


    @OneToMany(mappedBy = "guarantees")
    private List<Product> products = new ArrayList<>();


    public Guarantee() {

    }

    public Guarantee(LocalDate startTime, LocalDate endTime, String guaranteeTime) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.guaranteeTime = guaranteeTime;
    }


    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setGuaranteeTime(String guaranteeTime) {
        this.guaranteeTime = guaranteeTime;
    }

    public String getGuaranteeTime() {
        return guaranteeTime;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDate endTime) {
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    @Override
    public String toString() {
        return "Guarantee{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", guaranteeTime=" + guaranteeTime +
                ", products=" + products +
                '}';
    }
}
