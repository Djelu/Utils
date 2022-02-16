package com.fantasy.Utils.model.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CalculateResponse {
    private int year;
    private String month;
    private int day;
    private int night;
    private int cold;
    private int hot;

    public CalculateResponse(int year, String month, int day, int night, int cold, int hot) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.night = night;
        this.cold = cold;
        this.hot = hot;
    }
}
