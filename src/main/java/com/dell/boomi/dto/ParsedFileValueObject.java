package com.dell.boomi.dto;

import java.util.Date;

/**
 * Created by piyush_g on 2/3/2015.
 */
public class ParsedFileValueObject {

    private Date parsedDateWithTimeZone;
    private long amountInDollers;
    private String description;

    public Date getParsedDateWithTimeZone() {
        return parsedDateWithTimeZone;
    }

    public void setParsedDateWithTimeZone(Date parsedDateWithTimeZone) {
        this.parsedDateWithTimeZone = parsedDateWithTimeZone;
    }

    public long getAmountInDollers() {
        return amountInDollers;
    }

    public void setAmountInDollers(long amountInDollers) {
        this.amountInDollers = amountInDollers;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
