package com.fantasy.Utils.model;

import com.fantasy.Utils.entity.ICountersEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LightCounter extends CountersModel {

    private int id;
    private int day;
    private int night;

    public LightCounter(ICountersEntity entity) {
        super(entity);
    }

    public LightCounter(int day, int night) {
        this.id = -1;
        this.day = day;
        this.night = night;
    }
}
