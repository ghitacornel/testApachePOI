package org.example.model;

import java.time.LocalDateTime;

public class DataModel {

    public int intValue;
    public String stringValue;
    public Double doubleValue;
    public boolean booleanValue;// only primitives allowed for boolean
    public LocalDateTime dateTimeValue;

    @Override
    public String toString() {
        return "DataModel{" +
                "intValue=" + intValue +
                ", stringValue='" + stringValue + '\'' +
                ", doubleValue=" + doubleValue +
                ", booleanValue=" + booleanValue +
                ", dateTimeValue=" + dateTimeValue +
                '}';
    }
}
