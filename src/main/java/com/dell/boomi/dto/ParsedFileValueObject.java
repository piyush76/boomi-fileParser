package com.dell.boomi.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by piyush_g on 2/3/2015.
 */
public class ParsedFileValueObject implements Serializable {

    private String parsedDateWithTimeZone;


    private BigDecimal amountInDollers;
    private String description;

    public ParsedFileValueObject(String parsedDateWithTimeZone, String description, BigDecimal amountInDollers) {
        this.parsedDateWithTimeZone = parsedDateWithTimeZone;
        this.description = description;
        this.amountInDollers = amountInDollers;
    }

    public String getParsedDateWithTimeZone() {
        return parsedDateWithTimeZone;
    }

    public void setParsedDateWithTimeZone(String parsedDateWithTimeZone) {
        this.parsedDateWithTimeZone = parsedDateWithTimeZone;
    }

    public BigDecimal getAmountInDollers() {
        return amountInDollers;
    }

    public void setAmountInDollers(BigDecimal amountInDollers) {
        this.amountInDollers = amountInDollers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ParsedFileValueObject{" +
                "Date='" + parsedDateWithTimeZone + '\'' +
                ", amount=" + amountInDollers +
                ", Description='" + description + '\'' +
                '}';
    }

}
