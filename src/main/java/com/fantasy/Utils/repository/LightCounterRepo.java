package com.fantasy.Utils.repository;

import com.fantasy.Utils.entity.CountersDateEntity;
import com.fantasy.Utils.entity.LightCounterEntity;
import org.springframework.data.repository.CrudRepository;

public interface LightCounterRepo extends CrudRepository<LightCounterEntity, Integer> {
    LightCounterEntity findByCountersDateEntity(CountersDateEntity countersDateEntity);
}
