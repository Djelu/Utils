package com.fantasy.Utils.model;

import com.fantasy.Utils.entity.ICountersEntity;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import java.lang.reflect.Field;

@NoArgsConstructor
public abstract class CountersModel {

    public CountersModel(ICountersEntity entity) {
        for (Field field: entity.getClass().getDeclaredFields()) {
            if(!"countersDateEntity".equals(field.getName())) {
                fillField(field, entity);
            }
        }
    }

    @SneakyThrows
    private void fillField(Field field, ICountersEntity entity){
        field.setAccessible(true);
        final Field bookField = this.getClass().getDeclaredField(field.getName());
        bookField.setAccessible(true);
        bookField.setInt(this, field.getInt(entity));
    }
}
