package com.company;

import java.io.Serializable;
import java.time.LocalDateTime;

public class PackageData implements Serializable {

    private String name;
    private String message;
    private LocalDateTime dateTime;

    @Override
    public String toString() {
        return "PackageData{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public PackageData(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public PackageData(String name, String message, LocalDateTime dateTime) {
        this.name = name;
        this.message = message;
        this.dateTime = dateTime;
    }
}
