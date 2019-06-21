package com.example.rish.drspectraadmin.Model;

public class DeviceDetail {
    String db_Value;
    String ear;
    String frequency;
    String frequency_Value;
    String id;
    String ownerName;
    String session;
    String timer;
    String volume;
    String updation_time;
    String connection_status;

    public DeviceDetail() {
    }

    public DeviceDetail(String id, String ownerName, String frequency, String ear, String db_Value, String frequency_Value,String volume,String session,String timer, String updation_time, String connection_status) {
        this.id = id;
        this.ownerName = ownerName;
        this.frequency = frequency;
        this.ear = ear;
        this.db_Value = db_Value;
        this.frequency_Value = frequency_Value;
        this.session = session;
        this.timer =timer;
        this.volume =volume;
        this.updation_time = updation_time;
        this.connection_status = connection_status;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getUpdation_time() {
        return updation_time;
    }

    public void setUpdation_time(String updation_time) {
        this.updation_time = updation_time;
    }

    public String getConnection_status() {
        return connection_status;
    }

    public void setConnection_status(String connection_status) {
        this.connection_status = connection_status;
    }

    public String getTimer() {
        return timer;
    }

    public void setTimer(String timer) {
        this.timer = timer;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getid() {
        return this.id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getownerName() {
        return this.ownerName;
    }

    public void setownerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getfrequency() {
        return this.frequency;
    }

    public void setfrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getear() {
        return this.ear;
    }

    public void setear(String ear) {
        this.ear = ear;
    }

    public String getdb_Value() {
        return this.db_Value;
    }

    public void setdb_Value(String db_Value) {
        this.db_Value = db_Value;
    }

    public String getfrequency_Value() {
        return this.frequency_Value;
    }

    public void setfrequency_Value(String frequency_Value) {
        this.frequency_Value = frequency_Value;
    }
}

