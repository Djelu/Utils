package com.fantasy.Utils.model;

import com.fantasy.Utils.entity.ICountersEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountersDate extends CountersModel {

    private int id;
    private int year;
    private int month;

    public CountersDate(ICountersEntity entity) {
        super(entity);
    }
}