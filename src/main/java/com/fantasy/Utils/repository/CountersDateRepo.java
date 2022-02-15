package com.fantasy.Utils.repository;

import com.fantasy.Utils.entity.CountersDateEntity;
import org.springframework.data.repository.CrudRepository;

public interface CountersDateRepo extends CrudRepository<CountersDateEntity, Integer> {
    CountersDateEntity findFirstByOrderByYearDescMonthDesc();
}
