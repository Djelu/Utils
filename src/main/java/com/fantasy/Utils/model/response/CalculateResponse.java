package com.fantasy.Utils.model.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CalculateResponse {
    int year;
    int month;
    int day;
    int night;
    int cold;
    int hot;
}
