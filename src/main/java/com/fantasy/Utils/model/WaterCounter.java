package com.fantasy.Utils.model;

import com.fantasy.Utils.entity.ICountersEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WaterCounter extends CountersModel {

    private int id;
    private int cold;
    private int hot;

    public WaterCounter(ICountersEntity entity) {
        super(entity);
    }

    public WaterCounter(int cold, int hot) {
        this.id = -1;
        this.cold = cold;
        this.hot = hot;
    }
}
