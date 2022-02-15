package com.fantasy.Utils.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculateRequest {
    private Integer day;
    private Integer night;
    private Integer cold;
    private Integer hot;

    public CalculateRequest(Integer day, Integer night, Integer cold, Integer hot) {
        this.day = day;
        this.night = night;
        this.cold = cold;
        this.hot = hot;
    }
}
