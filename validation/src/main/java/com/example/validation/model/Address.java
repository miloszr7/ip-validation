package com.example.validation.model;

public class Address {

    private String ip;

    public Address() {}

    public Address(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "Address{" +
                "ip='" + ip + '\'' +
                '}';
    }
}
