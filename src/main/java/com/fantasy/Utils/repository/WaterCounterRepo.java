package com.fantasy.Utils.repository;

import com.fantasy.Utils.entity.CountersDateEntity;
import com.fantasy.Utils.entity.LightCounterEntity;
import com.fantasy.Utils.entity.WaterCounterEntity;
import org.springframework.data.repository.CrudRepository;

public interface WaterCounterRepo extends CrudRepository<WaterCounterEntity, Integer> {
    WaterCounterEntity findByCountersDateEntity(CountersDateEntity countersDateEntity);
}
