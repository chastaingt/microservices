package com.microservices.limitsservice.bean;

public class Limits {
    private int max;
    private int min;

    public Limits() {
        super();
    }

    public Limits(int max, int min) {
        this.max = max;
        this.min = min;
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return this.min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
