package com.fantasy.Utils.service;

import com.fantasy.Utils.entity.CountersDateEntity;
import com.fantasy.Utils.entity.LightCounterEntity;
import com.fantasy.Utils.entity.WaterCounterEntity;
import com.fantasy.Utils.model.CountersDate;
import com.fantasy.Utils.model.LightCounter;
import com.fantasy.Utils.model.WaterCounter;
import com.fantasy.Utils.model.response.CalculateResponse;
import com.fantasy.Utils.repository.CountersDateRepo;
import com.fantasy.Utils.repository.LightCounterRepo;
import com.fantasy.Utils.repository.WaterCounterRepo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CountersService {

    private final LightCounterRepo lightCounterRepo;
    private final WaterCounterRepo waterCounterRepo;
    private final CountersDateRepo countersDateRepo;

    public CountersService(CountersDateRepo countersDateRepo, LightCounterRepo lightCounterRepo, WaterCounterRepo waterCounterRepo) {
        this.lightCounterRepo = lightCounterRepo;
        this.waterCounterRepo = waterCounterRepo;
        this.countersDateRepo = countersDateRepo;
    }

    private CountersDateEntity getLastCountersDateEntity(){
        return this.countersDateRepo.findFirstByOrderByYearDescMonthDesc();
    }

    private LightCounterEntity getLightCounterEntity(CountersDateEntity lastCountersDate){
        return this.lightCounterRepo.findByCountersDateEntity(lastCountersDate);
    }

    private WaterCounterEntity getWaterCounterEntity(CountersDateEntity lastCountersDate){
        return this.waterCounterRepo.findByCountersDateEntity(lastCountersDate);
    }

//    public Map<String, Object> calculateAndGetCountersData(LightCounter newLightCounter, WaterCounter newWaterCounter){
//        final CountersDateEntity lastCountersDateEntity = getLastCountersDateEntity();
//        final LightCounterEntity lightCounterEntity = getLightCounterEntity(lastCountersDateEntity);
//        final WaterCounterEntity waterCounterEntity = getWaterCounterEntity(lastCountersDateEntity);
//
//        final CountersDate countersDate = new CountersDate(lastCountersDateEntity);
//        final LightCounter lightCounters = new LightCounter(lightCounterEntity);
//        final WaterCounter waterCounters = new WaterCounter(waterCounterEntity);
//
//        return Map.of(
//            "year", countersDate.getYear(),
//            "month", countersDate.getMonth(),
//            "light", Map.of(
//                "day", newLightCounter.getDay() - lightCounters.getDay(),
//                "night", newLightCounter.getNight() - lightCounters.getNight()
//            ),
//            "water", Map.of(
//                "cold", newWaterCounter.getCold() - waterCounters.getCold(),
//                "hot", newWaterCounter.getHot() - waterCounters.getHot()
//            )
//        );
//    }

    public CalculateResponse calculateAndGetCountersData(LightCounter newLightCounter, WaterCounter newWaterCounter){
        final CountersDateEntity lastCountersDateEntity = getLastCountersDateEntity();
        final LightCounterEntity lightCounterEntity = getLightCounterEntity(lastCountersDateEntity);
        final WaterCounterEntity waterCounterEntity = getWaterCounterEntity(lastCountersDateEntity);

        final CountersDate countersDate = new CountersDate(lastCountersDateEntity);
        final LightCounter lightCounters = new LightCounter(lightCounterEntity);
        final WaterCounter waterCounters = new WaterCounter(waterCounterEntity);

        return new CalculateResponse(
                countersDate.getYear(),
                countersDate.getMonth(),
                newLightCounter.getDay() - lightCounters.getDay(),
                newLightCounter.getNight() - lightCounters.getNight(),
                newWaterCounter.getCold() - waterCounters.getCold(),
                newWaterCounter.getHot() - waterCounters.getHot()
        );
    }
}
